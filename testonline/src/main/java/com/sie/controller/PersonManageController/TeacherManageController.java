package com.sie.controller.PersonManageController;

import com.sie.domain.Teacher;
import com.sie.domain.TeacherEx;
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
    public List<TeacherEx>  addTeacher(Teacher teacher){
        List<TeacherEx> teacherList = teacherManagerService.addTeacher(teacher);
        return teacherList;
    }

    @PostMapping("/deleteTeacher")
    public List<TeacherEx> delTeacher(String num){

        List<TeacherEx> teacherList= teacherManagerService.deleteTeacher(num);
        return teacherList;
    }

    @PostMapping("/updateTeacher")
    public List<TeacherEx> updateTeacher(Teacher teacher){
        List<TeacherEx> teacherList = teacherManagerService.updateTeacher(teacher);
        return teacherList;
    }


    @PostMapping("/findTeacher")
    public List<TeacherEx> findTeacher(String num){
      return teacherManagerService.findTeacherByNum(num);
    }

    @PostMapping("/findAllTeacher")
    public List<TeacherEx> findAllTeacher(){
      return teacherManagerService.findAllTeacher();
    }
}
