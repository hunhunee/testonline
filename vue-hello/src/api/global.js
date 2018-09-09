
import Vue from 'vue'
import axios from 'axios'
import Qs from 'qs'
export default {
    //登录接口
    login: function (data) {
    return axios({
       headers: {
           'deviceCode': 'A95ZEF1-47B5-AC90BF3'
       },
       method: 'post',
       url: '/api/test',
       data: Qs.stringify(data)
     });
   }




}
