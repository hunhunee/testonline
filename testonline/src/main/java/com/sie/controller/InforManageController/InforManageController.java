package com.sie.controller.InforManageController;

import com.sie.domain.Infor;
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

    @PostMapping("/updateAdmin")
    public void updateAdmin(Infor infor){
        System.out.println("Admin密码"+infor.getPassword());
        System.out.println("Admin新密码"+infor.getNewpassword());
        System.out.println("Admin确认密码"+infor.getRepassword());

    }

    @PostMapping("/updateTeacher")
    public void updateTeacher(Infor infor){
        System.out.println("Teacher密码"+infor.getPassword());
        System.out.println("Teacher新密码"+infor.getNewpassword());
        System.out.println("Teacher确认密码"+infor.getRepassword());

    }

    @PostMapping("/updateStudent")
    public void updateStudent(Infor infor){
        System.out.println("Student密码"+infor.getPassword());
        System.out.println("Student新密码"+infor.getNewpassword());
        System.out.println("Student确认密码"+infor.getRepassword());

    }
}
