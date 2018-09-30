package com.sie.mapper.InforMangeMapper;

import com.sie.domain.Infor;

public interface InforMangeMapper {

    public void updateAdmin(Infor infor);

    public void updateTeacher(Infor infor);

    public void updateStudent(Infor infor);

    public String findAdminPwd(Infor infor);

    public  String findTeacherPwd(Infor infor);

    public  String findStudentPwd(Infor infor);


}
