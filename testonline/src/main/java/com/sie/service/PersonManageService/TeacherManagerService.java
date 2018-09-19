package com.sie.service.PersonManageService;

import com.sie.domain.Teacher;

import java.util.List;


public interface TeacherManagerService {
    public List<Teacher> findAllTeacher();

    public Teacher findTeacherByNum(String num);

    public void addTeacher(Teacher teacher);

<<<<<<< HEAD
    public void updateTeacher(Teacher teacher);
=======
    public List<Teacher> updateTeacher(Teacher teacher);
>>>>>>> zjBranch

    public void deleteTeacher(String num);
}
