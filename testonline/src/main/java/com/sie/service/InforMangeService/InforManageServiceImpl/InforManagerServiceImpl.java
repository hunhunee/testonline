package com.sie.service.InforMangeService.InforManageServiceImpl;

import com.sie.domain.Infor;
import com.sie.domain.Student;
import com.sie.mapper.InforMangeMapper.InforMangeMapper;
import com.sie.mapper.PersonManageMapper.StudentManageMapper;
import com.sie.service.InforMangeService.InforManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class InforManagerServiceImpl implements InforManagerService {
    @Autowired
    private InforMangeMapper inforMangeMapper;
    @Autowired
    private StudentManageMapper studentManageMapper;
    @Override
    public List<Student> updateAdmin(Infor infor) {
        inforMangeMapper.updateAdmin(infor);
        List<Student> adminList = studentManageMapper.selectAllStudent();
        return adminList;
    }
    @Override
   public List<Student> updateTeacher(Infor infor){
        inforMangeMapper.updateTeacher(infor);
        List<Student> teacherList = studentManageMapper.selectAllStudent();
        return teacherList;
    }
    @Override
   public List<Student> updateStudent(Infor infor) {
        inforMangeMapper.updateStudent(infor);
       List<Student> studentList = studentManageMapper.selectAllStudent();
      return studentList;
    }


}
