package com.sie.TestManageTest.service;

import com.sie.mapper.TestManageMapper.TestManageMapper;
import com.sie.service.TestManageService.TestManageService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestManageTest {
    @Autowired
    private TestManageService testManageService;




    @Test
    public void findAllTest(){
        com.sie.domain.Test t = new com.sie.domain.Test();
        t.setTestType("1");
        List<com.sie.domain.Test> testList= testManageService.findAllTest(t);
        System.out.println(testList.size());
    }
}
