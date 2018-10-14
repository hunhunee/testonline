import axios from 'axios';
import iView from 'iview';
import router from '@/router/index'
import api from '@/api/global'
export default {
  state:{
   class:[],
   classId:[],
   className:[],
   uclass:{
     // lesId:"",switch (zzzz) {
     //   case expression:
     //
     //     break;
     //   default:
     //
     // }
     className:"",

   },
   utaction:"",
  },
  actions:{
    findAllClass({commit}){
     api.findAllClass()
     .then((response) => {
        commit('findAllClass_m',response);
     })
     .catch((error)=>{
        console.log(error);
       }
     );
   },



   deleteClass({commit},{data}){
     console.log(data);
    api.deleteClass(data)
    .then((response) => {
       commit('deleteClass_m',response);
    })
    .catch((error)=>{
       console.log(error);
      }
    );
  },


  findClass({commit},{data}){
    console.log("findClass");
    console.log(data);
   api.findClass(data)
   .then((response) => {
      commit('findClass_m',response);
   })
   .catch((error)=>{
      console.log(error);
     }
   );
 },


 addClass({commit},{data}){
   console.log(data);
  api.addClass(data)
  .then((response) => {
     commit('addClass_m',response);
  })
  .catch((error)=>{
     console.log(error);
    }
  );
},
addBeforeClass({commit}){
   console.log("addBeforeClass");
   commit('addBeforeClass_m');
},


changeClass({commit},{data}){
  console.log(data);
   commit('changeClass_m',data);
},


updateClass({commit},{data}){
  console.log("updateClass");
  console.log(data);
 api.updateClass(data)
 .then((response) => {
    commit('updateClass_m',response);
 })
 .catch((error)=>{
    console.log(error);
   }
 );
}
  },
  mutations:{
    findAllClass_m(state,data){
      console.log("findAllClass_m");

      state.class.length=data.data.length;
      for (var i = 0; i < data.data.length; i++) {
        state.class[i]=data.data[i];
        state.classId[i]=data.data[i].classId;
        console.log(state.classId[i]);
        state.className[i]=data.data[i].className;
        console.log(state.className[i]);
      }
     localStorage.setItem("classIdList",state.classId),
     localStorage.setItem("classNameList",state.className),


      router.push({ path: '/admin_index/admin_Class' });
    },


    deleteClass_m(state,data){
      console.log("deleteClass_m");
      state.class.length=data.data.length;

      state.classId.length=data.data.length;
      state.className.length=data.data.length;
      for (var i = 0; i < data.data.length; i++) {
        state.class[i]=data.data[i];
        state.classId[i]=data.data[i].classId;
        console.log(state.classId[i]);
        state.className[i]=data.data[i].className;
        console.log(state.className[i]);
      }
     localStorage.setItem("classIdList",state.classId),
     localStorage.setItem("classNameList",state.className),


      router.push({ path: '/admin_index/admin_class'});
    },

    findClass_m(state,data){
        console.log("findClass_m");
        state.class.length=data.data.length;
        for (var i = 0; i < data.data.length; i++) {
          state.class[i]=data.data[i];
          state.classId[i]=data.data[i].classId;
          console.log(state.classId[i]);
          state.className[i]=data.data[i].className;
          console.log(state.className[i]);
        }
        console.log(data.data);
        router.push({ path: '/admin_index/admin_Class' });
    },
    addClass_m(state,data){
      console.log("addClass_m");
      console.log(data.data);
      state.class.length=data.data.length;
      state.classId.length=data.data.length;
      state.className.length=data.data.length;
      for (var i = 0; i < data.data.length; i++) {
        state.class[i]=data.data[i];
        state.classId[i]=data.data[i].classId;
        console.log(state.classId[i]);
        state.className[i]=data.data[i].className;
        console.log(state.className[i]);
      }
     localStorage.setItem("classIdList",state.classId),
     localStorage.setItem("classNameList",state.className)

      if(state.class.length==data.data.lesson){
        console.log("跳转到admin班级 class");
          router.push({ path: '/admin_index/admin_Class' });
      }

    },
    addBeforeClass_m(state){
     console.log("addBeforeClass_m");
     state.utaction="1",
     state.uclass.classId="",
     state.uclass.className=""
   },
    changeClass_m(state,data){
    console.log("changeClass_m");
     state.utaction="2",
     state.uclass.classId=data.classId,
     state.uclass.className=data.className
   },

   updateClass_m(state,data){
     console.log("updateClass_m");
     state.class.length=data.data.length;
     state.classId.length=data.data.length;
     state.className.length=data.data.length;
     for (var i = 0; i < data.data.length; i++) {
       state.class[i]=data.data[i];
       state.classId[i]=data.data[i].classId;
       console.log(state.classId[i]);
       state.className[i]=data.data[i].className;
       console.log(state.className[i]);
     }
    localStorage.setItem("classIdList",state.classId),
    localStorage.setItem("classNameList",state.className),
     router.push({ path: '/admin_index/admin_Class' });
   }
  }
}
