package com.sie.service.PersonManageService.PersonManageServiceImpl;


import com.sie.domain.Student;
import com.sie.domain.StudentEx;
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
    public List<StudentEx> insertStudent(StudentEx studentEx) {
        studentManageMapper.insertStudent(studentEx);
        List<StudentEx> studentList = studentManageMapper.selectAllStudent();
        for (int i = 0; i <studentList.size() ; i++) {
            studentList.get(i).setClassName(studentList.get(i).getaClass().getClassName());
        }
        return studentList;

    }

    //根据学号来删除学生
    @Override
    public List<StudentEx> deleteStudentByStuNum(String num) {
        studentManageMapper.deleteStudentByStuNum(num);
        List<StudentEx> studentList = studentManageMapper.selectAllStudent();
        for (int i = 0; i <studentList.size() ; i++) {
            studentList.get(i).setClassName(studentList.get(i).getaClass().getClassName());
        }
        return studentList;
    }

    //根据学号来修改学生信息
    @Override
    public List<StudentEx> updateStudentByStuNum(StudentEx studentEx) {
        studentManageMapper.updateStudentByStuNum(studentEx);
        List<StudentEx> studentList = studentManageMapper.selectAllStudent();
        for (int i = 0; i <studentList.size() ; i++) {
            studentList.get(i).setClassName(studentList.get(i).getaClass().getClassName());
        }
        return studentList;
    }

    //根据学号来查询学生
    @Override
    public List<StudentEx> selectStudentByStuNum(String num) {
        List<StudentEx> student = studentManageMapper.selectStudentByStuNum(num);
        for (int i = 0; i <student.size() ; i++) {
            student.get(i).setClassName(student.get(i).getaClass().getClassName());
        }
        return student;
    }

    //查询所有学生
    @Override
    public List<StudentEx> selectAllStudent() {
        List<StudentEx> list = studentManageMapper.selectAllStudent();
        for (int i = 0; i <list.size() ; i++) {
               list.get(i).setClassName(list.get(i).getaClass().getClassName());
        }
        return list;
    }
}
