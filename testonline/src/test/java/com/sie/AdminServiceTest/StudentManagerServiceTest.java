package com.sie.AdminServiceTest;

import com.sie.domain.Student;
import com.sie.domain.StudentEx;
import com.sie.service.PersonManageService.StudentManagerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class StudentManagerServiceTest {

    @Autowired
    private StudentManagerService studentManagerService;

    //增加测试
    @Test
    public void testInsertStudent(){
        StudentEx stu = new StudentEx();

        //stu.setStuClass("信息与安全");
        studentManagerService.insertStudent(stu);
        System.out.println("添加成功!!!");
    }

    //删除测试
    @Test
    public void testDeleteStudent(){
        studentManagerService.deleteStudentByStuNum("1111");
        System.out.println("删除成功!!!");
    }

    //修改测试
    @Test
    public void testUpdateStudent(){
        StudentEx stu = new StudentEx();
//        stu.setStuNum("s001");
//        stu.setStuClass(1);
        studentManagerService.updateStudentByStuNum(stu);
        System.out.println("修改成功!!!");
    }

    //查询单个学生
    @Test
    public void testSelectStudent(){
        List<StudentEx> student = studentManagerService.selectStudentByStuNum("s001");
        System.out.println(student.toString());
    }

    //查询所有学生
    @Test
    public void testAllSelectStudent(){
        List<StudentEx> list = studentManagerService.selectAllStudent();
        System.out.println(list.size());
    }
}
