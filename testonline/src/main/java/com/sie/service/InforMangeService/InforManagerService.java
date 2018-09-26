package com.sie.service.InforMangeService;

import com.sie.domain.Admin;
import com.sie.domain.Student;
import com.sie.domain.Teacher;


public interface InforManagerService {


    public Admin updateAdmin(Admin admin);

    public Teacher updateTeacher(Teacher teacher);

    public Student updateStudent(Student student);



}
