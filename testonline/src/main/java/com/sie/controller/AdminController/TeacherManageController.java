package com.sie.controller.AdminController;

import com.sie.domain.Teacher;
import com.sie.service.AdminService.TeacherManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class TeacherManageController {
    @Autowired
    private TeacherManagerService teacherManagerService;

    @GetMapping("/addTeacher")
    public String addTeacher(Teacher teacher){
      return "添加教师信息成功！";
    }

    @GetMapping("/delTeacher/{num}")
    public String delTeacher(@PathVariable("num") String num){
        return "删除教师信息成功！";
    }

    @GetMapping("/updateTeacher")
    public String updateTeacher(Teacher teacher){
        return "修改教师信息成功";
    }
    @GetMapping("/findTeacher/{num}")
    public Teacher findTeacher(@PathVariable("num") String num){
      return teacherManagerService.findTeacherByNum(num);
    }

    @GetMapping("/findAllTeacher")
    public List<Teacher> findAllTeacher(){
      return teacherManagerService.findAllTeacher();
    }
}
