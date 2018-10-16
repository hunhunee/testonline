package com.sie.service.PersonManageService;

import com.sie.domain.Teacher;
import com.sie.domain.TeacherEx;

import java.util.List;


public interface TeacherManagerService {
    public List<TeacherEx> findAllTeacher();

    public List<TeacherEx> findTeacherByNum(String num);

    public List<TeacherEx> findTeacherByClass(TeacherEx teacherEx);

    public List<TeacherEx> addTeacher(Teacher teacher);

    public List<TeacherEx> updateTeacher(Teacher teacher);

    public List<TeacherEx> deleteTeacher(String num);
}
