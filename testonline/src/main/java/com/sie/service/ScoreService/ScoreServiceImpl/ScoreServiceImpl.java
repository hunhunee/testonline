package com.sie.service.ScoreService.ScoreServiceImpl;

import com.sie.domain.Student;
import com.sie.mapper.ScoreManagerMapper.ScoreMapper;
import com.sie.service.ScoreService.ScoreService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScoreServiceImpl implements ScoreService {
    @Autowired
    private ScoreMapper scoreMapper;

    //查询最低成绩 教师
    @Override
    public Double findMinScore(String value1, String value2) throws Exception {
        Double minScore = scoreMapper.findMinScore(value1, value2);
        return minScore;
    }

    //查询最高成绩  教师
    @Override
    public Double findMaxScore(String value1, String value2) throws Exception {
        Double maxScore = scoreMapper.findMaxScore(value1, value2);
        return maxScore;
    }

    //查询平均成绩  教师
    @Override
    public Double findAvgScore(@Param("value1")String value1, @Param("value2")String value2) throws Exception {
        Double avgScore = scoreMapper.findAvgScore(value1, value2);
        return avgScore;
    }
    //学生查询各科的成绩 学生
    @Override
    public List<Student> findScoreByStuId(String value) throws Exception {
        List<Student> lists = scoreMapper.findScoreByStuId(value);
        return lists;
    }


}
