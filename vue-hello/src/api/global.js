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

  //删除科目信息之前，先判断有没有老师所教
  findTeacherByLesson: function (data) {
    return axios({
      headers: {
        'deviceCode': 'A95ZEF1-47B5-AC90BF3'
      },
      method: 'post',
      url: '/api/personManage/findTeacherByLesson',
      data:Qs.stringify(data)
    });
  },
  //在添加科目信息之前，先判断科目是否已存在
  findLessonByLesNameAndByLesId: function (data) {
    return axios({
      headers: {
        'deviceCode': 'A95ZEF1-47B5-AC90BF3'
      },
      method: 'post',
      url: '/api/LessonManage/findLessonByLesNameAndByLesId',
      data:Qs.stringify(data)
    });
  },


findTeacherByClass: function (data) {
return axios({
   headers: {
       'deviceCode': 'A95ZEF1-47B5-AC90BF3'
   },
   method: 'post',
   url: '/api/personManage/findTeacherByClass',
   data:Qs.stringify(data)

 });
},

findStudentByClass: function (data) {
return axios({
   headers: {
       'deviceCode': 'A95ZEF1-47B5-AC90BF3'
   },
   method: 'post',
   url: '/api/personManage/findStudentByClass',
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



  //----学生考试成绩----
  findStudnetScore: function (data) {
    console.log(data)
    return axios({
      headers: {
        'deviceCode': 'A95ZEF1-47B5-AC90BF3'
      },
      method: 'post',
      url: '/api/score/findStudentScore',
      data:Qs.stringify(data)
    });
  },

  deleteStudnetScore: function (data) {
    console.log(data)
    return axios({
      headers: {
        'deviceCode': 'A95ZEF1-47B5-AC90BF3'
      },
      method: 'post',
      url: '/api/score/deleteStudentScore',
      data:Qs.stringify(data)
    });
  },


deleteLesson: function (data) {
return axios({
   headers: {
       'deviceCode': 'A95ZEF1-47B5-AC90BF3'
   },
   method: 'post',
   url: '/api/LessonManage/deleteLesson',
   data:Qs.stringify(data)
 });
},


  //---查询最高、低、平均成绩----
  findMinAndMaxAndAvgScore: function (data) {
    return axios({
      headers: {
        'deviceCode': 'A95ZEF1-47B5-AC90BF3'
      },
      method: 'post',
      url: '/api/score/findMinAndMaxAndAvgScore',
      data:Qs.stringify(data)
    });
  },


  //----统计不同区间成绩的个数----
  findScoreScope: function (data) {
    console.log(data)
    return axios({
      headers: {
        'deviceCode': 'A95ZEF1-47B5-AC90BF3'
      },
      method: 'post',
      url: '/api/score/findScoreScope',
      data:Qs.stringify(data)
    });
  },

  //教师查询所教班级及科目的同学的成绩 --教师
  findByClassAndByLenName: function (data) {
    console.log(data)
    return axios({
      headers: {
        'deviceCode': 'A95ZEF1-47B5-AC90BF3'
      },
      method: 'post',
      url: '/api/score/findByClassAndByLenName',
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


//个人信息维护--修改密码
updateInfo: function (data) {
return axios({
 headers: {
     'deviceCode': 'A95ZEF1-47B5-AC90BF3'
 },
 method: 'post',
 url: '/api/infoManage/updateInfo',
 data:Qs.stringify(data)

});
},


  //
  findByStuNum: function (data) {
    console.log(data)
    return axios({
      headers: {
        'deviceCode': 'A95ZEF1-47B5-AC90BF3'
      },
      method: 'post',
      url: '/api/score/findByStuNum',
      data:Qs.stringify(data)
    });
  },


  findAllClass: function () {
  return axios({
     headers: {
         'deviceCode': 'A95ZEF1-47B5-AC90BF3'
     },
     method: 'post',
     url: '/api/ClassManage/findAllClass'
   });
  },
  findClass: function (data) {
  return axios({
     headers: {
         'deviceCode': 'A95ZEF1-47B5-AC90BF3'
     },
     method: 'post',
     url: '/api/ClassManage/findClassByName',
     data:Qs.stringify(data)
   });
  },
  findClassById: function (data) {
  return axios({
     headers: {
         'deviceCode': 'A95ZEF1-47B5-AC90BF3'
     },
     method: 'post',
     url: '/api/ClassManage/findClassById',
     data:Qs.stringify(data)
   });
  },

  addClass: function (data) {
  return axios({
     headers: {
         'deviceCode': 'A95ZEF1-47B5-AC90BF3'
     },
     method: 'post',
     url: '/api/ClassManage/addClass',
     data:Qs.stringify(data)
   });
   },

  updateClass: function (data) {
  return axios({
     headers: {
         'deviceCode': 'A95ZEF1-47B5-AC90BF3'
     },
     method: 'post',
     url: '/api/ClassManage/updateClass',
     data:Qs.stringify(data)

   });
  },

  deleteClass: function (data) {
  return axios({
     headers: {
         'deviceCode': 'A95ZEF1-47B5-AC90BF3'
     },
     method: 'post',
     url: '/api/ClassManage/deleteClass',
     data:Qs.stringify(data)
   });
  },


}
