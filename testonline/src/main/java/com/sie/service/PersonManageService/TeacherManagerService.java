package com.sie.service.PersonManageService;

import com.sie.domain.Teacher;

import java.util.List;


public interface TeacherManagerService {
    public List<Teacher> findAllTeacher();

    public Teacher findTeacherByNum(String num);

    public void addTeacher(Teacher teacher);

    public void updateTeacher(Teacher teacher);

    public void deleteTeacher(String num);
}
