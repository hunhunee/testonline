package com.sie.service.InforMangeService.InforManageServiceImpl;

import com.sie.domain.Admin;
import com.sie.domain.Student;
import com.sie.domain.Teacher;
import com.sie.mapper.InforMangeMapper.InforMangeMapper;
import com.sie.service.InforMangeService.InforManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class InforManagerServiceImpl implements InforManagerService {
    @Autowired
    private InforMangeMapper inforMangeMapper;

    @Override
    public List<Admin> updateAdmin(Admin admin) {
        inforMangeMapper.updateAdmin(admin);
        List<Admin> adminList = inforMangeMapper.findAllAdmin();
        return adminList;
    }

    @Override
    public List<Teacher> updateTeacher(Teacher teacher) {
        inforMangeMapper.updateTeacher(teacher);
        List<Teacher> teacherList = inforMangeMapper.findAllTeacher();
        return teacherList;
    }

    @Override
    public List<Student> updateStudent(Student student) {
        inforMangeMapper.updateStudent(student);
        List<Student> studentList = inforMangeMapper.findAllStudent();
        return studentList;
    }

}
