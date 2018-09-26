package com.sie.service.LoginService;

import com.sie.domain.Admin;
import com.sie.domain.Student;
import com.sie.domain.Teacher;
import com.sie.domain.User;

public interface LoginService {
    public Admin findAdminByNumAndPwd(User user);

    public Teacher findTeacherByNumAndPwd(User user);

    public Student findStudentByNumAndPwd(User user);
}
