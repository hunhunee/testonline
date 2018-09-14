import axios from 'axios';
import iView from 'iview';
import router from '@/router/index'
import api from '@/api/global'
export default {
  state:{
    test:[],
    testType:"",
    utest:{
       testId:"",
       testContent:"",
       testAns1:"",
       testAns2:"",
       testAns3:"",
       testAns4:"",
       rightans1:"",
       rightans2:"",
       rightans3:"",
       rightans4:"",
       testCourse:"",
       testType:""
    }
  },
  getters: {
		getTestType: state => {//通过方法访问
		  return state.testType
		}
	},
  actions:{
 testType({commit},{testType}){
   commit('testType_m',testType);
 },

 findTest({commit},{data}){
   console.log(data);
  api.findTest(data)
  .then((response) => {
     commit('findTest_m',response);
  })
  .catch((error)=>{
     console.log(error);
    }
  );
},

deleteTest({commit},{data}){
  console.log(data);
 api.deleteTest(data)
 .then((response) => {
    commit('deleteTest_m',response);
 })
 .catch((error)=>{
    console.log(error);
   }
 );
},


addBeforeTest({commit}){
  console.log("add test before action ");
    commit('addBeforeTest_m');
},

addTest({commit},{data}){
  console.log(data);
 api.addTest(data)
 .then((response) => {
    commit('addTest_m',response);
 })
 .catch((error)=>{
    console.log(error);
   }
 );
},


updateBeforeTest({commit},{data}){
    commit('updateBeforeTest_m',data);
},

updateTest({commit},{data}){
  console.log(data);
 api.updateTest(data)
 .then((response) => {
    commit('updateTest_m',response);
 })
 .catch((error)=>{
    console.log(error);
   }
 );
},


  },
  mutations:{

    testType_m(state,data){
      state.testType=data;
    },

    findTest_m(state,data){
       
      for (var i = 0; i < data.data.length; i++) {
        state.test[i]=data.data[i]
      }

    },

    deleteTest_m(state,data){
      //第一个参数state是这个模块的state 第二个参数是传进来的数据
      switch (state.testType) {
        case "1":
            console.log("跳转到单选页面");
            router.push({ path: '/teacher_index/teacher_test_single' });
          break;
        case "2":
          router.push({ path: '/teacher_index/teacher_test_multiple' });
          break;
        case "3":
          router.push({ path: '/teacher_index/teacher_test_judge' });
          break;
        case "4":
          router.push({ path: '/teacher_index/teacher_test_compute' });
          break;
        default:
      }
    },


    addBeforeTest_m(state){
      console.log("add test before m");
      state.utest.testContent="",
      state.utest.testAns1="",
      state.utest.testAns2="",
      state.utest.testAns3="",
      state.utest.testAns4="",
      state.utest.rightans1="",
      state.utest.rightans2="",
      state.utest.rightans3="",
      state.utest.rightans4="",
      state.utest.testCourse="",
      state.utest.testType=""
    },

    addTest_m(state,data){
      //第一个参数state是这个模块的state 第二个参数是传进来的数据
      console.log("addtest");
      console.log(state.testType);
      switch (state.testType) {
        case 1:
            console.log("跳转到单选页面");
            router.push({ path: '/teacher_index/teacher_test_single' });
          break;
        case 2:
        console.log("跳转到多选页面");
          router.push({ path: '/teacher_index/teacher_test_multiple' });
          break;
        case 3:
        console.log("跳转到判断页面");
          router.push({ path: '/teacher_index/teacher_test_judge' });
          break;
        case 4:
        console.log("跳转到计算页面");
          router.push({ path: '/teacher_index/teacher_test_compute' });
          break;
        default:
      }
    },


    updateBeforeTest_m(state,data){
      state.utest.testId=data.testId,
      state.utest.testContent=data.testContent,
      state.utest.testAns1=data.testAns1,
      state.utest.testAns2=data.testAns2,
      state.utest.testAns3=data.testAns3,
      state.utest.testAns4=data.testAns4,
      state.utest.rightans1=data.rightans1,
      state.utest.rightans2=data.rightans2,
      state.utest.rightans3=data.rightans3,
      state.utest.rightans4=data.rightans4,
      state.utest.testCourse=data.testCourse,
      state.utest.testType=data.testType
      console.log("update before m");
      console.log(state.utest);
    },

    updateTest_m(state,data){
      //第一个参数state是这个模块的state 第二个参数是传进来的数据
      console.log("updatetest");
      console.log(state.utest.testType);
      switch (state.testType) {
        case 1:
            console.log("跳转到单选页面");
            router.push({ path: '/teacher_index/teacher_test_single' });
          break;
        case 2:
        console.log("跳转到多选页面");
          router.push({ path: '/teacher_index/teacher_test_multiple' });
          break;
        case 3:
        console.log("跳转到判断页面");
          router.push({ path: '/teacher_index/teacher_test_judge' });
          break;
        case 4:
        console.log("跳转到计算页面");
          router.push({ path: '/teacher_index/teacher_test_compute' });
          break;
        default:
      }
    },

  }
}
