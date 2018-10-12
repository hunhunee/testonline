package com.sie.controller.TestManageController;

import com.sie.domain.Test;
import com.sie.domain.TestEx;
import com.sie.service.TestManageService.TestManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/testManage")
public class TestManageController {
    @Autowired
    private TestManageService testManageService;

    @PostMapping("/add")
    public List<TestEx> addTest(Test test){
        System.out.println("增加题目类容："+test.getTestContent());

        List<TestEx> testList = testManageService.addTest(test);
        System.out.println(testList.size());
        return testList;
    }

    @PostMapping("/delete")
    public List<TestEx> deleteTest(Test test){
        System.out.println("testid"+test.getTestId());
        if(test.getTestId()!=null){

          List<TestEx> testList= testManageService.deleteTest(test);
            System.out.println(testList.size());
          return testList;
        }
       return null;
    }

    @PostMapping("/update")
    public List<TestEx> updateTest(Test test){
       List<TestEx> testList = testManageService.updateTest(test);

        return testList;
    }

    @PostMapping("/find")
    public List<TestEx> findTest(Test test){
       List<TestEx> testList= testManageService.findTest(test);
        System.out.println("查找的题型："+test.getTestType()+"数量："+testList.size());
        return testList;
    }


    @PostMapping("/findAll")
    public List<TestEx> findAllTest(Test test){
        List<TestEx> testList= testManageService.findAllTest(test);
        return testList;
    }

}
