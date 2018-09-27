
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

  findAllStudent: function () {
  return axios({
     headers: {
       'deviceCode': 'A95ZEF1-47B5-AC90BF3'
     },
     method: 'post',
     url: '/api/personManage/findAllStudent'
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
  //---------------删除学生-----------
  deleteStudent: function (data) {
    return axios({
      headers: {
        'deviceCode': 'A95ZEF1-47B5-AC90BF3'
      },
      method: 'post',
      url: '/api/personManage/deleteStudent',
      data:Qs.stringify(data)

    });
  },
  //---------------删除学生-----------
  deleteStudent: function (data) {
    return axios({
      headers: {
        'deviceCode': 'A95ZEF1-47B5-AC90BF3'
      },
      method: 'post',
      url: '/api/personManage/deleteStudent',
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
  //----查询单个学生----
  findStudent: function (data) {
    return axios({
      headers: {
        'deviceCode': 'A95ZEF1-47B5-AC90BF3'
      },
      method: 'post',
      url: '/api/personManage/findStudent',
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
//------增加学生------
 addStudent: function (data) {
    return axios({
      headers: {
        'deviceCode': 'A95ZEF1-47B5-AC90BF3'
      },
      method: 'post',
      url: '/api/personManage/addStudent',
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
  //------修改学生-----
  updateStudent: function (data) {
    return axios({
      headers: {
        'deviceCode': 'A95ZEF1-47B5-AC90BF3'
      },
      method: 'post',
      url: '/api/personManage/updateStudent',
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

findAllTest: function (data) {
return axios({
   headers: {
       'deviceCode': 'A95ZEF1-47B5-AC90BF3'
   },
   method: 'post',
   url: '/api/testManage/findAll',
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


findExamPaper: function (data) {
return axios({
   headers: {
       'deviceCode': 'A95ZEF1-47B5-AC90BF3'
   },
   method: 'post',
   url: '/api/exam/findExamPaper',
   data:Qs.stringify(data)
 });
},

findAllLesson: function () {
return axios({
   headers: {
       'deviceCode': 'A95ZEF1-47B5-AC90BF3'
   },
   method: 'post',
   url: '/api/LessonManage/findAllLesson'
 });
},
findLesson: function (data) {
return axios({
   headers: {
       'deviceCode': 'A95ZEF1-47B5-AC90BF3'
   },
   method: 'post',
   url: '/api/LessonManage/findLessonByName',
   data:Qs.stringify(data)
 });
},

addExamResult: function (data) {
  var params = new URLSearchParams();
  params.append('examList',data);

return axios({
   headers: {
       'deviceCode': 'A95ZEF1-47B5-AC90BF3'
   },
   method: 'post',
   url: '/api/exam/addExamResult',

   data:params

 });
},
updateAdmin: function (data) {
  return axios({
     headers: {
         'deviceCode': 'A95ZEF1-47B5-AC90BF3'
     },
     method: 'post',
     url: '/api/inforManage/updateAdmin',
     data:Qs.stringify(data)
});
},




updateTeacher: function (data) {
  return axios({
     headers: {
         'deviceCode': 'A95ZEF1-47B5-AC90BF3'
     },
     method: 'post',
     url: '/api/inforManage/updateTeacher',
     data:Qs.stringify(data)
 });
 },



updateStudent: function (data) {
return axios({
   headers: {
       'deviceCode': 'A95ZEF1-47B5-AC90BF3'
   },
   method: 'post',
   url: '/api/inforManage/updateStudent',
   data:Qs.stringify(data)
 });
},


deleteLesson: function (data) {
return axios({
   headers: {
       'deviceCode': 'A95ZEF1-47B5-AC90BF3'
   },
   method: 'post',
   url: '/api/inforManage/updateAdmin',
   url: '/api/LessonManage/deleteLesson',

   data:Qs.stringify(data)
 });
},

addLesson: function (data) {
return axios({
   headers: {
       'deviceCode': 'A95ZEF1-47B5-AC90BF3'
   },
   method: 'post',
   url: '/api/LessonManage/addLesson',
   data:Qs.stringify(data)
 });
 },

updateLesson: function (data) {
return axios({
   headers: {
       'deviceCode': 'A95ZEF1-47B5-AC90BF3'
   },
   method: 'post',
   url: '/api/LessonManage/updateLesson',
   data:Qs.stringify(data)

 });
},

}
