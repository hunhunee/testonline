package com.sie.service.LoginService.LoginServiceImpl;

import com.sie.domain.Admin;
import com.sie.domain.Student;
import com.sie.domain.Teacher;
import com.sie.domain.User;
import com.sie.mapper.LoginMapper.LoginMapper;
import com.sie.service.LoginService.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class loginServiceImpl implements LoginService{
    @Autowired
    private LoginMapper loginMapper;

    @Override
    public Admin findAdminByNumAndPwd(User user) {
        Admin admin=new Admin();
        admin=loginMapper.findAdminByNumAndPwd(user);
        return admin;
    }

    @Override
    public Teacher findTeacherByNumAndPwd(User user) {
        Teacher teacher = new Teacher();
        teacher=loginMapper.findTeacherByNumAndPwd(user);
        return teacher;
    }

    @Override
    public Student findStudentByNumAndPwd(User user) {
        Student student= new Student();
        student=loginMapper.findStudentByNumAndPwd(user);
        return student;
    }
}
