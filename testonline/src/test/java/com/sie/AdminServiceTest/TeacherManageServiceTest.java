package com.sie.AdminServiceTest;


import com.sie.domain.Teacher;
import com.sie.service.PersonManageService.TeacherManagerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TeacherManageServiceTest {
    @Autowired
    private TeacherManagerService teacherManagerService;

    @Test
    public void findAllTeacherTest(){

       List<Teacher> teacherList= teacherManagerService.findAllTeacher();
        System.out.println("老师数量："+teacherList.size());
    }


    @Test
    public void findTeacherByNameTest(){
        List<Teacher> teacherByNum = teacherManagerService.findTeacherByNum("2");
        System.out.println(teacherByNum);
    }


    @Test
    public void addTeacherTest(){
        Teacher teacher = new Teacher();
        teacher.setTeaName("t");
        teacher.setTeaCourse(1);
        teacher.setTeaNum("t005");
        teacher.setTeaPassword("123");
        teacher.setTeaClass("1");
       List<Teacher> teacherList= teacherManagerService.addTeacher(teacher);
        System.out.println(teacherList.size());
    }

    @Test
    public void deleteTeacherTest(){
        List<Teacher> teacherList= teacherManagerService.deleteTeacher("t003");
        System.out.println(teacherList.size());
    }

    @Test
    public void updateTeacherTest(){
        Teacher teacher = new Teacher();
        teacher.setTeaName("tt");
        teacher.setTeaCourse(1);
        teacher.setTeaNum("t003");
        teacher.setTeaPassword("123");

    }
}
