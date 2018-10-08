import axios from 'axios';
import iView from 'iview';
import router from '@/router/index'
import api from '@/api/global'
export default {
  state:{ //这里面是要读取或者写入数据的地方
       userid:"",
       usernum:"",
       password:"",
       identity:"",
       sex:"",
       _class:"",
       name:"",
       lesson:"",
       isLogin:0
  },
  getters: {
		getLesson: state => {//通过方法访问
		  return state.lesson
		},
    getIdentity: state => {//通过方法访问
		  return state.identity
		}
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
   },


   userLoginOut({commit}){
     console.log("userLoginOut");
       commit('userLoginOut_m');
   }
  },
  mutations:{
    userLogin_m(state,data){
      //第一个参数state是这个模块的state 第二个参数是传进来的数据
      console.log(data)
      switch (data.statusText) {
        case 'OK':
             switch (data.data.identity) {
               case '1':
                 console.log("admin登录");
                 state.usernum=data.data.usernum,
                 state.password=data.data.password,
                 state.userid=data.data.userid;
                 state.isLogin=1;
                 localStorage.setItem("isLogin",1);
                 localStorage.setItem("identity",data.data.identity);
                 localStorage.setItem("userid",data.data.userid);
                 localStorage.setItem("usernum",data.data.usernum);
                 state.sex=data.data.sex,
                 state._class=data.data._class,
                 state.name=data.data.name,
                 state.lesson=data.data.lesson,
                 console.log(localStorage.getItem("identity"));
                 router.push({ path: '/admin_index' }) ;
                 break;
               case '2':
                 console.log("Teacher登录");
                 state.usernum=data.data.usernum,
                 state.password=data.data.password,
                 state.isLogin=1;
                 localStorage.setItem("isLogin",1);
                 localStorage.setItem("identity",data.data.identity);
                 localStorage.setItem("userid",data.data.userid);
                 localStorage.setItem("_class",data.data._class);
                 localStorage.setItem("usernum",data.data.usernum);
                 localStorage.setItem("lesson",data.data.lesson);
                 state.sex=data.data.sex,
                 state._class=data.data._class,
                 state.name=data.data.name,

                 console.log(localStorage.getItem("identity"));
                 router.push({ path: '/teacher_index' }) ;
                 break;
               case '3':
                 console.log("student登录");
                 console.log("stuid");
                 console.log(data.data.userid);
                 state.usernum=data.data.usernum,
                 state.password=data.data.password,
                 state.isLogin=1;
                 localStorage.setItem("isLogin",1);
                 localStorage.setItem("identity",data.data.identity);
                 localStorage.setItem("userid",data.data.userid);
                 localStorage.setItem("usernum",data.data.usernum);
                 localStorage.setItem("_class",data.data._class);

                 state.sex=data.data.sex,
                 state._class=data.data._class,
                 state.name=data.data.name,
                 state.lesson=data.data.lesson,
                 console.log(localStorage.getItem("identity"));
                 router.push({ path: '/student_index' }) ;
                 break;
               default:
                 alert("对不起，您输入的密码或账户有误，请重新输入！")
             }
          break;
        default:

      }
    },


    userLoginOut_m(state,data){
      console.log("userLoginOut_m");
      localStorage.clear();
      router.push({ path: '/' }) ;
    }
  }
}
