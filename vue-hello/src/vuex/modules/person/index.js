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
   },
   utaction:"",
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
    console.log("findTeacher");
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
addBeforeTeacher({commit}){
   console.log("addBeforeTeacher");
   commit('addBeforeTeacher_m');
},


changeTeacher({commit},{data}){
  console.log(data);
   commit('changeTeacher_m',data);
},


updateTeacher({commit},{data}){
  console.log("updateTeacher");
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
      console.log("findAllTeacher_m");
      state.teacher.length=data.data.length;
      for (var i = 0; i < data.data.length; i++) {
        state.teacher[i]=data.data[i];
        console.log(state.teacher[i]);
      }
      router.push({ path: '/admin_index/admin_person_teacher' });
    },


    deleteTeacher_m(state,data){
      console.log("deleteTeacher_m");
      state.teacher.length=data.data.length
      for (var i = 0; i < data.data.length; i++) {
        state.teacher[i]=data.data[i]
        console.log(state.teacher[i]);
      }

      router.push({ path: '/admin_index/admin_person_teacher' });
    },
    findTeacher_m(state,data){
        console.log("findTeacher_m");
        state.teacher.length=1;
        state.teacher[0]=data.data
        console.log(state.teacher[0]);
        router.push({ path: '/admin_index/admin_person_teacher' });
    },
    addTeacher_m(state,data){
      console.log("addTeacher_m");
      state.teacher.length=data.data.length;
      for (var i = 0; i < data.data.length; i++) {
        state.teacher[i]=data.data[i]
        console.log(state.teacher[i]);
      }

      if(state.teacher.length==data.data.length){
        console.log("跳转到admin人事 teacher");
          router.push({ path: '/admin_index/admin_person_teacher' });
      }

    },
    addBeforeTeacher_m(state){
     console.log("addBeforeTeacher_m");
     state.utaction="1",
     state.uteacher.teaNum="",
     state.uteacher.teaName="",
     state.uteacher.teaClass="",
     state.uteacher.teaCourse="",
     state.uteacher.teaPassword=""

   },
    changeTeacher_m(state,data){
    console.log("changeTeacher_m");
     state.utaction="2",
     state.uteacher.teaNum=data.teaNum,
     state.uteacher.teaName=data.teaName,
     state.uteacher.teaClass=data.teaClass,
     state.uteacher.teaCourse=data.teaCourse,
     state.uteacher.teaPassword=data.teaPassword
   },

   updateTeacher_m(state,data){
     console.log("updateTeacher_m");
     state.teacher.length=data.data.length;
     for (var i = 0; i < data.data.length; i++) {
       state.teacher[i]=data.data[i]
       console.log(state.teacher[i]);
     }
     router.push({ path: '/admin_index/admin_person_teacher' });
   }
  }
}
