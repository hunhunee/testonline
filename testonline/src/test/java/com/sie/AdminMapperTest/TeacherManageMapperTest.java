package com.sie.AdminMapperTest;

import com.sie.domain.Lesson;
import com.sie.domain.Teacher;
import com.sie.domain.TeacherEx;
import com.sie.mapper.PersonManageMapper.TeacherManageMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

    @RunWith(SpringRunner.class)
    @SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
    public class TeacherManageMapperTest {

        @Autowired
        private TeacherManageMapper teacherManageMapper;

        @Test
        public void findCountTest(){
            System.out.println("老师人数："+teacherManageMapper.findCount());
        }

        @Test
        public void findAllTeacherTest(){
            List<TeacherEx> teacherList =teacherManageMapper.findAllTeacher();
            System.out.println("老师人数2："+teacherList.size());

            System.out.println(teacherList.get(0).getaClass().getClassName());
        }

        @Test
        public void findTeacherByNumTest(){
            List<TeacherEx> teacher =teacherManageMapper.findTeacherByNum("t00");
            if(teacher!=null){
                System.out.println("yes");
            }else{
                System.out.println("no");
            }
        }

        @Test
        public void updateTeacherTest(){
            Teacher teacher = new Teacher();
            teacher.setTeaName("zj");
            teacher.setTeaCourse(1);
            teacher.setTeaNum("t001");
            teacher.setTeaPassword("123");

            teacherManageMapper.updateTeacher(teacher);
        }


        @Test
        public void deleteTeacherTest(){
            teacherManageMapper.deleteTeacher("t002");
        }

        @Test
        public void addTeacherTest(){
            Teacher teacher = new Teacher();
            teacher.setTeaName("lyy");
            teacher.setTeaCourse(1);
            teacher.setTeaNum("t002");
            teacher.setTeaPassword("123");

            //teacherManageMapper.addTeacher(teacher);
        }

        @Test
        public void TeacherBylessonTest(){
            List<Teacher> teacher = teacherManageMapper.findTeacherByLesson("1");
            System.out.println(teacher.get(0).getTeaName());
        }

}
