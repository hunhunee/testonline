package com.sie.mapper.InfoMangeMapper;

import com.sie.domain.Info;

public interface InfoMangeMapper {

    public void updateAdmin(Info info);

    public void updateTeacher(Info info);

    public void updateStudent(Info info);

    public String findAdminPwd(Info info);

    public  String findTeacherPwd(Info info);

    public  String findStudentPwd(Info info);


}
