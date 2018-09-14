
import Vue from 'vue'
import axios from 'axios'
import Qs from 'qs'
export default {
    //登录接口
    login: function (data) {
    return axios({
       headers: {
           'deviceCode': ' '
       },
       method: 'post',
       url: '/api/login',
       data: Qs.stringify(data)
     });
   },
   findAllTeacher: function () {
   return axios({
      headers: {
          'deviceCode': 'A95ZEF1-47B5-AC90BF3'
      },
      method: 'post',
      url: '/api/personManage/findAllTeacher'
    });
  },
  deleteTeacher: function (data) {
  return axios({
     headers: {
         'deviceCode': 'A95ZEF1-47B5-AC90BF3'
     },
     method: 'post',
     url: '/api/personManage/deleteTeacher',
     data:Qs.stringify(data)

   });
 },

 findTeacher: function (data) {
 return axios({
    headers: {
        'deviceCode': 'A95ZEF1-47B5-AC90BF3'
    },
    method: 'post',
    url: '/api/personManage/findTeacher',
    data:Qs.stringify(data)

  });
},

addTeacher: function (data) {
return axios({
   headers: {
       'deviceCode': 'A95ZEF1-47B5-AC90BF3'
   },
   method: 'post',
   url: '/api/personManage/addTeacher',
   data:Qs.stringify(data)

 });
},

updateTeacher: function (data) {
return axios({
   headers: {
       'deviceCode': 'A95ZEF1-47B5-AC90BF3'
   },
   method: 'post',
   url: '/api/personManage/updateTeacher',
   data:Qs.stringify(data)

 });
},

findTest: function (data) {
return axios({
   headers: {
       'deviceCode': 'A95ZEF1-47B5-AC90BF3'
   },
   method: 'post',
   url: '/api/testManage/find',
   data:Qs.stringify(data)

 });

},

deleteTest: function (data) {
return axios({
   headers: {
       'deviceCode': 'A95ZEF1-47B5-AC90BF3'
   },
   method: 'post',
   url: '/api/testManage/delete',
   data:Qs.stringify(data)

 });
},


addTest: function (data) {
return axios({
   headers: {
       'deviceCode': 'A95ZEF1-47B5-AC90BF3'
   },
   method: 'post',
   url: '/api/testManage/add',
   data:Qs.stringify(data)
 });
},

updateTest: function (data) {
return axios({
   headers: {
       'deviceCode': 'A95ZEF1-47B5-AC90BF3'
   },
   method: 'post',
   url: '/api/testManage/update',
   data:Qs.stringify(data)
 });
},





}
