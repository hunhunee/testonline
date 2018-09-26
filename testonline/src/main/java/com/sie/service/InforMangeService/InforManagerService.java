package com.sie.service.InforMangeService;

import com.sie.domain.Admin;
import com.sie.domain.Student;
import com.sie.domain.Teacher;

import java.util.List;


public interface InforManagerService {


    public List<Admin> updateAdmin(Admin admin);

    public List<Teacher> updateTeacher(Teacher teacher);

    public List<Student> updateStudent(Student student);



}
