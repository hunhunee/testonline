import axios from 'axios';
import iView from 'iview';
import router from '@/router/index'
import api from '@/api/global'
export default {
  state:{ //这里面是要读取或者写入数据的地方

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
    }
  },
  mutations:{
    findExamPaper_m(state,data){
      console.log("findExamPaper_m");
      console.log(data)

    }
  }
}
