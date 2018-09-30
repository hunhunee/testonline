package com.sie.ScoreTest;

import com.sie.controller.ScoreController.ScoreController;
import com.sie.domain.ScoreEx;
import com.sie.domain.Student;
import com.sie.domain.StudentAnswer;
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

    //学生service
    @Test
    public void testStudentScore() throws  Exception{
        List<Student> list = scoreService.findScoreByStuId("s001");
        System.out.println(list);
    }

//    //学生controller
//    @Test
//    public void testStudentScoreController() throws  Exception{
//        List<Student> list = scoreController.findStudentScore("1508030227");
//        System.out.println(list);
//    }

//    //平均分service
//    @Test
//    public void testAvgScore() throws  Exception{
//        ScoreEx avgScore = scoreService.findAvgScore("2","2");
//        System.out.println(avgScore.getAvgscore());
//    }
//
//    //平均分controller
//    @Test
//    public void testAvgScoreController() throws  Exception{
//        ScoreEx avgScore = scoreController.findAvgScore("2","2");
//        System.out.println(avgScore.getAvgscore()+".......");
//    }
//
//    //最高分service
//    @Test
//    public void testMaxScore() throws  Exception{
//        ScoreEx maxScore = scoreService.findMaxScore("2", "2");
//        System.out.println("最高成绩"+maxScore.getMaxscore());
//    }
//
//    //最高分controller
//    @Test
//    public void testMaxScoreController() throws  Exception{
//        ScoreEx maxScore = scoreController.findMaxScore("2", "2");
//        System.out.println("最高成绩为：----"+maxScore.getMaxscore());
//    }

//    //最低/高/平均分service
//    @Test
//    public void testMinScore() throws  Exception{
//        ScoreEx score= scoreService.findMinAndMaxAndAvgScore("2","2");
//        System.out.println("最低成绩："+score.getMinscore()+"  ,最高成绩："+score.getMaxscore()+" , 平均分数: "+score.getAvgscore());
//    }
//
//    //最低/高/平均分controller
//    @Test
//    public void testMinScoreController() throws  Exception{
//        ScoreEx score = scoreController.findMinAndMaxAndAvgScore("2","2");
//        System.out.println("最低成绩："+score.getMinscore()+"  ,最高成绩："+score.getMaxscore()+" , 平均分数: "+score.getAvgscore());
//    }

    //区间0-59成绩个数
//    @Test
//    public void test_0_59_Score() throws  Exception{
//        ScoreEx score= scoreService.findZeroToFiftyNine("2","2");
//        System.out.println("区间为0-59之间的成绩个数为："+score.getZeroToFiftyNine());
//    }
//    //区间0-59成绩个数Controller
//    @Test
//    public void test_0_59_ScoreController() throws  Exception{
//        ScoreEx score= scoreController.findZeroToFiftyNine("2","2");
//        System.out.println("区间为0-59之间的成绩个数为----------："+score.getZeroToFiftyNine());
//    }
//
//    //区间60-79成绩个数
//    @Test
//    public void test_60_79_Score() throws  Exception{
//        ScoreEx score= scoreService.findSixtyToSeventyNine("2","2");
//        System.out.println("区间为60-79之间的成绩个数为："+score.getSixtyToSeventyNine());
//    }
//    //区间60-79成绩个数Controller
//    @Test
//    public void test_60_79_ScoreController() throws  Exception{
//        ScoreEx score= scoreController.findSixtyToSeventyNine("2","2");
//        System.out.println("区间为60-79之间的成绩个数为----------："+score.getSixtyToSeventyNine());
//    }
//
//    //区间80-89成绩个数
//    @Test
//    public void test_80_89_Score() throws  Exception{
//        ScoreEx score= scoreService.findEightyToEightyNine("2","2");
//        System.out.println("区间为80-89之间的成绩个数为："+score.getEightyToeightyNine());
//    }
//    //区间80-89成绩个数Controller
//    @Test
//    public void test_80_89_ScoreController() throws  Exception{
//        ScoreEx score= scoreController.findEightyToEightyNine("2","2");
//        System.out.println("区间为80-89之间的成绩个数为----------："+score.getEightyToeightyNine());
//    }
//
//    //区间90-100成绩个数
//    @Test
//    public void test_90_100_Score() throws  Exception{
//        ScoreEx score= scoreService.findNinetyToHundred("2","2");
//        System.out.println("区间为90-100之间的成绩个数为："+score.getNinetyToHundred());
//    }
//    //区间90-100成绩个数Controller
//    @Test
//    public void test_90_100_ScoreController() throws  Exception{
//        ScoreEx score= scoreController.findNinetyToHundred("2","2");
//        System.out.println("区间为90-100之间的成绩个数为----------："+score.getNinetyToHundred());
//    }

    @Test
    public void  testsocrescpoe() throws  Exception{
        ScoreEx scoreScope = scoreService.findScoreScope("2", "2");
        System.out.println(scoreScope.getNinetyToHundred()+"   ==");
    }

    @Test
    public void  findByClassAndByLenName() throws  Exception{
        List<StudentAnswer> scoreScope = scoreService.findByClassAndByLenName("2", "2");
        for(int i= 0;i<scoreScope.size();i++){
        System.out.println("学号："+scoreScope.get(i).getStuNum()+"姓名："+scoreScope.get(i).getStuNum()
                           + "班级: "+scoreScope.get(i).getStuClass()+"科目："+scoreScope.get(i).getLesName()+
                             "成绩："+scoreScope.get(i).getTotalscore() );
        }
    }

    @Test
    public void  findByClassAndByLenNameController() throws  Exception{
        List<StudentAnswer> scoreScope = scoreController.findByClassAndByLenName("2", "2");
        for(int i= 0;i<scoreScope.size();i++){
            System.out.println("学号："+scoreScope.get(i).getStuNum()+"姓名："+scoreScope.get(i).getStuNum()
                    + "班级: "+scoreScope.get(i).getStuClass()+"科目："+scoreScope.get(i).getLesName()+
                    "成绩："+scoreScope.get(i).getTotalscore() );
        }
    }

    @Test
    public void  testFindByStuNum() throws  Exception{
        StudentAnswer byStuNum = scoreService.findByStuNum("123", "2");
        System.out.println("学号："+byStuNum.getStuNum()+"姓名："+byStuNum.getStuName()
                + "班级: "+byStuNum.getStuClass()+"科目："+byStuNum.getLesName()+
                "成绩："+byStuNum.getTotalscore());
    }



}
