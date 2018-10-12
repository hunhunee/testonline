package com.sie.controller.ScoreController;

import com.sie.domain.ScoreEx;
import com.sie.domain.Student;
import com.sie.domain.StudentAnswer;
import com.sie.service.ScoreService.ScoreService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/score")
public class ScoreController {
    
    @Autowired
    private ScoreService scoreService;

    //教师查询所教班级及科目的同学的成绩 --教师
    @PostMapping("/findByClassAndByLenName")
    public List<StudentAnswer> findByClassAndByLenName(@Param("teaClass") String teaClass, @Param("teaCourse")String teaCourse) throws Exception {
        List<StudentAnswer> byClassAndByLenName = scoreService.findByClassAndByLenName(teaClass, teaCourse);
        return byClassAndByLenName;
    }

    //教师查询学生信息by学生学号
    @PostMapping("/findByStuNum")
    public StudentAnswer findByStuNum(@Param("stuNum")String stuNum,@Param("teaCourse") String teaCourse) throws Exception {
        StudentAnswer byStuNum = scoreService.findByStuNum(stuNum, teaCourse);
        System.out.println(byStuNum);
        return byStuNum;
    }

    //查询个人成绩 -- 学生模块
    @PostMapping("/findStudentScore")
    public List<Student> findStudentScore (String stuNum) throws Exception{
        List<Student> list = scoreService.findScoreByStuId(stuNum);
        //System.out.println(list);
        return list;
    }

    //统计不同区间成绩的个数
    @PostMapping("/findScoreScope")
    public ScoreEx findScoreScope(@Param("teaClass") String teaClass, @Param("teaCourse")String teaCourse) throws Exception{
        ScoreEx scoreScope = scoreService.findScoreScope(teaClass, teaCourse);
        return scoreScope;
    }

//    //查询平均成绩  -- 教师模块
//    @PostMapping("/findAvgScore")
//    public ScoreEx findAvgScore(@Param("value1")String value1, @Param("value2")String value2)  throws  Exception{
//        ScoreEx avgScore = scoreService.findAvgScore(value1, value2);
//        return avgScore;
//    }
//
//    //查询最高成绩 --教师模块
//    @PostMapping("/findMaxScore")
//    public ScoreEx findMaxScore(@Param("value1")String value1, @Param("value2")String value2)  throws  Exception{
//        ScoreEx maxScore = scoreService.findMaxScore(value1, value2);
//        return maxScore;
//    }

    //查询最低成绩、最高成绩、平均成绩 -- 教师模块
    @PostMapping("/findMinAndMaxAndAvgScore")
    public ScoreEx findMinAndMaxAndAvgScore(@Param("teaClass") String teaClass, @Param("teaCourse")String teaCourse)  throws  Exception{
        ScoreEx score = scoreService.findMinAndMaxAndAvgScore(teaClass, teaCourse);
        return score;
    }
//
//    //查询区间0-59之间的成绩个数
//    @PostMapping("/findZeroToFiftyNine")
//    public ScoreEx findZeroToFiftyNine(@Param("teaClass") String teaClass, @Param("teaCourse")String teaCourse)throws Exception{
//        ScoreEx zeroToFiftyNine = scoreService.findZeroToFiftyNine(teaClass, teaCourse);
//        return zeroToFiftyNine;
//    }
//
//    //查询区间60-79之间的成绩个数
//    @PostMapping("/findSixtyToSeventyNine")
//    public ScoreEx findSixtyToSeventyNine(@Param("teaClass") String teaClass, @Param("teaCourse")String teaCourse)throws Exception{
//        ScoreEx sixtyToSeventyNine = scoreService.findSixtyToSeventyNine(teaClass, teaCourse);
//        return sixtyToSeventyNine;
//    }
//
//    //查询区间80-89之间的成绩个数
//    @PostMapping("/findEightyToEightyNine")
//    public ScoreEx findEightyToEightyNine(@Param("teaClass") String teaClass, @Param("teaCourse")String teaCourse)throws Exception{
//        ScoreEx eightyToeightyNine = scoreService.findEightyToEightyNine(teaClass, teaCourse);
//        return eightyToeightyNine;
//    }
//
//    //查询区间90-100之间的成绩个数
//    @PostMapping("/findNinetyToHundred")
//    public ScoreEx findNinetyToHundred(@Param("teaClass") String teaClass, @Param("teaCourse")String teaCourse)throws Exception{
//        ScoreEx ninetyToHundred = scoreService.findNinetyToHundred(teaClass, teaCourse);
//        return ninetyToHundred;
//    }
}
