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


        System.out.println("老师名字："+teacherManagerService.findTeacherByNum("t001").getTeaName());
    }


    @Test
    public void addTeacherTest(){
        Teacher teacher = new Teacher();
        teacher.setTeaName("t");
        teacher.setTeaCourse(1);
        teacher.setTeaNum("t003");
        teacher.setTeaPassword("123");
        teacherManagerService.addTeacher(teacher);

    }

    @Test
    public void deleteTeacherTest(){
        teacherManagerService.deleteTeacher("t003");

    }

    @Test
    public void updateTeacherTest(){
        Teacher teacher = new Teacher();
        teacher.setTeaName("tt");
        teacher.setTeaCourse(1);
        teacher.setTeaNum("t003");
        teacher.setTeaPassword("123");
       teacherManagerService.updateTeacher(teacher);
    }
}
