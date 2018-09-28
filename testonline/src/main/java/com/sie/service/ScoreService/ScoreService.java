package com.sie.service.ScoreService;

import com.sie.domain.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ScoreService {

    //查询学生的各科成绩
    public List<Student> findScoreByStuId(String value) throws Exception;

    //查询平均成绩
    public Double findAvgScore(@Param("value1") String value1, @Param("value2")String value2) throws  Exception;

    //查询最高成绩
    public  Double findMaxScore(@Param("value1")String value1, @Param("value2")String value2) throws  Exception;

    //查询最低成绩
    public  Double findMinScore(@Param("value1")String value1, @Param("value2")String value2) throws  Exception;
}
