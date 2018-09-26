package com.sie.service.PersonManageService.PersonManageServiceImpl;


import com.sie.domain.Student;
import com.sie.mapper.PersonManageMapper.StudentManageMapper;
import com.sie.service.PersonManageService.StudentManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//实现类实现Service接口
@Service
public class StudentManagerServiceImpl implements StudentManagerService {

    //把StudentManageMapper注入进来
    @Autowired
    private StudentManageMapper studentManageMapper;

    //学生添加
    @Override
    public List<Student> insertStudent(Student student) {
        studentManageMapper.insertStudent(student);
        List<Student> studentList = studentManageMapper.selectAllStudent();
        return studentList;

    }

    //根据学号来删除学生
    @Override
    public List<Student> deleteStudentByStuNum(String num) {
        studentManageMapper.deleteStudentByStuNum(num);
        List<Student> studentList = studentManageMapper.selectAllStudent();
        return studentList;
    }

    //根据学号来修改学生信息
    @Override
    public List<Student> updateStudentByStuNum(Student student) {
        studentManageMapper.updateStudentByStuNum(student);
        List<Student> studentList = studentManageMapper.selectAllStudent();
        return studentList;
    }

    //根据学号来查询学生
    @Override
    public List<Student> selectStudentByStuNum(String num) {
        List<Student> student = studentManageMapper.selectStudentByStuNum(num);
        return student;
    }

    //查询所有学生
    @Override
    public List<Student> selectAllStudent() {
        List<Student> list = studentManageMapper.selectAllStudent();
        return list;
    }
}
