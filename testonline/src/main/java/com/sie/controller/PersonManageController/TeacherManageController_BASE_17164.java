package com.sie.controller.PersonManageController;

import com.sie.domain.Teacher;
import com.sie.service.PersonManageService.TeacherManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/personManage")
public class TeacherManageController {
    @Autowired
    private TeacherManagerService teacherManagerService;

    @PostMapping("/addTeacher")
    public List<Teacher>  addTeacher(Teacher teacher){
        List<Teacher> teacherList = teacherManagerService.addTeacher(teacher);
        return teacherList;
    }

    @PostMapping("/deleteTeacher")
    public List<Teacher> delTeacher(String num){

        List<Teacher> teacherList= teacherManagerService.deleteTeacher(num);
        return teacherList;
    }

    @PostMapping("/updateTeacher")
    public Teacher updateTeacher(Teacher teacher){
        Teacher t = teacherManagerService.updateTeacher(teacher);
        return t;
    }


    @PostMapping("/findTeacher")
    public Teacher findTeacher(String num){
      return teacherManagerService.findTeacherByNum(num);
    }

    @PostMapping("/findAllTeacher")
    public List<Teacher> findAllTeacher(){
      return teacherManagerService.findAllTeacher();
    }
}
