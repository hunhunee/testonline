package com.sie.TestManageTest.mapper;

import com.sie.mapper.TestManageMapper.TestManageMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestManageTest {
    @Autowired
    private TestManageMapper testManageMapper;

    @Test
    public void addTest(){
        com.sie.domain.Test t = new com.sie.domain.Test();
        t.setTestContent("10+10=?");
        t.setTestAns1("10");
        t.setTestAns2("20");
        t.setTestAns3("21");
        t.setTestAns4("25");
        t.setRightans1("20");
        t.setTestType("1");
        testManageMapper.addTest(t);
    }

    @Test
    public void deleteTest(){
        //testManageMapper.deleteTest();
    }

    @Test
    public void updateTest(){
        com.sie.domain.Test t = new com.sie.domain.Test();
        t.setTestId(4);
        t.setTestContent("10+11=?");
        t.setTestAns1("0");
        t.setTestAns2("20");
        t.setTestAns3("21");
        t.setTestAns4("25");
        t.setRightans1("20");
        t.setTestCourse("2");
        t.setTestType("1");
        testManageMapper.updateTest(t);
    }

    @Test
    public void findTest(){
        com.sie.domain.Test t = new com.sie.domain.Test();
        t.setTestCourse("2");
        t.setTestType("1");
      List<com.sie.domain.TestEx> testList= testManageMapper.findTest(t);
        System.out.println(testList.get(1).getLesson().getLesName());
        System.out.println(testList.get(1).getTestId());
        System.out.println(testList.get(1).getTestContent());
    }

    @Test
    public void findAllTest(){
        com.sie.domain.Test t = new com.sie.domain.Test();
        t.setTestType("4");
        List<com.sie.domain.TestEx> testList= testManageMapper.findAllTest(t);
        System.out.println(testList.get(1).getLesson().getLesName());
        System.out.println(testList.get(1).getTestId());
        System.out.println(testList.get(1).getTestContent());
    }
}
