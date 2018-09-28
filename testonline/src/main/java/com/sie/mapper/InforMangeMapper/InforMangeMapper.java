package com.sie.mapper.InforMangeMapper;

import com.sie.domain.Admin;
import com.sie.domain.Student;
import com.sie.domain.Teacher;

import java.util.List;


public interface InforMangeMapper {

    public void updateAdmin(Admin admin);

    public void updateTeacher(Teacher teacher);

    public void updateStudent(Student student);

    public List<Teacher> findAllTeacher();

    public List<Admin> findAllAdmin();

    public List<Student> findAllStudent();

}