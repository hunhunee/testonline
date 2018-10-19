package com.sie.ExamTest.service;

import com.sie.domain.TestEx;
import com.sie.mapper.ExamMapper.ExamPaperMapper;
import com.sie.service.ExamService.ExamPaperService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ExamPaperServiceTest {
    @Autowired
    private ExamPaperService examPaperService;

    @Test
    public void findExamPaperTest(){
        TestEx testEx = new TestEx();
        testEx.setTestCourse("２");
        List<TestEx> testExList =examPaperService.findExamPaper(testEx);
    }




}
