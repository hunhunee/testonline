import axios from 'axios';
import iView from 'iview';
import router from '@/router/index'
import api from '@/api/global'
export default {
  state:{ //这里面是要读取或者写入数据的地方
      username:'',
      password:'',
      identity:''
  },
  actions:{
    userLogin({commit},{data}){
     api.login(data)
     .then((response) => {
        commit('userLogin_m',response);
     })
     .catch((error)=>{
        console.log(error);
       }
     );
    }
  },
  mutations:{
    userLogin_m(state,data){
      //第一个参数state是这个模块的state 第二个参数是传进来的数据
      switch (data.statusText) {
        case 'OK':
             switch (data.data.identity) {
               case '1':
                 console.log("admin登录");
                 router.push({ path: '/admin_index' }) ;
                 break;
               case '2':
                 console.log("Teacher登录");
                 router.push({ path: '/teacher_index' }) ;
                 break;
               case '3':
                 console.log("student登录");
                 router.push({ path: '/student_index' }) ;
                 break;
               default:

             }
          break;
        default:

      }
      // console.log(data);
    }
  }
}
