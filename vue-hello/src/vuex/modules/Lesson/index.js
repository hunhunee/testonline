import axios from 'axios';
import iView from 'iview';
import router from '@/router/index'
import api from '@/api/global'
export default {
  state:{
   lesson:[],
   lessonId:[],
   lessonName:[],
   ulesson:{
     // lesId:"",switch (zzzz) {
     //   case expression:
     //
     //     break;
     //   default:
     //
     // }
     lesName:"",

   },
   utaction:"",
  },
  actions:{
    findAllLesson({commit}){
     api.findAllLesson()
     .then((response) => {
        commit('findAllLesson_m',response);
     })
     .catch((error)=>{
        console.log(error);
       }
     );
   },



   deleteLesson({commit},{data}){
     console.log(data);
    api.deleteLesson(data)
    .then((response) => {
       commit('deleteLesson_m',response);
    })
    .catch((error)=>{
       console.log(error);
      }
    );
  },


  findLesson({commit},{data}){
    console.log("findLesson");
    console.log(data);
   api.findLesson(data)
   .then((response) => {
      commit('findLesson_m',response);
   })
   .catch((error)=>{
      console.log(error);
     }
   );
 },


 addLesson({commit},{data}){
   console.log(data);
  api.addLesson(data)
  .then((response) => {
     commit('addLesson_m',response);
  })
  .catch((error)=>{
     console.log(error);
    }
  );
},
addBeforeLesson({commit}){
   console.log("addBeforeLesson");
   commit('addBeforeLesson_m');
},


changeLesson({commit},{data}){
  console.log(data);
   commit('changeLesson_m',data);
},


updateLesson({commit},{data}){
  console.log("updateLesson");
  console.log(data);
 api.updateLesson(data)
 .then((response) => {
    commit('updateLesson_m',response);
 })
 .catch((error)=>{
    console.log(error);
   }
 );
}
  },
  mutations:{
    findAllLesson_m(state,data){
      console.log("findAllLesson_m");

      state.lesson.length=data.data.length;
      for (var i = 0; i < data.data.length; i++) {
        state.lesson[i]=data.data[i];
        state.lessonId[i]=data.data[i].lesId;
        console.log(state.lessonId[i]);
        state.lessonName[i]=data.data[i].lesName;
        console.log(state.lessonName[i]);
      }
     localStorage.setItem("lessonIdList",state.lessonId),
     localStorage.setItem("lessonNameList",state.lessonName),


      router.push({ path: '/admin_index/admin_Lesson' });
    },


    deleteLesson_m(state,data){
      console.log("deleteLesson_m");
      state.lesson.length=data.data.length;

      state.lessonId.length=data.data.length;
      state.lessonName.length=data.data.length;
      for (var i = 0; i < data.data.length; i++) {
        state.lesson[i]=data.data[i];
        state.lessonId[i]=data.data[i].lesId;
        console.log(state.lessonId[i]);
        state.lessonName[i]=data.data[i].lesName;
        console.log(state.lessonName[i]);
      }
     localStorage.setItem("lessonIdList",state.lessonId),
     localStorage.setItem("lessonNameList",state.lessonName),


      router.push({ path: '/admin_index/admin_Lesson'});
    },

    findLesson_m(state,data){
        console.log("findLesson_m");
        state.lesson.length=1;
        state.lesson[0]=data.data
        console.log(data.data);
        router.push({ path: '/admin_index/admin_Lesson' });
    },
    addLesson_m(state,data){
      console.log("addLesson_m");
      state.lesson.length=data.data.length;
      state.lessonId.length=data.data.length;
      state.lessonName.length=data.data.length;
      for (var i = 0; i < data.data.length; i++) {
        state.lesson[i]=data.data[i];
        state.lessonId[i]=data.data[i].lesId;
        console.log(state.lessonId[i]);
        state.lessonName[i]=data.data[i].lesName;
        console.log(state.lessonName[i]);
      }
     localStorage.setItem("lessonIdList",state.lessonId),
     localStorage.setItem("lessonNameList",state.lessonName)

      if(state.lesson.length==data.data.lesson){
        console.log("跳转到admin科目 Lesson");
          router.push({ path: '/admin_index/admin_Lesson' });
      }

    },
    addBeforeLesson_m(state){
     console.log("addBeforeLesson_m");
     state.utaction="1",
     state.ulesson.lesId="",
     state.ulesson.lesName=""
   },
    changeLesson_m(state,data){
    console.log("changeLesson_m");
     state.utaction="2",
     state.ulesson.lesId=data.lesId,
     state.ulesson.lesName=data.lesName
   },

   updateLesson_m(state,data){
     console.log("updateLesson_m");
     state.lesson.length=data.data.length;
     state.lessonId.length=data.data.length;
     state.lessonName.length=data.data.length;
     for (var i = 0; i < data.data.length; i++) {
       state.lesson[i]=data.data[i];
       state.lessonId[i]=data.data[i].lesId;
       console.log(state.lessonId[i]);
       state.lessonName[i]=data.data[i].lesName;
       console.log(state.lessonName[i]);
     }
    localStorage.setItem("lessonIdList",state.lessonId),
    localStorage.setItem("lessonNameList",state.lessonName),
     router.push({ path: '/admin_index/admin_Lesson' });
   }
  }
}
