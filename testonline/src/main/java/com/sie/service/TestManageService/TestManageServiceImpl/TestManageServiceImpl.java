package com.sie.service.TestManageService.TestManageServiceImpl;

import com.sie.domain.Test;
import com.sie.domain.TestEx;
import com.sie.domain.User;
import com.sie.mapper.TestManageMapper.TestManageMapper;
import com.sie.service.TestManageService.TestManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Service
public class TestManageServiceImpl implements TestManageService{

    @Autowired
    TestManageMapper testManageMapper;


    @Override
    public List<TestEx> addTest(Test test,HttpSession session) {
        testManageMapper.addTest(test);
        User user = (User) session.getAttribute("user");
        List<TestEx> testList=null;
        if (user.getIdentity().equals("2")){
            testList=testManageMapper.findTest(test);

        }else{
            testList =testManageMapper.findAllTest(test);
        }
        for (int i = 0; i <testList.size() ; i++) {
            testList.get(i).setLesName(testList.get(i).getLesson().getLesName());
            if(testList.get(i).getTestType().equals("1")){
                testList.get(i).setTestTypeName("单选题");
            }else if(testList.get(i).getTestType().equals("2")){
                testList.get(i).setTestTypeName("多选题");
            }else if(testList.get(i).getTestType().equals("3")){
                testList.get(i).setTestTypeName("判断题");
            }else{
                testList.get(i).setTestTypeName("综合题");
            }

            if (testList.get(i).getTestStatus().equals("0")){
                testList.get(i).setTestStatusName("随机");
            }else{
                testList.get(i).setTestStatusName("必考");
            }
        }
        return testList;
    }

    @Override
    public List<TestEx> deleteTest(Test test, HttpSession session) {


        testManageMapper.deleteTest(test);
        User user = (User) session.getAttribute("user");
        List<TestEx> testList=null;
        if (user.getIdentity().equals("2")){
            testList=testManageMapper.findTest(test);

        }else{
            testList =testManageMapper.findAllTest(test);
        }

        for (int i = 0; i <testList.size() ; i++) {
            testList.get(i).setLesName(testList.get(i).getLesson().getLesName());
            if(testList.get(i).getTestType().equals("1")){
                testList.get(i).setTestTypeName("单选题");
            }else if(testList.get(i).getTestType().equals("2")){
                testList.get(i).setTestTypeName("多选题");
            }else if(testList.get(i).getTestType().equals("3")){
                testList.get(i).setTestTypeName("判断题");
            }else{
                testList.get(i).setTestTypeName("综合题");
            }

            if (testList.get(i).getTestStatus().equals("0")){
                testList.get(i).setTestStatusName("随机");
            }else{
                testList.get(i).setTestStatusName("必考");
            }
        }
        return testList;
    }

    @Override
    public List<TestEx> updateTest(Test test,HttpSession session) {

        testManageMapper.updateTest(test);

        User user = (User) session.getAttribute("user");
        List<TestEx> testList=null;
        if (user.getIdentity().equals("2")){
            testList=testManageMapper.findTest(test);

        }else{
            testList =testManageMapper.findAllTest(test);
        }

        for (int i = 0; i <testList.size() ; i++) {
            testList.get(i).setLesName(testList.get(i).getLesson().getLesName());
            if(testList.get(i).getTestType().equals("1")){
                testList.get(i).setTestTypeName("单选题");
            }else if(testList.get(i).getTestType().equals("2")){
                testList.get(i).setTestTypeName("多选题");
            }else if(testList.get(i).getTestType().equals("3")){
                testList.get(i).setTestTypeName("判断题");
            }else{
                testList.get(i).setTestTypeName("综合题");
            }

            if (testList.get(i).getTestStatus().equals("0")){
                testList.get(i).setTestStatusName("随机");
            }else{
                testList.get(i).setTestStatusName("必考");
            }
        }
        return testList;
    }

    @Override
    public List<TestEx> findTest(Test test) {
        List<TestEx> testList =testManageMapper.findTest(test);

        for (int i = 0; i <testList.size() ; i++) {
            testList.get(i).setLesName(testList.get(i).getLesson().getLesName());
            if(testList.get(i).getTestType().equals("1")){
                testList.get(i).setTestTypeName("单选题");
            }else if(testList.get(i).getTestType().equals("2")){
                testList.get(i).setTestTypeName("多选题");
            }else if(testList.get(i).getTestType().equals("3")){
                testList.get(i).setTestTypeName("判断题");
            }else{
                testList.get(i).setTestTypeName("综合题");
            }

            if (testList.get(i).getTestStatus().equals("0")){
                testList.get(i).setTestStatusName("随机");
            }else{
                testList.get(i).setTestStatusName("必考");
            }
        }
        return testList;
    }

    @Override
    public List<TestEx> findAllTest(Test test) {

        List<TestEx> testList =testManageMapper.findAllTest(test);
        for (int i = 0; i <testList.size() ; i++) {
            testList.get(i).setLesName(testList.get(i).getLesson().getLesName());
            if(testList.get(i).getTestType().equals("1")){
                 testList.get(i).setTestTypeName("单选题");
            }else if(testList.get(i).getTestType().equals("2")){
                testList.get(i).setTestTypeName("多选题");
            }else if(testList.get(i).getTestType().equals("3")){
                testList.get(i).setTestTypeName("判断题");
            }else{
                testList.get(i).setTestTypeName("综合题");
            }

            if (testList.get(i).getTestStatus().equals("0")){
                testList.get(i).setTestStatusName("随机");
            }else{
                testList.get(i).setTestStatusName("必考");
            }
        }
        return testList;
    }
}
