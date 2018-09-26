package com.sie.service.PersonManageService;

import com.sie.domain.Student;

import java.util.List;

public interface StudentManagerService {

    //添加学生
    public List<Student> insertStudent(Student student);

    //删除学生
    public List<Student> deleteStudentByStuNum(String num);

    //修改学生
    public List<Student> updateStudentByStuNum(Student student);

    //查询学生
    public Student selectStudentByStuNum(String num);

    //查询所有学生
    public List<Student> selectAllStudent();
}
