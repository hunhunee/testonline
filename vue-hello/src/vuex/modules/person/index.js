import axios from 'axios';
import iView from 'iview';
import router from '@/router/index'
import api from '@/api/global'

export default {
  state: {
    teacher: [],
    uteacher: {
      teaNum: "",
      teaName: "",
      teaClass: "",
      teaCourse: "",
      teaPassword: ""
    },
    student: [],
    ustudent: {
      stuName: "",
      stuPassword: "",
      stuSex: "",
      stuNum: "",
      stuClass: "",
    },
    utaction: "",
  },
  actions: {
    findAllTeacher({commit}) {
      api.findAllTeacher()
        .then((response) => {
          commit('findAllTeacher_m', response);
        })
        .catch((error) => {
            console.log(error);
          }
        );
    },
    //------查询所有学生-------
    findAllStudent({commit}) {
      api.findAllStudent()
        .then((response) => {
          commit('findAllStudent_m', response);
        })
        .catch((error) => {
            console.log(error);
          }
        );
    },


    deleteTeacher({commit}, {data}) {
      console.log(data);
      api.deleteTeacher(data)
        .then((response) => {
          commit('deleteTeacher_m', response);
        })
        .catch((error) => {
            console.log(error);
          }
        );
    },
    //-------删除学生---------
    deleteStudent({commit}, {data}) {
      console.log(data);
      api.deleteStudent(data)
        .then((response) => {
          commit('deleteStudent_m', response);
        })
        .catch((error) => {
            console.log(error);
          }
        );
    },

    findTeacher({commit}, {data}) {
      console.log("findTeacher");
      console.log(data);
      api.findTeacher(data)
        .then((response) => {
          commit('findTeacher_m', response);
        })
        .catch((error) => {
            console.log(error);
          }
        );
    },


    findTeacherByClass({commit}, {teacher}) {
      console.log("findTeacherByClass");
      console.log(teacher);
      api.findTeacherByClass(teacher)
        .then((response) => {
          commit('findTeacherByClass_m', response);
        })
        .catch((error) => {
            console.log(error);
          }
        );
    },

    findStudentByClass({commit}, {student}) {
      console.log("findStudentByClass");
      console.log(student);
      api.findStudentByClass(student)
        .then((response) => {
          commit('findStudentByClass_m', response);
        })
        .catch((error) => {
            console.log(error);
          }
        );
    },
    //----查询学生----
     findStudent({commit}, {data}) {
      console.log("findStudent");
      console.log(data);
      api.findStudent(data)
        .then((response) => {
          commit('findStudent_m', response);
        })
        .catch((error) => {
            console.log(error);
          }
        );
    },
    addTeacher({commit}, {data}) {
      console.log("addTeacher");
      console.log(data);
      api.addTeacher(data)
        .then((response) => {
          commit('addTeacher_m', response);
        })
        .catch((error) => {
            console.log(error);
          }
        );
    },
    //-----添加学生-----
    addStudent({commit}, {data}) {
      console.log(data);
      api.addStudent(data)
        .then((response) => {
          commit('addStudent_m', response);
        })
        .catch((error) => {
            console.log(error);
          }
        );
    },
    addBeforeTeacher({commit}) {
      console.log("addBeforeTeacher");
      commit('addBeforeTeacher_m');
    },
    //-----学生-----
    addBeforeStudent({commit}) {
      console.log("addBeforeStudent");
      commit('addBeforeStudent_m');
    },

    changeTeacher({commit}, {data}) {
      console.log(data);
      commit('changeTeacher_m', data);
    },
    //--------修改学生-------
    changeStudent({commit}, {data}) {
      console.log(data);
      commit('changeStudent_m', data);
    },

    updateTeacher({commit}, {data}) {
      console.log("updateTeacher");
      console.log(data);
      api.updateTeacher(data)
        .then((response) => {
          commit('updateTeacher_m', response);
        })
        .catch((error) => {
            console.log(error);
          }
        );
    },
    //-------修改学生------
    updateStudent({commit}, {data}) {
      console.log("updateStudent");
      console.log(data);
      api.updateStudent(data)
        .then((response) => {
          commit('updateStudent_m', response);
        })
        .catch((error) => {
            console.log(error);
          }
        );
    }
  },
  mutations: {
    findAllTeacher_m(state, data) {
      console.log("findAllTeacher_m");
      state.teacher.length = data.data.length;
      for (var i = 0; i < data.data.length; i++) {
        state.teacher[i] = data.data[i];
        console.log(state.teacher[i]);
      }
      router.push({path: '/admin_index/admin_person_teacher'});
    },
    //------------查询所有学生-------------
    findAllStudent_m(state, data) {
      // //第一个参数state是这个模块的state 第二个参数是传进来的数据
      // for (var i = 0; i < data.data.length; i++) {
      //   console.log(data.data.length);
      //   state.student[i]=data.data[i];
      // }
      console.log("findAllStudent_m");
      state.student.length = data.data.length;
      for (var i = 0; i < data.data.length; i++) {
        state.student[i] = data.data[i];
        console.log(state.student[i]);
      }
      router.push({path: '/admin_index/admin_person_student'});
    },

    deleteTeacher_m(state, data) {
      console.log("deleteTeacher_m");
      state.teacher.length = data.data.length
      for (var i = 0; i < data.data.length; i++) {
        state.teacher[i] = data.data[i]
        console.log(state.teacher[i]);
      }

      router.push({path: '/admin_index/admin_person_teacher'});
    },
    //-----------删除学生--------
    deleteStudent_m(state, data) {
      console.log("deleteStudent_m");
      state.student.length = data.data.length
      for (var i = 0; i < data.data.length; i++) {
        state.student[i] = data.data[i]
        console.log(state.student[i]);
       }
      router.push({path: '/admin_index/admin_person_student'});
    },

    findTeacher_m(state, data) {
      console.log("findTeacher_m");
      state.teacher.length = data.data.length;
      for (var i = 0; i < data.data.length; i++) {
        state.teacher[i] = data.data[i];
        console.log(state.teacher[i]);
      }
      // state.teacher[0] = data.data
      // console.log(state.teacher[0]);
      router.push({path: '/admin_index/admin_person_teacher'});
    },


    findTeacherByClass_m(state, data) {
      console.log("findTeacherByClass_m");

      state.teacher.length = data.data.length;
      for (var i = 0; i < data.data.length; i++) {
        state.teacher[i] = data.data[i];
        console.log(state.teacher[i]);
      }

    },
    findStudentByClass_m(state, data) {
      console.log("findStudentByClass_m");
      console.log( data.data.length);
      state.STUDENT.length = data.data.length;
      for (var i = 0; i < data.data.length; i++) {
        state.student[i] = data.data[i];
        console.log(state.student[i]);
      }

    },
    //-----查询单个学生------
    findStudent_m(state, data) {
      console.log("findStudent_m");
      state.student.length = data.data.length;
      for (var i = 0; i < data.data.length; i++) {
        state.student[i] = data.data[i];
        console.log(state.student[i]);
      }
    //state.student[0] = data.data
    //console.log(state.student[0]);
      router.push({path: '/admin_index/admin_person_student'});
    },
    addTeacher_m(state, data) {
      console.log("addTeacher_m");
      state.teacher.length = data.data.length;
      for (var i = 0; i < data.data.length; i++) {
        state.teacher[i] = data.data[i]
        console.log(state.teacher[i]);
      }
      if (state.teacher.length == data.data.length) {
        console.log("跳转到admin人事 teacher");
        router.push({path: '/admin_index/admin_person_teacher'});
      }
    },
    //------添加学生------
   addStudent_m(state, data) {
    console.log("addStudent_m");
    state.student.length = data.data.length;
    for (var i = 0; i < data.data.length; i++) {
      state.student[i] = data.data[i]
      console.log(state.student[i]);
    }
    if (state.student.length == data.data.length) {
      console.log("跳转到admin人事 student");
      router.push({path: '/admin_index/admin_person_student'});
    }
  },

    addBeforeTeacher_m(state) {
      console.log("addBeforeTeacher_m");
      state.utaction = "1",
        state.uteacher.teaNum = "",
        state.uteacher.teaName = "",
        state.uteacher.teaClass = "",
        state.uteacher.teaCourse = "",
        state.uteacher.teaPassword = ""

    },
    //----学生-----
    addBeforeStudent_m(state) {
      console.log("addBeforeStudent_m");
      state.utaction = "1",
        state.ustudent.stuNum = "",
        state.ustudent.stuName = "",
        state.ustudent.stuClass = "",
        state.ustudent.stuSex = "",
        state.ustudent.stuPassword = ""

    },
    changeTeacher_m(state, data) {
      console.log("changeTeacher_m");
      state.utaction = "2",
        state.uteacher.teaNum = data.teaNum,
        state.uteacher.teaName = data.teaName,
        state.uteacher.teaClass = data.teaClass,
        state.uteacher.teaCourse = data.teaCourse,
        state.uteacher.teaPassword = data.teaPassword
    },
    //-------修改学生---------
    changeStudent_m(state, data) {
      console.log("changeStudent_m");
      state.utaction = "2",
        state.ustudent.stuNum = data.stuNum,
        state.ustudent.stuName = data.stuName,
        state.ustudent.stuClass = data.stuClass,
        state.ustudent.stuSex = data.stuSex,
        state.ustudent.stuPassword = data.stuPassword
    },

    updateTeacher_m(state, data) {
      console.log("updateTeacher_m");
      state.teacher.length = data.data.length;
      for (var i = 0; i < data.data.length; i++) {
        state.teacher[i] = data.data[i]
        console.log(state.teacher[i]);
      }
      router.push({path: '/admin_index/admin_person_teacher'});
    },
    //-----修改学生------
    updateStudent_m(state, data) {
      console.log("updateStudent_m");
      state.student.length = data.data.length;
      for (var i = 0; i < data.data.length; i++) {
        state.student[i] = data.data[i]
        console.log(state.student[i]);
      }
      router.push({path: '/admin_index/admin_person_student'});
    },
  }
}
