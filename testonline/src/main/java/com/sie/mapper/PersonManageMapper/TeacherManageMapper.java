package com.sie.mapper.PersonManageMapper;

import com.sie.domain.Teacher;

import java.util.List;

public interface TeacherManageMapper {
    public void addTeacher(Teacher teacher);

    public void deleteTeacher(String num);

    public void updateTeacher(Teacher teacher);

    public List<Teacher> findTeacherByNum(String num);

    public List<Teacher> findAllTeacher();

    public int findCount();
}
