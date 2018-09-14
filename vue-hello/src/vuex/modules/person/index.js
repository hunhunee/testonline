import axios from 'axios';
import iView from 'iview';
import router from '@/router/index'
import api from '@/api/global'
export default {
  state:{
   teacher:[],
   uteacher:{
     teaNum:"",
     teaName:"",
     teaClass:"",
     teaCourse:"",
     teaPassword:""
   }
  },
  actions:{
    findAllTeacher({commit}){
     api.findAllTeacher()
     .then((response) => {
        commit('findAllTeacher_m',response);
     })
     .catch((error)=>{
        console.log(error);
       }
     );
   },
   deleteTeacher({commit},{data}){
     console.log(data);
    api.deleteTeacher(data)
    .then((response) => {
       commit('deleteTeacher_m',response);
    })
    .catch((error)=>{
       console.log(error);
      }
    );
  },
  findTeacher({commit},{data}){
    console.log(data);
   api.findTeacher(data)
   .then((response) => {
      commit('findTeacher_m',response);
   })
   .catch((error)=>{
      console.log(error);
     }
   );
 },
 addTeacher({commit},{data}){
   console.log(data);
  api.addTeacher(data)
  .then((response) => {
     commit('addTeacher_m',response);
  })
  .catch((error)=>{
     console.log(error);
    }
  );
},
addBeforeTeacher({commit},{data}){
  console.log(data);
   commit('addBeforeTeacher_m',data);
},
changeTeacher({commit},{data}){
  console.log(data);
   commit('changeTeacher_m',data);
},
updateTeacher({commit},{data}){
  console.log(data);
 api.updateTeacher(data)
 .then((response) => {
    commit('updateTeacher_m',response);
 })
 .catch((error)=>{
    console.log(error);
   }
 );
}
  },
  mutations:{
    findAllTeacher_m(state,data){
      //第一个参数state是这个模块的state 第二个参数是传进来的数据
      for (var i = 0; i < data.data.length; i++) {
        state.teacher[i]=data.data[i];
      }
    },
    deleteTeacher_m(state,data){
      //第一个参数state是这个模块的state 第二个参数是传进来的数据
      for (var i = 0; i < data.data.length; i++) {
        state.teacher[i]=data.data[i]
        //console.log(state.teacher[i]);
      }
    },
    findTeacher_m(state,data){
      //第一个参数state是这个模块的state 第二个参数是传进来的数据

        state.teacher[0]=data.data
        //console.log(state.teacher[0]);

    },
    addTeacher_m(state,data){
      //第一个参数state是这个模块的state 第二个参数是传进来的数据
      for (var i = 0; i < data.data.length; i++) {
        state.teacher[i]=data.data[i]
        console.log(state.teacher[i]);
      }

    },
    addBeforeTeacher_m(state,data){
     state.uteacher.teaNum=null,
     state.uteacher.teaName=null,
     state.uteacher.teaClass=null,
     state.uteacher.teaCourse=null,
     state.uteacher.teaPassword=null
     console.log(state.uteacher.teaPassword);
   },
    changeTeacher_m(state,data){
     state.uteacher.teaNum=data.teaNum,
     state.uteacher.teaName=data.teaName,
     state.uteacher.teaClass=data.teaClass,
     state.uteacher.teaCourse=data.teaCourse,
     state.uteacher.teaPassword=data.teaPassword
     console.log(state.uteacher.teaPassword);
   },
   updateTeacher_m(state,data){
     console.log(data.data.teaName);
   }
  }
}
