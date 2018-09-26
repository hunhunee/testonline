package com.sie.controller.PersonManageController;

import com.sie.domain.Student;
import com.sie.service.PersonManageService.StudentManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/personManage")
public class StudentManageController {

    @Autowired
    private StudentManagerService studentManagerService;

    //查询学生
    @PostMapping("/findStudent")
    public Student findStudent(String num){
        return studentManagerService.selectStudentByStuNum(num);
    }
    //查询所有学生
    @PostMapping("/findAllStudent")
    public List<Student> findAllStudent(){
        System.out.println("我进来了。。。。。");
        return studentManagerService.selectAllStudent();
    }
    //增加
    @PostMapping("/addStudent")
    public List<Student> addStudent(Student student){
        List<Student> studentList = studentManagerService.insertStudent(student);
        return studentList;
    }
    //删除
    @PostMapping("/deleteStudent")
    public List<Student> deleteStudent(String num){
        List<Student> studentList = studentManagerService.deleteStudentByStuNum(num);
        return studentList;
    }
    //修改
    @PostMapping("/updateStudent")
    public List<Student> updataStudent(Student student){
        List<Student> studentList = studentManagerService.updateStudentByStuNum(student);
        return studentList;
    }
}
