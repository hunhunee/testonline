package com.sie.service.PersonManageService;

import com.sie.domain.Student;
import com.sie.domain.StudentEx;

import java.util.List;

public interface StudentManagerService {

    //添加学生
    public List<StudentEx> insertStudent(StudentEx student);

    //删除学生
    public List<StudentEx> deleteStudentByStuNum(String num);

    //修改学生
    public List<StudentEx> updateStudentByStuNum(StudentEx student);

    //查询学生
    public List<StudentEx> selectStudentByStuNum(String num);

    //查询所有学生
    public List<StudentEx> selectAllStudent();
}
