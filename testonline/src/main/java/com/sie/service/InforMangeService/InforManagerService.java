package com.sie.service.InforMangeService;

import com.sie.domain.Infor;
import com.sie.domain.Student;
import java.util.List;


public interface InforManagerService {

    public List<Student> updateAdmin(Infor infor);

    public List<Student> updateTeacher(Infor infor);

   public List<Student> updateStudent(Infor infor);



}
