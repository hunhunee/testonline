import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import Main from '@/components/Main'

import AdminIndex from '@/components/AdminIndex'
import AdminMessage from '@/components/AdminMessage'
import AdminPersonTeacher from '@/components/AdminPersonTeacher'
import AdminPersonStudent from '@/components/AdminPersonStudent'
import AdminPersonStudentAOU from '@/components/AdminPersonStudentAOU'
import AdminPersonTeacherAOU from '@/components/AdminPersonTeacherAOU'
import AdminTestSingle from '@/components/AdminTestSingle'
import AdminTestMultiple from '@/components/AdminTestMultiple'
import AdminTestJudge from '@/components/AdminTestJudge'
import AdminTestCompute from '@/components/AdminTestCompute'
import AdminTestSingleAOU from '@/components/AdminTestSingleAOU'
import AdminTestMultipleAOU from '@/components/AdminTestMultipleAOU'
import  AdminTestJudgeAOU from '@/components/AdminTestJudgeAOU'
import  AdminTestComputeAOU from '@/components/AdminTestComputeAOU'
import AdminLesson from '@/components/AdminLesson'
import AdminLessonAou from '@/components/AdminLessonAou'
import AdminClass from '@/components/AdminClass'
import AdminClassAou from '@/components/AdminClassAou'

import TeacherIndex from '@/components/TeacherIndex'
import TeacherMessage from '@/components/TeacherMessage'
import TeacherTestResult from '@/components/TeacherTestResult'
import TeacherTestSingle from '@/components/TeacherTestSingle'
import TeacherTestMultiple from '@/components/TeacherTestMultiple'
import TeacherTestJudge from '@/components/TeacherTestJudge'
import TeacherTestCompute from '@/components/TeacherTestCompute'
import  TeacherTestSingleAOU from '@/components/TeacherTestSingleAOU'
import  TeacherTestMultipleAOU from '@/components/TeacherTestMultipleAOU'
import  TeacherTestJudgeAOU from '@/components/TeacherTestJudgeAOU'
import  TeacherTestComputeAOU from '@/components/TeacherTestComputeAOU'
import TeacherTestResultSelect from '@/components/TeacherTestResultSelect'

import StudentIndex from '@/components/StudentIndex'
import StudentMessage from '@/components/StudentMessage'
import StudentTest from '@/components/StudentTest'
import StudentTestResult from '@/components/StudentTestResult'
import StudentEnd from '@/components/StudentEnd'

Vue.use(Router)

export default new Router({
  // mode:'history',
  // base:'/',
  routes: [
    {
      path: '/',
      name: 'HelloWorld',
      component: HelloWorld
    },
    {
      path: '/student_index',
      name: 'student_index',
      component: StudentIndex,
      children: [

        { path: 'student_message', component:  StudentMessage,meta: {auth: true}},            //学生对个人信息进行管理
        { path: 'student_test', component: StudentTest,meta: {auth: true}},                  //学生进行考试
        { path: 'student_test_result', component: StudentTestResult,meta: {auth: true}},      //学生查看自己的考试结果
        { path:'student_end',component:StudentEnd,meta: {auth: true}},
        {path:'main',component:Main,meta:{auth:true}}

      ]
    },
    {
      path: '/teacher_index',
      name: 'teacher_index',
      component: TeacherIndex,
      meta: {auth: true},
      children: [
        { path: 'teacher_message', component: TeacherMessage,meta: {auth: true}},            //教师对个人信息进行管理
        { path: 'teacher_test_single', component: TeacherTestSingle,meta: {auth: true}},                  //教师对考试试题进行管理
        { path: 'teacher_test_multiple', component: TeacherTestMultiple,meta: {auth: true}},                  //教师对考试试题进行管理
        { path: 'teacher_test_judge', component: TeacherTestJudge,meta: {auth: true}},                  //教师对考试试题进行管理
        { path: 'teacher_test_compute', component: TeacherTestCompute,meta: {auth: true}},                  //教师对考试试题进行管理
        { path: 'teacher_test_result', component: TeacherTestResult,meta: {auth: true}},     //教师对考试结果进行查看
        { path: 'teacher_test_single_aou', component: TeacherTestSingleAOU,meta: {auth: true}},
        { path: 'teacher_test_multiple_aou', component: TeacherTestMultipleAOU,meta: {auth: true} },
        { path: 'teacher_test_judge_aou', component: TeacherTestJudgeAOU,meta: {auth: true} },
        { path: 'teacher_test_compute_aou', component: TeacherTestComputeAOU,meta: {auth: true} },
        { path: 'teacher_test_result_select', component: TeacherTestResultSelect,meta: {auth: true} },
        {path:'main',component:Main,meta:{auth:true}}
      ]
    }
    ,
    {
      path: '/admin_index',
      name: 'admin_index',
      component: AdminIndex,
      meta: {auth: true},
      children: [
        { path: 'admin_message', component: AdminMessage,meta: {auth: true} },              //管理员对个人信息进行管理
        { path: 'admin_test_single', component: AdminTestSingle,meta: {auth: true} },                  //教师对考试试题进行管理
        { path: 'admin_test_multiple', component:AdminTestMultiple,meta: {auth: true} },                  //教师对考试试题进行管理
        { path: 'admin_test_judge', component: AdminTestJudge,meta: {auth: true}},                  //教师对考试试题进行管理
        { path: 'admin_test_compute', component: AdminTestCompute,meta: {auth: true} },                  //教师对考试试题进行管理
        { path: 'admin_person_teacher', component: AdminPersonTeacher,meta: {auth: true} },             //管理员对人事信息管理--教师
        { path: 'admin_person_student', component: AdminPersonStudent,meta: {auth: true} },             //管理员对人事信息管理--学生
        { path: 'admin_person_teacher_aou', component: AdminPersonTeacherAOU,meta: {auth: true} },      //管理员对人事信息管理--教师
        { path: 'admin_person_student_aou', component: AdminPersonStudentAOU,meta: {auth: true} },      //管理员对人事信息管理--学生
        { path: 'admin_person_teacher_aou', component: AdminPersonTeacherAOU,meta: {auth: true} },       //管理员对人事信息管理--学生
        { path: 'admin_test_single_aou', component: AdminTestSingleAOU,meta: {auth: true} },
        { path: 'admin_test_multiple_aou', component: AdminTestMultipleAOU,meta: {auth: true} },
        { path: 'admin_test_judge_aou', component: AdminTestJudgeAOU,meta: {auth: true} },
        { path: 'admin_test_compute_aou', component: AdminTestComputeAOU,meta: {auth: true} },
        { path: 'admin_Lesson', component: AdminLesson,meta: {auth: true} },                       //管理员对科目信息进行管理
        { path: 'admin_Lesson_aou', component: AdminLessonAou,meta: {auth: true} },                //对科目的增删改查
        { path: 'admin_Class', component: AdminClass,meta: {auth: true} },                       //管理员对科目信息进行管理
        { path: 'admin_Class_aou', component: AdminClassAou,meta: {auth: true} },                 //对科目的增删改查
        {path:'main',component:Main,meta:{auth:true}}

      ]
    }

  ]
})
