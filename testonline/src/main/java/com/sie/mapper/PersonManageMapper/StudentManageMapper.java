package com.sie.mapper.PersonManageMapper;

import com.sie.domain.Student;
import com.sie.domain.StudentEx;

import java.util.List;

public interface StudentManageMapper {

    //添加学生
    public void insertStudent(StudentEx studentEx);

    //删除学生
    public void deleteStudentByStuNum(String num);

    //修改学生
    public void updateStudentByStuNum(StudentEx studentEx);

    //查询学生
    public List<StudentEx> selectStudentByStuNum(String num);

    //查询所有学生
    public List<StudentEx> selectAllStudent();
}
