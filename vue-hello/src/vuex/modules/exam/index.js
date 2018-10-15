import axios from 'axios';
import iView from 'iview';
import router from '@/router/index'
import api from '@/api/global'
import Qs from 'qs'
export default {
  state:{ //这里面是要读取或者写入数据的地方
   examSingleList:[],
   examMultipleList:[],
   examJudgeList:[],
   examComputeList:[],
   examSingle:{}
  },
  getters: {

	},
  actions:{

    findExamPaper({commit},{data}){
      console.log("findExamPaper");
      console.log(data);
     api.findExamPaper(data)
     .then((response) => {
        commit('findExamPaper_m',response);
     })
     .catch((error)=>{
        console.log(error);
       }
     );
   },


   addExamResult({commit},{data}){
     console.log("addExamResult");
     console.log(data);
     commit('addExamResult_m',data);

     console.log("题目数量");
     console.log(data.examList.length);

    api.addExamResult(JSON.stringify(data))
    .then(
      req => {
        console.log(req);
    },
      (response) => {
       commit('addExamResult_m',response);
    })
    .catch((error)=>{
       console.log(error);
      }
    );
   },

 
  },
  mutations:{
    findExamPaper_m(state,data){
      console.log("findExamPaper_m");
      console.log(data)
      if(data.data.length==37){
        for (var i = 0; i < data.data.length; i++) {
          switch (data.data[i].testType) {
            case "1":

              state.examSingleList.length=state.examSingleList.length+1;
              state.examSingleList[state.examSingleList.length-1]=data.data[i];
              break;
            case "2":

              state.examMultipleList.length=state.examMultipleList.length+1;
              state.examMultipleList[state.examMultipleList.length-1]=data.data[i];
              break;
            case "3":

            state.examJudgeList.length=state.examJudgeList.length+1;
            state.examJudgeList[state.examJudgeList.length-1]=data.data[i];
              break;
            case "4":

            state.examComputeList.length=state.examComputeList.length+1;
            state.examComputeList[state.examComputeList.length-1]=data.data[i];
              break;
            default:

          }
        }
        console.log("examSingleList");
        console.log(state.examSingleList.length);
        console.log("examMultipleList");
        console.log(state.examMultipleList.length);
        console.log("examJudgeList");
        console.log(state.examJudgeList.length);
        console.log("examComputeList");
        console.log(state.examComputeList.length);

        router.push({ path: '/student_index/student_test' });
      }else{
        console.log(data.data.length);
        alert("抱歉，该科目试题不足，不能进行考试");
      }




    },



    addExamResult_m(state,data){
      state.examSingleList.length=0;
      state.examMultipleList.length=0;
      state.examJudgeList.length=0;
      state.examComputeList.length=0;
     router.push({path:'/student_index/student_test_result'})
    }
  }
}
