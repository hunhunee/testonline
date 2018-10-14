import axios from 'axios';
import iView from 'iview';
import router from '@/router/index'
import api from '@/api/global'
export default {
  state:{ //这里面是要读取或者写入数据的地方
      userid:"",
      password:"",
      newpassword:"",
      repassword:"",
      identity:"",
      name:"",
      usernum:"",
      admpassword:'',

  },
  getters: {
    getIdentity: state => {//通过方法访问
      return state.identity
    }
  },
  actions:{
    userLayout({commit},{data}){
     api.updateInfor(data)
     .then((response) => {
        commit('userLayout_m',response);
     })
     .catch((error)=>{
        console.log(error);
       }
     );
   }
  },
  mutations:{
    userLayout_m(state,data){
      //第一个参数state是这个模块的state 第二个参数是传进来的数据
      console.log("userLayout_m");
      console.log(data)
      if(data.data!=null){
        alert(data.data);
      }

    }
  }
}
