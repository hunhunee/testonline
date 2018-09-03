package com.sie.service.AdminService;

import com.sie.domain.Teacher;
import org.springframework.stereotype.Service;

import java.util.List;


public interface TeacherManagerService {
    public List<Teacher> findAllTeacher();

    public Teacher findTeacherByNum(String num);

    public void addTeacher(Teacher teacher);

    public void updateTeacher(Teacher teacher);

    public void deleteTeacher(String num);
}
