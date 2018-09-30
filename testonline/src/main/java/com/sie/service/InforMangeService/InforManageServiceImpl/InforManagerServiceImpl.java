package com.sie.service.InforMangeService.InforManageServiceImpl;

import com.sie.domain.Infor;
import com.sie.mapper.InforMangeMapper.InforMangeMapper;
import com.sie.mapper.PersonManageMapper.StudentManageMapper;
import com.sie.service.InforMangeService.InforManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InforManagerServiceImpl implements InforManagerService {
    @Autowired
    private InforMangeMapper inforMangeMapper;
    @Override
    public String updateAdmin(Infor infor) {
        String oldPwd= inforMangeMapper.findAdminPwd(infor);
        if(oldPwd.equals(infor.getPassword())){
            System.out.println("密码正确！");
            inforMangeMapper.updateAdmin(infor);
            return "修改密码成功！";
        }else{
            return "您输入的旧密码不正确！";
        }
    }
    @Override
   public String updateTeacher(Infor infor){
        String oldPwd = inforMangeMapper.findTeacherPwd(infor);
        if(oldPwd.equals(infor.getPassword())){
            System.out.println("密码正确!");
            inforMangeMapper.updateTeacher(infor);
            return "修改密码成功！";
        }else {
            return "您输入的旧密码不正确！";
        }
    }
    @Override
   public String updateStudent(Infor infor) {
        String oldPwd = inforMangeMapper.findStudentPwd(infor);
        if(oldPwd.equals(infor.getPassword())){
            System.out.println("密码正确!");
            inforMangeMapper.updateStudent(infor);
            return "修改密码成功！";
        }else {
            return "您输入的旧密码不正确！";
        }


    }


}
