package com.sie.service.AdminService.AdminServiceImpl;

import com.sie.domain.Teacher;
import com.sie.mapper.AdminMapper.TeacherManageMapper;
import com.sie.service.AdminService.TeacherManagerService;
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
    public void addTeacher(Teacher teacher) {
        teacherManageMapper.addTeacher(teacher);
    }

    @Override
    public void updateTeacher(Teacher teacher) {
        teacherManageMapper.updateTeacher(teacher);
    }

    @Override
    public void deleteTeacher(String num) {
        teacherManageMapper.deleteTeacher(num);
    }
}
