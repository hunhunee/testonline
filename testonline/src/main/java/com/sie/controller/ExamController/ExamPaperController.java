package com.sie.controller.ExamController;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sie.domain.StudentAnswer;
import com.sie.domain.TestEx;
import com.sie.service.ExamService.ExamPaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/exam")
public class ExamPaperController {

    @Autowired
    private ExamPaperService examPaperService;


    @PostMapping("/findExamPaper")
    public List<TestEx> findExamPaper(TestEx testEx){
        System.out.println("试卷科目："+testEx.getTestCourse());
        List<TestEx> testExList = examPaperService.findExamPaper(testEx);
        return testExList;
    }

    @PostMapping("/addExamResult")
    public void addExamResult(HttpServletRequest request){
        List<TestEx> testExList = new ArrayList<TestEx>();
        String jsonStr=request.getParameter("examList");

        JSONObject jsonobject = JSONObject.parseObject(jsonStr);
        JSONObject studentAnswerObject =jsonobject.getJSONObject("studentAnswer");
        StudentAnswer studentAnswer =new StudentAnswer();
        int stuId=Integer.parseInt((String) studentAnswerObject.get("stuId"));
        studentAnswer.setStuId(stuId);
        studentAnswer.setStuClass((String) studentAnswerObject.get("stuClass"));

        JSONArray jsonArray=jsonobject.getJSONArray("examList");
        for (int i = 0; i < jsonArray.size(); i++) {
            TestEx testEx = new TestEx();
            JSONObject jsonObject=jsonArray.getJSONObject(i);
            testEx.setTestId((Integer) jsonObject.get("testId"));
            testEx.setTestContent((String) jsonObject.get("testContent"));
            testEx.setTestType((String) jsonObject.get("testType"));
            testEx.setTestCourse((String) jsonObject.get("testCourse"));
            testEx.setRightans1((String) jsonObject.get("rightans1"));
            testEx.setRightans2((String) jsonObject.get("rightans2"));
            testEx.setRightans3((String) jsonObject.get("rightans3"));
            testEx.setRightans4((String) jsonObject.get("rightans4"));
            testEx.setTestAnswer((String) jsonObject.get("testAnswer"));
            JSONArray testAnswerArray=jsonObject.getJSONArray("testAnswerArray");
            if (testAnswerArray!=null){
                String[] testAnswerArray1=new String[testAnswerArray.size()];
                for (int j=0;j<testAnswerArray.size();j++){
                    testAnswerArray1[j]= (String) testAnswerArray.get(j);
                }
                testEx.setTestAnswerArray(testAnswerArray1);
            }


            testExList.add(testEx);
        }

        examPaperService.addExamResult(testExList,studentAnswer);

    }

}
