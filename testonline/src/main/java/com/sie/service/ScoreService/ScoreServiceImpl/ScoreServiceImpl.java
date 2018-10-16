package com.sie.service.ScoreService.ScoreServiceImpl;

import com.sie.domain.ScoreEx;
import com.sie.domain.Student;
import com.sie.domain.StudentAnswer;
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

    //统计不同区间成绩的个数
    public ScoreEx findScoreScope(@Param("teaClass") String teaClass, @Param("teaCourse")String teaCourse) throws Exception {
        ScoreEx zeroToFiftyNine = scoreMapper.findZeroToFiftyNine(teaClass, teaCourse);
        ScoreEx sixtyToSeventyNine = scoreMapper.findSixtyToSeventyNine(teaClass, teaCourse);
        ScoreEx eightyToeightyNine = scoreMapper.findEightyToEightyNine(teaClass, teaCourse);
        ScoreEx ninetyToHundred = scoreMapper.findNinetyToHundred(teaClass, teaCourse);
        ScoreEx scoreEX = new ScoreEx();
        scoreEX.setZeroToFiftyNine(zeroToFiftyNine.getZeroToFiftyNine());
        scoreEX.setSixtyToSeventyNine(sixtyToSeventyNine.getSixtyToSeventyNine());
        scoreEX.setEightyToeightyNine(eightyToeightyNine.getEightyToeightyNine());
        scoreEX.setNinetyToHundred(ninetyToHundred.getNinetyToHundred());
        return scoreEX;
    }

    //教师查询所教班级及科目的同学的成绩 --教师
    @Override
    public List<StudentAnswer> findByClassAndByLenName(@Param("teaClass") String teaClass, @Param("teaCourse")String teaCourse) throws Exception {
        List<StudentAnswer> byClassAndByLenName = scoreMapper.findByClassAndByLenName(teaClass, teaCourse);
        System.out.println(byClassAndByLenName.size());
        for (int i = 0; i <byClassAndByLenName.size() ; i++) {
            //byClassAndByLenName.get(i).setClassName();
        }
        return byClassAndByLenName;
    }

    //教师查询学生信息by学生学号
    @Override
    public List<StudentAnswer> findByStuNum(@Param("stuNum")String stuNum,@Param("testCourse") String testCourse) throws Exception {
        System.out.println(stuNum+testCourse);
        List<StudentAnswer> byStuNum = scoreMapper.findByStuNum(stuNum,testCourse);

        if(byStuNum.size()!=0){
            for (int i = 0; i <byStuNum.size() ; i++) {
                byStuNum.get(i).setClassName(byStuNum.get(i).getaClass().getClassName());
            }
            return byStuNum;
        }else{
             return  byStuNum;
        }



    }

    @Override
    public void deleteScoreByStuId(Student student) {
        scoreMapper.deleteScoreByStuId(student);
    }

    //查询最低成绩 、最高成绩、平均成绩 --教师
    @Override
    public ScoreEx findMinAndMaxAndAvgScore(@Param("teaClass") String teaClass, @Param("teaCourse")String teaCourse) throws Exception {
        ScoreEx score = scoreMapper.findMinAndMaxAndAvgScore(teaClass,teaCourse);
        return score;
    }



//    //查询区间0-59之间的成绩个数
//    @Override
//    public ScoreEx findZeroToFiftyNine(@Param("teaClass") String teaClass, @Param("teaCourse")String teaCourse) throws Exception {
//        ScoreEx zeroToFiftyNine = scoreMapper.findZeroToFiftyNine(teaClass, teaCourse);
//        return zeroToFiftyNine;
//    }
//
//    //查询区间60-79之间的成绩个数
//    @Override
//    public ScoreEx findSixtyToSeventyNine(String teaClass, String teaCourse) throws Exception {
//        ScoreEx sixtyToSeventyNine = scoreMapper.findSixtyToSeventyNine(teaClass, teaCourse);
//        return sixtyToSeventyNine;
//    }
//
//    //查询区间80-89之间的成绩个数
//    @Override
//    public ScoreEx findEightyToEightyNine(String teaClass, String teaCourse) throws Exception {
//        ScoreEx eightyToeightyNine = scoreMapper.findEightyToEightyNine(teaClass, teaCourse);
//        return eightyToeightyNine;
//    }
//
//    //查询区间90-100之间的成绩个数
//    @Override
//    public ScoreEx findNinetyToHundred(String teaClass, String teaCourse) throws Exception {
//        ScoreEx ninetyToHundred = scoreMapper.findNinetyToHundred(teaClass, teaCourse);
//        return ninetyToHundred;
//    }

    //学生查询各科的成绩 -- 学生
    @Override
    public List<Student> findScoreByStuId(String stuNum) throws Exception {
        List<Student> lists = scoreMapper.findScoreByStuId(stuNum);
        for (int i = 0; i <lists.size() ; i++) {
            //list.get(0)获取list集合中的第一个元素
            for (int j = 0; j <lists.get(i).getStudentAnswer().size() ; j++){
                //获取到Student里面的stuName值并把它赋值给StudentAnswer里面的stuName
                lists.get(i).getStudentAnswer().get(j).setStuName(lists.get(i).getStuName());
                //同理
                lists.get(i).getStudentAnswer().get(j).setStuNum(lists.get(i).getStuNum());
                lists.get(i).getStudentAnswer().get(j).setLesName(lists.get(i).getStudentAnswer().get(j).getLesson().getLesName());
                lists.get(i).getStudentAnswer().get(j).setClassName(lists.get(i).getStudentAnswer().get(j).getaClass().getClassName());

            }

        }
        return lists;
    }


}
