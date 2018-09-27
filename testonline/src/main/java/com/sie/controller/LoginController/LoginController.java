package com.sie.controller.LoginController;

import com.sie.domain.Admin;
import com.sie.domain.Student;
import com.sie.domain.Teacher;
import com.sie.domain.User;
import com.sie.service.LoginService.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class LoginController {
    @Autowired
    private LoginService loginService;

    @PostMapping("/login")
    public User login(User user){
        System.out.println(user.getIdentity());
        System.out.println(user.getUsernum());
        System.out.println(user.getPassword());
        User u=new User();
         if(user.getIdentity().equals("1")){
            Admin admin= loginService.findAdminByNumAndPwd(user);
            if(admin!=null){
                u.setName(admin.getAdmName());
                u.setPassword(admin.getAdmPassword());
                u.setUsernum(admin.getAdmNum());
                u.setIdentity("1");
            }

         }else if(user.getIdentity().equals("2")){
             Teacher teacher =loginService.findTeacherByNumAndPwd(user);

             if(teacher!=null){
                 u.setUsernum(teacher.getTeaNum());
                 u.setPassword(teacher.getTeaPassword());
                 u.setName(teacher.getTeaName());
                 u.set_class(teacher.getTeaClass());
                 u.setLesson(teacher.getTeaCourse());
                 u.setIdentity("2");

             }

         }else{
              Student student =loginService.findStudentByNumAndPwd(user);
              if(student!=null){
                  u.set_class(student.getStuClass());
                  u.setName(student.getStuName());
                  u.setPassword(student.getStuPassword());
                  u.setSex(student.getStuSex());
                  u.setUsernum(student.getStuNum());
                  u.setIdentity("3");
              }

         }
        return u;
    }
}
