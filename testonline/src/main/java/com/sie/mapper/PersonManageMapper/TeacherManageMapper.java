package com.sie.mapper.PersonManageMapper;

import com.sie.domain.Teacher;
import com.sie.domain.TeacherEx;

import java.util.List;

public interface TeacherManageMapper {
    public void addTeacher(Teacher teacher);

    public void deleteTeacher(String num);

    public void updateTeacher(Teacher teacher);

    public List<TeacherEx> findTeacherByNum(String num);

    public List<TeacherEx> findTeacherByClass(TeacherEx teacherEx);

    public List<TeacherEx> findAllTeacher();

    public int findCount();
}
