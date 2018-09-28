package com.sie.AdminServiceTest;

import com.sie.domain.Admin;
import com.sie.domain.Student;
import com.sie.domain.Teacher;
import com.sie.service.InforMangeService.InforManagerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class InforManagServiceTest {
    @Autowired
    private InforManagerService inforManagerService;
    @Test
    public void updateAdmintest(){
        Admin admin = new Admin();
        admin.setAdmNum("a001");
        admin.setAdmName("张三");
        admin.setAdmPassword("123456");
       // inforManagerService.updateAdmin(admin);
        System.out.println("编号:"+admin.getAdmNum());
        System.out.println("姓名:"+admin.getAdmName());
        System.out.println("密码:"+admin.getAdmPassword());
    }

    @Test
    public void updateTeachertest(){
        Teacher teacher = new Teacher();
        teacher.setTeaNum("t001");
        teacher.setTeaName("李四");
        teacher.setTeaPassword("123456");
       // inforManagerService.updateTeacher(teacher);
        System.out.println("编号："+teacher.getTeaNum());
        System.out.println("姓名:"+teacher.getTeaName());
        System.out.println("密码:"+teacher.getTeaPassword());

    }
    @Test
    public void updateStudenttest(){
        Student student = new Student();
        student.setStuNum("s001");
        student.setStuName("李明");
        student.setStuPassword("123456");
       // inforManagerService.updateStudent(student);
        System.out.println("编号："+student.getStuNum());
        System.out.println("姓名:"+student.getStuName());
        System.out.println("密码:"+student.getStuPassword());
    }
}
