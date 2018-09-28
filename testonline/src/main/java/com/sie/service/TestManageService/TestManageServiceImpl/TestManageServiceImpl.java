package com.sie.service.TestManageService.TestManageServiceImpl;

import com.sie.domain.Test;
import com.sie.domain.TestEx;
import com.sie.mapper.TestManageMapper.TestManageMapper;
import com.sie.service.TestManageService.TestManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TestManageServiceImpl implements TestManageService{

    @Autowired
    TestManageMapper testManageMapper;


    @Override
    public List<TestEx> addTest(Test test) {
        testManageMapper.addTest(test);
        List<TestEx> testList =testManageMapper.findAllTest(test);
        return testList;
    }

    @Override
    public List<TestEx> deleteTest(Test test) {

        testManageMapper.deleteTest(test);
        List<TestEx> testList =testManageMapper.findTest(test);
        return testList;
    }

    @Override
    public List<TestEx> updateTest(Test test) {

        testManageMapper.updateTest(test);
        List<TestEx> testList= testManageMapper.findAllTest(test);
        return testList;
    }

    @Override
    public List<TestEx> findTest(Test test) {
        List<TestEx> testList =testManageMapper.findTest(test);

        for (int i = 0; i <testList.size() ; i++) {
            testList.get(i).setLesName(testList.get(i).getLesson().getLesName());
        }
        return testList;
    }

    @Override
    public List<TestEx> findAllTest(Test test) {

        List<TestEx> testList =testManageMapper.findAllTest(test);
        for (int i = 0; i <testList.size() ; i++) {
            testList.get(i).setLesName(testList.get(i).getLesson().getLesName());
        }
        return testList;
    }
}
