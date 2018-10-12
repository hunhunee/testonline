package com.sie.LoginTest.mapper;

import com.sie.domain.Admin;
import com.sie.domain.Student;
import com.sie.domain.Teacher;
import com.sie.domain.User;
import com.sie.mapper.LoginMapper.LoginMapper;
import com.sie.mapper.TestManageMapper.TestManageMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class LoginTest {
    @Autowired
    private LoginMapper loginMapper;

    @Test
    public void adminLoginTest(){
      User user = new User();
      user.setUsernum("a001");
      user.setPassword("123456");
      Admin admin = loginMapper.findAdminByNumAndPwd(user);
        //System.out.println("admin："+admin.getAdmName());
    }

    @Test
    public void teacherLoginTest(){
        User user = new User();
        user.setUsernum("t001");
        user.setPassword("123");
        Teacher teacher= loginMapper.findTeacherByNumAndPwd(user);
        System.out.println("teacher:"+teacher.getTeaName());
    }

    @Test
    public void studentLoginTest(){
        User user = new User();
        user.setUsernum("s001");
        user.setPassword("123456");
        Student student = loginMapper.findStudentByNumAndPwd(user);
        //System.out.println("student:"+student.getStuName());
    }

}
