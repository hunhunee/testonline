package com.sie.controller.InforManageController;

import com.sie.domain.Admin;
import com.sie.domain.Infor;
import com.sie.domain.Student;
import com.sie.domain.Teacher;
import com.sie.service.InforMangeService.InforManagerService;
import com.sie.service.PersonManageService.StudentManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/inforManage")
public class InforManageController {
    @Autowired
    private InforManagerService inforManagerService;

    @PostMapping("/updateInfor")
    public String updateInfor(Infor infor, HttpServletRequest request) {

        String message=null;

        if (infor.getIdentity().equals("1")) {

               message = inforManagerService.updateAdmin(infor);

        } else if (infor.getIdentity().equals("2")) {

                message = inforManagerService.updateTeacher(infor);

        } else {

                message = inforManagerService.updateStudent(infor);

        }
        return message;

    }

}

