package com.sie.AdminServiceTest;

import com.sie.domain.Student;
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
        Student stu = new Student();
        stu.setStuName("张同学");
        stu.setStuPassword("123456");
        stu.setStuNum("1111");
        stu.setStuSex("女");
        stu.setStuClass("信息与安全");
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
        Student stu = new Student();
        stu.setStuNum("1111");
        stu.setStuName("我喜欢你张同学");
        stu.setStuPassword("123456");
        stu.setStuSex("男");
        stu.setStuClass("软件2班");
        studentManagerService.updateStudentByStuNum(stu);
        System.out.println("修改成功!!!");
    }

    //查询单个学生
    @Test
    public void testSelectStudent(){
        List<Student> student = studentManagerService.selectStudentByStuNum("12");
        System.out.println(student.toString());
    }

    //查询所有学生
    @Test
    public void testAllSelectStudent(){
        List<Student> list = studentManagerService.selectAllStudent();
        System.out.println(list);
    }
}
