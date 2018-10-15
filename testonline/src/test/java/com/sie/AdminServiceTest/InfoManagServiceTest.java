package com.sie.AdminServiceTest;

import com.sie.domain.Info;
import com.sie.domain.Student;
import com.sie.domain.Teacher;
import com.sie.service.InfoMangeService.InfoManagerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class InfoManagServiceTest {
    @Autowired
    private InfoManagerService infoManagerService;
    @Test
    public void updateAdmintest(){
        //测试管理员密码是否正确
         Info info = new Info();
         info.setUserid(1);
         info.setPassword("12");
         info.setNewpassword("12");
        infoManagerService.updateAdmin(info);
    }

    @Test
    public void updateTeachertest(){
        Teacher teacher = new Teacher();
        teacher.setTeaNum("t001");
        teacher.setTeaName("李四");
        teacher.setTeaPassword("123456");
       // infoManagerService.updateTeacher(teacher);
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
       // infoManagerService.updateStudent(student);
        System.out.println("编号："+student.getStuNum());
        System.out.println("姓名:"+student.getStuName());
        System.out.println("密码:"+student.getStuPassword());
    }
}
