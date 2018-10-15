package com.sie.controller.InfoManageController;

import com.sie.domain.Info;
import com.sie.service.InfoMangeService.InfoManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/infoManage")
public class InfoManageController {
    @Autowired
    private InfoManagerService infoManagerService;

    @PostMapping("/updateInfo")
    public String updateInfo(Info info, HttpServletRequest request) {

        String message = null;

        if (info.getIdentity().equals("1")) {

               message = infoManagerService.updateAdmin(info);

        } else if (info.getIdentity().equals("2")) {

                message = infoManagerService.updateTeacher(info);

        } else {

                message = infoManagerService.updateStudent(info);

        }
        return message;

    }

}

