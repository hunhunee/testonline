package com.sie.ScoreTest;

import com.sie.controller.ScoreController.ScoreController;
import com.sie.domain.Student;
import com.sie.service.ScoreService.ScoreService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ScoreTest {

    @Autowired
    private ScoreService scoreService;

    @Autowired
    private ScoreController scoreController;

    @Test
    public void scoreTest() throws  Exception{
        List<Student> list = scoreService.findScoreByStuId("1508030227");
        System.out.println(list);
    }

    @Test
    public void tsetScoreController() throws  Exception{
        List<Student> studentScore = scoreController.findStudentScore("1234");
        System.out.println(studentScore);
    }


    @Test
    public void testAvgScore() throws  Exception{
        double num = scoreService.findAvgScore("2","2");
        System.out.println(num);
    }

    @Test
    public void testAvgScoreController() throws  Exception{
        double num = scoreController.findAvgScore("2","2");
        System.out.println(num+".......");
    }

    @Test
    public void testMaxScore() throws  Exception{
        double num = scoreService.findMaxScore("2","2");
        System.out.println("最高成绩"+num);
    }

    @Test
    public void testMaxScoreController() throws  Exception{
        double num = scoreController.findMaxScore("2","2");
        System.out.println("最高成绩为：----"+num);
    }

    @Test
    public void testMinScore() throws  Exception{
        double num = scoreService.findMinScore("2","2");
        System.out.println("最低成绩"+num);
    }

    @Test
    public void testMinScoreController() throws  Exception{
        double num = scoreController.findMinScore("2","2");
        System.out.println("最低成绩为：=======----"+num);
    }
}
