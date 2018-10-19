package com.sie.service.InfoMangeService.InfoManageServiceImpl;

import com.sie.domain.Info;
import com.sie.mapper.InfoMangeMapper.InfoMangeMapper;
import com.sie.service.InfoMangeService.InfoManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InfoManagerServiceImpl implements InfoManagerService {
    @Autowired
    private InfoMangeMapper infoMangeMapper;
    @Override
    public String updateAdmin(Info info) {
        String oldPwd = infoMangeMapper.findAdminPwd(info);

        if(oldPwd.equals(info.getPassword())){
            System.out.println("密码正确！");
            infoMangeMapper.updateAdmin(info);
            return "1";
        }
        else{
            System.out.println("您输入的旧密码不正确！");
            return "0";
        }
    }
    @Override
   public String updateTeacher(Info info){
        String oldPwd = infoMangeMapper.findTeacherPwd(info);
        if(oldPwd.equals(info.getPassword())){
            System.out.println("密码正确!");
            infoMangeMapper.updateTeacher(info);
            return "1";
        }else {
            System.out.println("您输入的旧密码不正确！");
            return "0";
        }
    }
    @Override
   public String updateStudent(Info info) {
        String oldPwd = infoMangeMapper.findStudentPwd(info);
        if(oldPwd.equals(info.getPassword())){
            System.out.println("密码正确!");
            infoMangeMapper.updateStudent(info);
            return "1";
        }else {
            System.out.println("您输入的旧密码不正确！");
            return "0";
        }


    }


}
