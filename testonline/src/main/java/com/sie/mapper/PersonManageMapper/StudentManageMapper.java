package com.sie.mapper.PersonManageMapper;

import com.sie.domain.Student;

import java.util.List;

public interface StudentManageMapper {

    //添加学生
    public void insertStudent(Student student);

    //删除学生
    public void deleteStudentByStuNum(String num);

    //修改学生
    public void updateStudentByStuNum(Student student);

    //查询学生
    public List<Student> selectStudentByStuNum(String num);

    //查询所有学生
    public List<Student> selectAllStudent();
}
