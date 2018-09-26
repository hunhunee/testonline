import axios from 'axios';
import iView from 'iview';
import router from '@/router/index'
import api from '@/api/global'
export default {
  state:{ //这里面是要读取或者写入数据的地方
      admId:"",
      admName:"",
      admPassword:"",
      admNum:"",
      count:"1",

      teaId:"",
      teaName:"",
      teaPassword:"",
      teaCourse:"",
      teaNum:"",
      teaClass:"",
      count:"2",

      stuId:"",
      stuName:"",
      stuPassword:"",
      stuNum:"",
      stuClass:"",
      count:"3"

  },

  actions:{
    userLayout({commit},{data}){
      console.log("userLayout");
      console.log(data)
      if (data.password==null||data.password=="") {
       alert("原密码不能为空，请重新输入！")
     }
     //else if (data.newpassword==null||data.newpassword=="") {
    //   alert("请输入新密码！")
    // }
     //alert("修改密码成功！")

     api.layout(data)
     .then((response) => {
        commit('userLayout_m',response);
     })
     .catch((error)=>{
        console.log(error);
       }
     );
   },

   userLayout1({commit},{data}){
     console.log("userLayout1");
     console.log(data)
     if (data.password==null||data.password=="") {
           alert("已重置，请重新输入！")
   }
    api.layout1(data)
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
      console.log(data)
      switch (data.statusText) {
        case 'OK':
             switch (data.data.admId) {
               case '1':
                 console.log("AdminMessage密码修改");
                 state.admNum=data.data.admNum,
                 state.admPassword=data.data.admPassword,
                 state.admId=data.data.admId,
                 state.admName=data.data.admName,
                 router.push({ path: 'admin_message' }) ;
                 break;
                 case '2':
                 console.log("TeacherMessage密码修改");
                 state.teaNum=data.data.teaNum,
                 state.teaPassword=data.data.teaPassword,
                 state.teaId=data.data.teaId,
                 state.teaName=data.data.teaName,
                 state.teaClass=data.data.teaClass,
                 state.teaCourse=data.data.teaCourse,
                 router.push({ path: '/teacher_index/teacher_message' }) ;
                   break;
                 case '3':
                 console.log("StudentMessage密码修改");
                 state.stuNum=data.data.stuNum,
                 state.stuPassword=data.data.stuPassword,
                 state.stuId=data.data.stuId,
                 state.stuName=data.data.stuName,
                 state.stuClass=data.data.stuClass
                 router.push({ path: 'student_message' }) ;
                   break;
                 default:

               }
            break;
          default:

        }




    }
  }
}
