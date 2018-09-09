import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'

import AdminIndex from '@/components/AdminIndex'
import AdminMessage from '@/components/AdminMessage'
import AdminTest from '@/components/AdminTest'
import AdminPersion from '@/components/AdminPersion'

import TeacherIndex from '@/components/TeacherIndex'
import TeacherMessage from '@/components/TeacherMessage'
import TeacherTest from '@/components/TeacherTest'
import TeacherTestResult from '@/components/TeacherTestResult'

import StudentIndex from '@/components/StudentIndex'
import StudentMessage from '@/components/StudentMessage'
import StudentTest from '@/components/StudentTest'
import StudentTestResult from '@/components/StudentTestResult'

Vue.use(Router)

export default new Router({
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
        { path: 'student_message', component:  StudentMessage},            //学生对个人信息进行管理
        { path: 'student_test', component: StudentTest },                  //学生进行考试
        { path: 'student_test_result', component: StudentTestResult }      //学生查看自己的考试结果
      ]
    },
    {
      path: '/teacher_index',
      name: 'teacher_index',
      component: TeacherIndex,
      children: [
        { path: 'teacher_message', component: TeacherMessage },            //教师对个人信息进行管理
        { path: 'teacher_test', component: TeacherTest },                  //教师对考试试题进行管理
        { path: 'teacher_test_result', component: TeacherTestResult }     //教师对考试结果进行查看
      ]
    },
    {
      path: '/admin_index',
      name: 'admin_index',
      component: AdminIndex,
      children: [
        { path: 'admin_message', component: AdminMessage },              //管理员对个人信息进行管理
        { path: 'admin_test', component: AdminTest },                   //管理员对试题进行管理
        { path: 'admin_persion', component: AdminPersion }             //管理员对人事信息管理
      ]
    }
  ]
})
