package com.sie.service.PersonManageService;

import com.sie.domain.Teacher;

import java.util.List;


public interface TeacherManagerService {
    public List<Teacher> findAllTeacher();

    public List<Teacher> findTeacherByNum(String num);

    public List<Teacher> addTeacher(Teacher teacher);

    public List<Teacher> updateTeacher(Teacher teacher);

    public List<Teacher> deleteTeacher(String num);
}
