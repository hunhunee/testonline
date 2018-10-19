package com.sie.mapper.ScoreManagerMapper;

import com.sie.domain.ScoreEx;
import com.sie.domain.Student;
import com.sie.domain.StudentAnswer;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ScoreMapper {

    //查询学生的各科成绩
    public List<Student> findScoreByStuId(String stuNum) throws Exception;

    //查询最低成绩、最高成绩、平均成绩
    public  ScoreEx findMinAndMaxAndAvgScore(@Param("teaClass") String teaClass, @Param("teaCourse")String teaCourse) throws  Exception;

    //查询区间0-59之间的成绩个数
    public ScoreEx findZeroToFiftyNine(@Param("teaClass") String teaClass, @Param("teaCourse")String teaCourse) throws  Exception;
    //查询区间60-79之间的成绩个数
    public ScoreEx findSixtyToSeventyNine(@Param("teaClass") String teaClass, @Param("teaCourse")String teaCourse) throws  Exception;

    //查询区间80-89之间的成绩个数
    public ScoreEx findEightyToEightyNine(@Param("teaClass") String teaClass, @Param("teaCourse")String teaCourse) throws  Exception;

    //查询区间90-100之间的成绩个数
    public ScoreEx findNinetyToHundred(@Param("teaClass") String teaClass, @Param("teaCourse")String teaCourse) throws  Exception;

    //教师查询所教班级及科目的同学的成绩
    public List<StudentAnswer> findByClassAndByLenName(@Param("teaClass") String teaClass, @Param("teaCourse")String teaCourse) throws  Exception;

    //教师查询学生信息by学生学号
    public List<StudentAnswer> findByStuNum(@Param("stuNum")String stuNum,@Param("testCourse") String teaCourse)throws  Exception;

    public List<StudentAnswer> findScoreByStuIdAndLesName(StudentAnswer studentAnswer);

    public void deleteScoreByStuId(Student student);
}
