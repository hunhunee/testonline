import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'

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

import StudentIndex from '@/components/StudentIndex'
import StudentMessage from '@/components/StudentMessage'
import StudentTest from '@/components/StudentTest'
import StudentTestResult from '@/components/StudentTestResult'
import StudentEnd from '@/components/StudentEnd'

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
        { path: 'student_test_result', component: StudentTestResult } ,     //学生查看自己的考试结果
        { path:'student_end',component:StudentEnd}
      ]
    },
    {
      path: '/teacher_index',
      name: 'teacher_index',
      component: TeacherIndex,
      children: [
        { path: 'teacher_message', component: TeacherMessage },            //教师对个人信息进行管理
        { path: 'teacher_test_single', component: TeacherTestSingle },                  //教师对考试试题进行管理
        { path: 'teacher_test_multiple', component: TeacherTestMultiple },                  //教师对考试试题进行管理
        { path: 'teacher_test_judge', component: TeacherTestJudge},                  //教师对考试试题进行管理
        { path: 'teacher_test_compute', component: TeacherTestCompute },                  //教师对考试试题进行管理
        { path: 'teacher_test_result', component: TeacherTestResult },     //教师对考试结果进行查看
        { path: 'teacher_test_single_aou', component: TeacherTestSingleAOU },
        { path: 'teacher_test_multiple_aou', component: TeacherTestMultipleAOU },
        { path: 'teacher_test_judge_aou', component: TeacherTestJudgeAOU },
        { path: 'teacher_test_compute_aou', component: TeacherTestComputeAOU },
      ]
    }
    ,
    {
      path: '/admin_index',
      name: 'admin_index',
      component: AdminIndex,
      children: [
        { path: 'admin_message', component: AdminMessage },              //管理员对个人信息进行管理
        { path: 'admin_test_single', component: AdminTestSingle },                  //教师对考试试题进行管理
        { path: 'admin_test_multiple', component:AdminTestMultiple },                  //教师对考试试题进行管理
        { path: 'admin_test_judge', component: AdminTestJudge},                  //教师对考试试题进行管理
        { path: 'admin_test_compute', component: AdminTestCompute },                  //教师对考试试题进行管理
        { path: 'admin_person_teacher', component: AdminPersonTeacher },             //管理员对人事信息管理--教师
        { path: 'admin_person_student', component: AdminPersonStudent },             //管理员对人事信息管理--学生
        { path: 'admin_person_teacher_aou', component: AdminPersonTeacherAOU },      //管理员对人事信息管理--教师
        { path: 'admin_person_student_aou', component: AdminPersonStudentAOU },      //管理员对人事信息管理--学生
        { path: 'admin_person_teacher_aou', component: AdminPersonTeacherAOU },       //管理员对人事信息管理--学生
        { path: 'admin_test_single_aou', component: AdminTestSingleAOU },
        { path: 'admin_test_multiple_aou', component: AdminTestMultipleAOU },
        { path: 'admin_test_judge_aou', component: AdminTestJudgeAOU },
        { path: 'admin_test_compute_aou', component: AdminTestComputeAOU },
        { path: 'admin_Lesson', component: AdminLesson },                       //管理员对科目信息进行管理
        { path: 'admin_Lesson_aou', component: AdminLessonAou },                //对科目的增删改查
      ]
    }

  ]
})
