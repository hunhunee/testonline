package com.sie.service.ExamService.ExamServiceImpl;

import com.sie.domain.TestEx;
import com.sie.mapper.ExamMapper.ExamPaperMapper;
import com.sie.service.ExamService.ExamPaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ExamPaperServiceImpl implements ExamPaperService{
    @Autowired
    private ExamPaperMapper examPaperMapper;

    @Override
    public List<TestEx> findExamPaper(TestEx testEx) {
        String testCourse =testEx.getTestCourse();
        List<TestEx> paperList=new ArrayList<TestEx>();

        TestEx singleTestEx= new TestEx();
        singleTestEx.setTestType("1");
        singleTestEx.setTestCourse(testCourse);
        List<TestEx> singlePriorList = examPaperMapper.findPriorExamPaper(singleTestEx);
        List<TestEx> singlePaperList=new ArrayList<TestEx>();
        if(singlePriorList.size()==15){
            singlePaperList.addAll(singlePriorList);
        }else if(singlePriorList.size()>15){
            for (int i=0;i<15;i++){
                singlePaperList.add(singlePriorList.get(i));
            }
        }else{
            singleTestEx.setTestRandomNum(15-singlePriorList.size());
            List<TestEx> singleRandomList =examPaperMapper.findRandomExamPaper(singleTestEx);
            singlePaperList.addAll(singlePriorList);
            singlePaperList.addAll(singleRandomList);
            System.out.println("单选抽取的题数："+singlePaperList.size());
        }




        //抽取多选题
        TestEx multipleTestEx= new TestEx();
        multipleTestEx.setTestType("2");
        multipleTestEx.setTestCourse(testCourse);
        List<TestEx> multiplePaperList=new ArrayList<TestEx>();
        List<TestEx> multiplePriorList = examPaperMapper.findPriorExamPaper(multipleTestEx);
        if(multiplePriorList.size()==10){
            multiplePaperList.addAll(multiplePriorList);
        }else if(multiplePriorList.size()>10){
            for (int i=0;i<10;i++){
                multiplePaperList.add(multiplePaperList.get(i));
            }
        }else{
            multipleTestEx.setTestRandomNum(10-multiplePriorList.size());
            List<TestEx> multipleRandomList =examPaperMapper.findRandomExamPaper(multipleTestEx);
            multiplePaperList.addAll(multiplePriorList);
            multiplePaperList.addAll(multipleRandomList);
        }
        System.out.println("多选抽取的题数："+multiplePaperList.size());


        TestEx judgeTestEx= new TestEx();
        judgeTestEx.setTestType("3");
        judgeTestEx.setTestCourse(testCourse);
        List<TestEx> judgePaperList=new ArrayList<TestEx>();
        List<TestEx> judgePriorList = examPaperMapper.findPriorExamPaper(judgeTestEx);
        if(judgePriorList.size()==10){
         judgePaperList.addAll(judgePriorList);
        }else if(judgePriorList.size()>10){
            for (int i=0;i<10;i++){
                judgePaperList.add(judgePriorList.get(i));
            }
        }else{
            judgeTestEx.setTestRandomNum(10-judgePriorList.size());
            List<TestEx> judgeRandomList =examPaperMapper.findRandomExamPaper(judgeTestEx);
            judgePaperList.addAll(judgePriorList);
            judgePaperList.addAll(judgeRandomList);
        }
        System.out.println("判断抽取的题数："+judgePaperList.size());


        TestEx computeTestEx= new TestEx();
        computeTestEx.setTestType("4");
        computeTestEx.setTestCourse(testCourse);
        List<TestEx> computePaperList=new ArrayList<TestEx>();
        List<TestEx> computePriorList = examPaperMapper.findPriorExamPaper(computeTestEx);
        if(computePriorList.size()==2){
           computePaperList.addAll(computePriorList);
        }else if(computePriorList.size()>2){
            for (int i=0;i<2;i++){
                computePaperList.add(computePriorList.get(i));
            }
        }else{
            computeTestEx.setTestRandomNum(2-computePriorList.size());
            List<TestEx> computeRandomList =examPaperMapper.findRandomExamPaper(computeTestEx);
            computePaperList.addAll(computePriorList);
            computePaperList.addAll(computeRandomList);
        }
        System.out.println("计算抽取的题数："+computePaperList.size());

        paperList.addAll(singlePaperList);
        paperList.addAll(multiplePaperList);
        paperList.addAll(judgePaperList);
        paperList.addAll(computePaperList);
        System.out.println("总题数："+paperList.size());

        return paperList;
    }
}
