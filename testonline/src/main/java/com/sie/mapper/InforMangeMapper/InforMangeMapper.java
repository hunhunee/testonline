package com.sie.mapper.InforMangeMapper;

import com.sie.domain.Admin;
import com.sie.domain.Student;
import com.sie.domain.Teacher;


public interface InforMangeMapper {

    public void updateAdmin(Admin admin);

    public void updateTeacher(Teacher teacher);

    public void updateStudent(Student student);

}
