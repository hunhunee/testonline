package com.sie.ExamTest.mapper;

import com.sie.domain.*;
import com.sie.mapper.ExamMapper.ExamPaperMapper;
import com.sie.mapper.LoginMapper.LoginMapper;
import com.sie.mapper.TestManageMapper.TestManageMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ExamPaperTest {
    @Autowired
    private ExamPaperMapper examPaperMapper;

    @Test
    public void findPriorExamPaperTest(){
        TestEx testEx = new TestEx();
        testEx.setTestType("1");
        testEx.setTestCourse("2");
        List<TestEx> testExList =examPaperMapper.findPriorExamPaper(testEx);
        System.out.println(testExList.size());
    }

    @Test
    public void findRandomExamPaperTest(){
        TestEx testEx = new TestEx();
        testEx.setTestType("1");
        testEx.setTestCourse("2");
        testEx.setTestRandomNum(13);
        List<TestEx> testExList =examPaperMapper.findRandomExamPaper(testEx);
        System.out.println(testExList.size());
    }



}
