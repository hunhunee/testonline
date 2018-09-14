package com.sie.service.PersonManageService.PersonManageServiceImpl;

import com.sie.domain.Teacher;
import com.sie.mapper.PersonManageMapper.TeacherManageMapper;
import com.sie.service.PersonManageService.TeacherManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherManagerServiceImpl implements TeacherManagerService{
    @Autowired
    private TeacherManageMapper teacherManageMapper;

    @Override
    public List<Teacher> findAllTeacher() {

       List<Teacher> teacherList= teacherManageMapper.findAllTeacher();

        return teacherList;
    }

    @Override
    public Teacher findTeacherByNum(String num) {
        Teacher teacher =teacherManageMapper.findTeacherByNum(num);
        return teacher;
    }

    @Override
    public List<Teacher> addTeacher(Teacher teacher) {

        teacherManageMapper.addTeacher(teacher);
        List<Teacher> teacherList=teacherManageMapper.findAllTeacher();
        return teacherList;
    }

    @Override
    public Teacher  updateTeacher(Teacher teacher) {

        teacherManageMapper.updateTeacher(teacher);
       Teacher t = teacherManageMapper.findTeacherByNum(teacher.getTeaNum());
        return t;
    }

    @Override
    public List<Teacher> deleteTeacher(String num) {

        teacherManageMapper.deleteTeacher(num);
        List<Teacher> teacherList=teacherManageMapper.findAllTeacher();
        return teacherList;
    }
}
