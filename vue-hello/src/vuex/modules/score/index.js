import axios from 'axios';
import iView from 'iview';
import router from '@/router/index'
import api from '@/api/global'

export default {
  state: {
    score: [],
    scoretatil:[],
    scoretatil2:[],
    score1:[],
    stu: {
      stuNum: "",
      stuName: "",
      stuClass: "",
      lesName: "",
      totalscore: ""
    }
  },
  setter:{
    setScoreLength: state => {//通过方法访问
		 state.score1.length=0
		},
  },
  //前端把数据传到后台
  actions: {
    //student这个数据是从StudentIndex.vue传过来的，里面存的值是学生的学号
    //查询学生的成绩
    findStudnetScore({commit}, {student}) {
      console.log("findStudnetScore")
      console.log(student)
      api.findStudnetScore(student)
        .then((response) => {
          commit('findStudnetScore_m', response);
        })
        .catch((error) => {
            console.log(error);
          }
        );
    },
    //查询最高最低平均分
    findMinAndMaxAndAvgScore({commit}, {scoretatil}) {
      console.log("findMinAndMaxAndAvgScore")
      console.log(scoretatil)
      api.findMinAndMaxAndAvgScore(scoretatil)
        .then((response) => {
          commit('findMinAndMaxAndAvgScore_m', response);
        })
        .catch((error) => {
            console.log(error);
          }
        );
    },
    //统计区间的成绩个数
    findScoreScope({commit}, {scoretatil}) {
      console.log("findScoreScope")
      console.log(scoretatil)
      api.findScoreScope(scoretatil)
        .then((response) => {
          commit('findScoreScope_m', response);
        })
        .catch((error) => {
            console.log(error);
          }
        );
    },
    //教师查询所教班级及科目的同学的成绩 --教师
    findByClassAndByLenName({commit}, {scoretatil}) {
      console.log("findByClassAndByLenName")
      console.log(scoretatil)
      api.findByClassAndByLenName(scoretatil)
        .then((response) => {
          commit('findByClassAndByLenName_m', response);
        })
        .catch((error) => {
            console.log(error);
          }
        );
    },
    //教师查询学生信息by学生学号
    findByStuNum({commit}, {data}) {
      console.log("findByStuNum")
      console.log(data)
      api.findByStuNum(data)
        .then((response) => {
          commit('findByStuNum_m', response);
        })
        .catch((error) => {
            console.log(error);
          }
        );
    },
  },
  //从后端得到数据储存到vuex，前端从这里获取数据
  mutations: {
    //查询学生的分数
    findStudnetScore_m(state, data) {
      console.log("findStudnetScore_m");
      state.score.length = data.data[0].studentAnswer.length;
      console.log(data.data);
      for (var i = 0; i < data.data[0].studentAnswer.length; i++) {
        state.score[i] = data.data[0].studentAnswer[i]
      }

      router.push({path: '/student_index/student_test_result'});
    },
    //查询最高最低平均分
    findMinAndMaxAndAvgScore_m(state, data) {
      console.log("findMinAndMaxAndAvgScore_m");
      console.log(data.data)
      state.scoretatil[0]=data.data.maxscore,
      state.scoretatil[1]=data.data.minscore,
      state.scoretatil[2]=data.data.avgscore,
      console.log(state.scoretatil);
      router.push({path: '/teacher_index/teacher_test_result'});
    },
    //统计区间的成绩个数
    findScoreScope_m(state, data) {
      console.log("findScoreScope_m");
      console.log(data.data)
      state.scoretatil2[0]=data.data.zeroToFiftyNine,
      state.scoretatil2[1]=data.data.sixtyToSeventyNine,
      state.scoretatil2[2]=data.data.eightyToeightyNine,
      state.scoretatil2[3]=data.data.ninetyToHundred,
      console.log(state.scoretatil2);
      router.push({path: '/teacher_index/teacher_test_result'});
    },
    //教师查询所教班级及科目的同学的成绩 --教师
    findByClassAndByLenName_m(state, data) {
      console.log("findByClassAndByLenName_m");
      console.log(data.data)
      state.score1.length = data.data.length;
      console.log(data.data);
      for (var i = 0; i < data.data.length; i++) {
        state.score1[i] = data.data[i]
      }
      router.push({path: '/teacher_index/teacher_test_result_select'});
    },

    //教师查询学生信息by学生学号
   findByStuNum_m(state, data) {
      console.log("findByStuNum_m");
       state.score1.length =data.data.length
       for (var i = 0; i < data.data.length; i++) {
         state.score1[i]=data.data[i]
       }
        router.push({path: '/teacher_index/teacher_test_result_select'});

    },
  }
}
