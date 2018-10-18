package com.sie.AdminServiceTest;

import com.sie.domain.Info;
import com.sie.domain.Student;
import com.sie.domain.Teacher;
import com.sie.service.InfoMangeService.InfoManagerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class InfoManagServiceTest {
    @Autowired
    private InfoManagerService infoManagerService;
    @Test
    public void updateAdmintest(){
        //测试管理员密码是否正确
         Info info = new Info();
         info.setUserid(1);
         info.setPassword("234");
         info.setNewpassword("234");
        infoManagerService.updateAdmin(info);
    }

    @Test
    public void updateTeachertest(){
        Info info = new Info();
        info.setUserid(1);
        info.setPassword("123");
        info.setNewpassword("123");
        infoManagerService.updateTeacher(info);

    }
    @Test
    public void updateStudenttest(){
        Info info = new Info();
        info.setUserid(14);
        info.setPassword("123");
        info.setNewpassword("123");
        infoManagerService.updateStudent(info);
    }
}
