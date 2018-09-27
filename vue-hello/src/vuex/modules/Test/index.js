import axios from 'axios';
import iView from 'iview';
import router from '@/router/index'
import api from '@/api/global'
export default {
  state:{
    test:[],
    testType:"",
    action:"",
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
       testType:"",
       testStatus:"",
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
   console.log("findTest");
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

findAllTest ({commit},{data}){
  console.log("findAllTest");
  console.log("查询的题型：");
  console.log(data.testType);
 api.findAllTest(data)
 .then((response) => {
    commit('findAllTest_m',response);
 })
 .catch((error)=>{
    console.log(error);
   }
 );
},



deleteTest({commit},{data}){
  console.log("deleteTest");
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
  console.log("addTest");
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
   console.log("updateBeforeTest");
   console.log(data);
    commit('updateBeforeTest_m',data);
},

updateTest({commit},{data}){
  console.log("updateTest");
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
      console.log("findTest_m");
      state.test.length=data.data.length
      for (var i = 0; i < data.data.length; i++) {
        state.test[i]=data.data[i]
        console.log(state.test[i]);
      }
      console.log("用户类型：");
      console.log(localStorage.getItem("identity"));
      if(localStorage.getItem("identity")=='1'){
        console.log(state.testType);
        switch (state.testType) {
          case "1":
              console.log("跳转到admin单选页面");
              router.push({ path: '/admin_index/admin_test_single' });
            break;
          case "2":
          console.log("跳转到admin多选页面");
            router.push({ path: '/admin_index/admin_test_multiple' });
            break;
          case "3":
          console.log("跳转到admin判断页面");
            router.push({ path: '/admin_index/admin_test_judge' });
            break;
          case "4":
          console.log("跳转到admin计算页面");
            router.push({ path: '/admin_index/admin_test_compute' });
            break;
          default:
        }
      }else{

        console.log(state.testType);
         switch (state.testType) {
           case 1:
              console.log("跳转到teacher单选页面");
              router.push({ path: '/teacher_index/teacher_test_single' });
            break;
          case 2:
          console.log("跳转到teacher多选页面");
            router.push({ path: '/teacher_index/teacher_test_multiple' });
            break;
          case 3:
          console.log("跳转到teacher判断页面");
            router.push({ path: '/teacher_index/teacher_test_judge' });
            break;
          case 4:
          console.log("跳转到teacher计算页面");
            router.push({ path: '/teacher_index/teacher_test_compute' });
            break;
           default:

         }
      }

    },

    findAllTest_m(state,data){
      console.log("findAllTest_m");
      state.test.length=data.data.length
      for (var i = 0; i < data.data.length; i++) {
        state.test[i]=data.data[i]
        console.log(state.test[i]);
      }

        switch (state.testType) {
          case 1:
              console.log("跳转到admin单选页面");
              router.push({ path: '/admin_index/admin_test_single' });
            break;
          case 2:
          console.log("跳转到admin多选页面");
            router.push({ path: '/admin_index/admin_test_multiple' });
            break;
          case 3:
          console.log("跳转到admin判断页面");
            router.push({ path: '/admin_index/admin_test_judge' });
            break;
          case 4:
          console.log("跳转到admin计算页面");
            router.push({ path: '/admin_index/admin_test_compute' });
            break;
          default:
        }


    },

    deleteTest_m(state,data){
      console.log("deleteTest_m");
      state.test.length=data.data.length
      for (var i = 0; i < data.data.length; i++) {
        state.test[i]=data.data[i]
        console.log(state.test[i]);
      }

      console.log("用户类型：");
      console.log(localStorage.getItem("identity"));
      if(localStorage.getItem("identity")=='1'){
        console.log(state.testType);
        switch (state.testType) {
          case 1:
              console.log("跳转到admin单选页面");
              router.push({ path: '/admin_index/admin_test_single' });
            break;
          case 2:
          console.log("跳转到admin多选页面");
            router.push({ path: '/admin_index/admin_test_multiple' });
            break;
          case 3:
          console.log("跳转到admin判断页面");
            router.push({ path: '/admin_index/admin_test_judge' });
            break;
          case 4:
          console.log("跳转到admin计算页面");
            router.push({ path: '/admin_index/admin_test_compute' });
            break;
          default:
        }
      }else{
        console.log(state.testType);
        switch (state.testType) {
          case  1:
              console.log("跳转到teacher单选页面");
              router.push({ path: '/teacher_index/teacher_test_single' });
            break;
          case  2 :
          console.log("跳转到teacher多选页面");
            router.push({ path: '/teacher_index/teacher_test_multiple' });
            break;
          case  3 :
          console.log("跳转到teacher判断页面");
            router.push({ path: '/teacher_index/teacher_test_judge' });
            break;
          case  4 :
          console.log("跳转到teacher计算页面");
            router.push({ path: '/teacher_index/teacher_test_compute' });
            break;
          default:
        }
      }

    },


    addBeforeTest_m(state){
      console.log("add test before m");
      state.action="1",
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
      state.utest.testType="",
      state.utest.testStatus=""
    },

    addTest_m(state,data){
      //第一个参数state是这个模块的state 第二个参数是传进来的数据
      console.log("addTest_m");
      console.log("用户类型：");
      console.log(localStorage.getItem("identity"));
      state.test.length=data.data.length
      for (var i = 0; i < data.data.length; i++) {
        state.test[i]=data.data[i]
        console.log(state.test[i]);
      }
      if(localStorage.getItem("identity")=='1'){
        console.log("试题类型");
        console.log(state.testType);
        switch (state.testType) {
          case 1:
              console.log("跳转到admin单选页面");
              router.push({ path: '/admin_index/admin_test_single' });
            break;
          case 2:
          console.log("跳转到admin多选页面");
            router.push({ path: '/admin_index/admin_test_multiple' });
            break;
          case 3:
          console.log("跳转到admin判断页面");
            router.push({ path: '/admin_index/admin_test_judge' });
            break;
          case 4:
          console.log("跳转到admin计算页面");
            router.push({ path: '/admin_index/admin_test_compute' });
            break;
          default:
        }
      }else{
        console.log(state.testType);
        switch (state.testType) {
          case  1 :
              console.log("跳转到teacher单选页面");
              router.push({ path: '/teacher_index/teacher_test_single' });
            break;
          case 2 :
          console.log("跳转到teacher多选页面");
            router.push({ path: '/teacher_index/teacher_test_multiple' });
            break;
          case  3 :
          console.log("跳转到teacher判断页面");
            router.push({ path: '/teacher_index/teacher_test_judge' });
            break;
          case  4 :
          console.log("跳转到teacher计算页面");
            router.push({ path: '/teacher_index/teacher_test_compute' });
            break;
          default:
        }
      }

    },


    updateBeforeTest_m(state,data){
      state.action="2",
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
      state.utest.testType=data.testType,
      state.utest.testStatus=data.testStatus
      console.log("update before m");
      console.log(state.utest);
    },

    updateTest_m(state,data){
      //第一个参数state是这个模块的state 第二个参数是传进来的数据
      console.log("updateTest m");
      for (var i = 0; i < data.data.length; i++) {
        state.test[i]=data.data[i]
        console.log(state.test[i]);
      }
      console.log("用户类型：");state.test.length=data.data.length
      console.log(localStorage.getItem("identity"));
      if(localStorage.getItem("identity")=='1'){
        console.log(state.testType);
        switch (state.testType) {
          case 1 :
              console.log("跳转到admin单选页面");
              router.push({ path: '/admin_index/admin_test_single' });
            break;
          case 2:
          console.log("跳转到admin多选页面");
            router.push({ path: '/admin_index/admin_test_multiple' });
            break;
          case 3:
          console.log("跳转到admin判断页面");
            router.push({ path: '/admin_index/admin_test_judge' });
            break;
          case 4:
          console.log("跳转到admin计算页面");
            router.push({ path: '/admin_index/admin_test_compute' });
            break;
          default:
        }
      }else{
        console.log(state.testType);
        switch (state.testType) {
          case  1 :
              console.log("跳转到teacher单选页面");
              router.push({ path: '/teacher_index/teacher_test_single' });
            break;
          case  2 :
          console.log("跳转到teacher多选页面");
            router.push({ path: '/teacher_index/teacher_test_multiple' });
            break;
          case  3 :
          console.log("跳转到teacher判断页面");
            router.push({ path: '/teacher_index/teacher_test_judge' });
            break;
          case  4 :
          console.log("跳转到teacher计算页面");
            router.push({ path: '/teacher_index/teacher_test_compute' });
            break;
          default:
        }
      }

    },

  }
}
