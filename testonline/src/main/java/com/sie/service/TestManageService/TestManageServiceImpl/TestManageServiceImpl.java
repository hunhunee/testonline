package com.sie.service.TestManageService.TestManageServiceImpl;

import com.sie.domain.Test;
import com.sie.mapper.TestManageMapper.TestManageMapper;
import com.sie.service.TestManageService.TestManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestManageServiceImpl implements TestManageService{

    @Autowired
    TestManageMapper testManageMapper;


    @Override
    public List<Test> addTest(Test test) {
        testManageMapper.addTest(test);
        List<Test> testList =testManageMapper.findAllTest(test);
        return testList;
    }

    @Override
    public List<Test> deleteTest(Test test) {

        testManageMapper.deleteTest(test);
        List<Test> testList =testManageMapper.findTest(test);
        return testList;
    }

    @Override
    public List<Test> updateTest(Test test) {

        testManageMapper.updateTest(test);
        List<Test> testList= testManageMapper.findTest(test);
        return testList;
    }

    @Override
    public List<Test> findTest(Test test) {
        List<Test> testList =testManageMapper.findTest(test);
        return testList;
    }

    @Override
    public List<Test> findAllTest(Test test) {

        List<Test> testList =testManageMapper.findAllTest(test);
        return testList;
    }
}
