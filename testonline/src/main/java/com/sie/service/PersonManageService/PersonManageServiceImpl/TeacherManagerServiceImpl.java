package com.sie.service.PersonManageService.PersonManageServiceImpl;

import com.sie.domain.Lesson;
import com.sie.domain.Teacher;
import com.sie.domain.TeacherEx;
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
    public List<TeacherEx> findAllTeacher() {

       List<TeacherEx> teacherList= teacherManageMapper.findAllTeacher();
        for (int i = 0; i <teacherList.size() ; i++) {
            teacherList.get(i).setLesName(teacherList.get(i).getLesson().getLesName());
            teacherList.get(i).setClassName(teacherList.get(i).getaClass().getClassName());
        }
        return teacherList;
    }

    @Override
    public List<TeacherEx> findTeacherByNum(String num) {
        List<TeacherEx> teacher =teacherManageMapper.findTeacherByNum(num);
        for (int i = 0; i <teacher.size() ; i++) {
            teacher.get(i).setLesName(teacher.get(i).getLesson().getLesName());
            teacher.get(i).setClassName(teacher.get(i).getaClass().getClassName());

        }
        return teacher;
    }

    @Override
    public List<TeacherEx> findTeacherByClass(TeacherEx teacherEx) {
        List<TeacherEx> teacher =teacherManageMapper.findTeacherByClass(teacherEx);
        for (int i = 0; i <teacher.size() ; i++) {
            teacher.get(i).setLesName(teacher.get(i).getLesson().getLesName());
            teacher.get(i).setClassName(teacher.get(i).getaClass().getClassName());

        }
        return teacher;
    }

    @Override
    public List<TeacherEx> addTeacher(Teacher teacher) {

        teacherManageMapper.addTeacher(teacher);
        List<TeacherEx> teacherList=teacherManageMapper.findAllTeacher();
        for (int i = 0; i <teacherList.size() ; i++) {
            teacherList.get(i).setLesName(teacherList.get(i).getLesson().getLesName());
            teacherList.get(i).setClassName(teacherList.get(i).getaClass().getClassName());

        }
        return teacherList;
    }

    @Override
    public List<TeacherEx>  updateTeacher(Teacher teacher) {

        teacherManageMapper.updateTeacher(teacher);
        List<TeacherEx> teacherList = teacherManageMapper.findAllTeacher();
        for (int i = 0; i <teacherList.size() ; i++) {
            teacherList.get(i).setLesName(teacherList.get(i).getLesson().getLesName());
            teacherList.get(i).setClassName(teacherList.get(i).getaClass().getClassName());
        }
         return teacherList;
    }

    @Override
    public List<TeacherEx> deleteTeacher(String num) {

        teacherManageMapper.deleteTeacher(num);
        List<TeacherEx> teacherList=teacherManageMapper.findAllTeacher();
        for (int i = 0; i <teacherList.size() ; i++) {
            teacherList.get(i).setLesName(teacherList.get(i).getLesson().getLesName());
             teacherList.get(i).setClassName(teacherList.get(i).getaClass().getClassName());
        }
        return teacherList;
    }

    public List<Teacher> findTeacherByLesson(String value){
        List<Teacher> teacherByLesson = teacherManageMapper.findTeacherByLesson(value);
        return teacherByLesson;
    }
}
