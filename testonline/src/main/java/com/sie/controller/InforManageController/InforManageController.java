package com.sie.controller.InforManageController;

import com.sie.domain.Admin;
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

    @PostMapping("/updateAdmin")
    public Admin updateAdmin(Admin admin){
       Admin a = inforManagerService.updateAdmin(admin);
       return a;
    }

    @PostMapping("/updateTeacher")
    public Teacher updateTeacher(Teacher teacher){
        Teacher t = inforManagerService.updateTeacher(teacher);
        return t;
    }

    @PostMapping("/updateStudent")
    public Student updateStudent(Student student){
        Student s = inforManagerService.updateStudent(student);
        return s;
    }
}
