package com.sie.controller.ScoreController;

import com.sie.domain.Student;
import com.sie.domain.User;
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

    //查询个人成绩 --学生模块
    @PostMapping("/findStudentScore")
    public List<Student> findStudentScore (String value) throws Exception{
        List<Student> list = scoreService.findScoreByStuId(value);
        return list;
    }
    //查询平均成绩  --教师模块
    @PostMapping("/findAvgScore")
    public Double findAvgScore(@Param("value1")String value1, @Param("value2")String value2)  throws  Exception{
        Double avgScore = scoreService.findAvgScore(value1, value2);
        return avgScore;
    }

    //查询最高成绩 --教师模块
    @PostMapping("/findMaxScore")
    public Double findMaxScore(@Param("value1")String value1, @Param("value2")String value2)  throws  Exception{
        Double maxScore = scoreService.findMaxScore(value1, value2);
        return maxScore;
    }

    //查询最低成绩 --教师模块
    @PostMapping("/findMinScore")
    public Double findMinScore(@Param("value1")String value1, @Param("value2")String value2)  throws  Exception{
        Double minScore = scoreService.findMinScore(value1, value2);
        return minScore;
    }

}
