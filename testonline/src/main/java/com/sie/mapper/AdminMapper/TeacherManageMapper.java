package com.sie.mapper.AdminMapper;

import com.sie.domain.Teacher;

import java.util.List;

public interface TeacherManageMapper {
    public void addTeacher(Teacher teacher);

    public void deleteTeacher(String num);

    public void updateTeacher(Teacher teacher);

    public Teacher findTeacherByNum(String num);

    public List<Teacher> findAllTeacher();

    public int findCount();
}
