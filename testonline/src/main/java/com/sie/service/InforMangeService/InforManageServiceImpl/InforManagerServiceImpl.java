package com.sie.service.InforMangeService.InforManageServiceImpl;

import com.sie.domain.Admin;
import com.sie.domain.Student;
import com.sie.domain.Teacher;
import com.sie.mapper.InforMangeMapper.InforMangeMapper;
import com.sie.service.InforMangeService.InforManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InforManagerServiceImpl implements InforManagerService {
    @Autowired
    private InforMangeMapper inforMangeMapper;

    @Override
    public Admin updateAdmin(Admin admin) {
        return null;
    }

    @Override
    public Teacher updateTeacher(Teacher teacher) {
        return null;
    }

    @Override
    public Student updateStudent(Student student) {
        return null;
    }

}
