package com.sie.controller.InforManageController;

import com.sie.domain.Admin;
import com.sie.domain.Infor;
import com.sie.domain.Student;
import com.sie.domain.Teacher;
import com.sie.service.InforMangeService.InforManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/inforManage")
public class InforManageController {
    @Autowired
    private InforManagerService inforManagerService;

    @PostMapping("/updateInfor")
    public Infor updateInfor(Infor infor) {
        Infor i = new Infor();
        if (infor.getIdentity().equals("1")) {
            Admin admin = new Admin();
            if (admin != null) {

                i.setPassword(admin.getAdmPassword());
                i.setRepassword(admin.getAdmPassword());
                i.setNewpassword(admin.getAdmPassword());
                i.setUsernum(admin.getAdmNum());
                i.setName(admin.getAdmName());
                i.setIdentity("1");
                System.out.println("Admin密码:" + infor.getPassword());
                System.out.println("Admin新密码:" + infor.getNewpassword());
                System.out.println("Admin确认密码:" + infor.getRepassword());

            }
        } else if (infor.getIdentity().equals("2")) {
            Teacher teacher = new Teacher();
            if (teacher != null) {
                i.setPassword(teacher.getTeaPassword());
                i.setRepassword(teacher.getTeaPassword());
                i.setNewpassword(teacher.getTeaPassword());
                i.setUsernum(teacher.getTeaNum());
                i.setName(teacher.getTeaName());
                i.setIdentity("2");
                System.out.println("Teacher密码:" + infor.getPassword());
                System.out.println("Teacher新密码:" + infor.getNewpassword());
                System.out.println("Teacher确认密码:" + infor.getRepassword());
            }

        } else {
            Student student = new Student();
            if (student != null) {

                i.setUsernum(student.getStuNum());
                i.setName(student.getStuName());
                i.setPassword(student.getStuPassword());
                i.setRepassword(student.getStuPassword());
                i.setNewpassword(student.getStuPassword());
                i.setIdentity("3");
                System.out.println("Student密码:" + infor.getPassword());
                System.out.println("Student新密码:" + infor.getNewpassword());
                System.out.println("Student确认密码:" + infor.getRepassword());

            }
        }
        return i;

    }

}

