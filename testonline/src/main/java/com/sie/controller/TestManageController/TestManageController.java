package com.sie.controller.TestManageController;

import com.sie.domain.Test;
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
    public List<Test> addTest(Test test){
        System.out.println("增加题目类容："+test.getTestContent());
        List<Test> testList = testManageService.addTest(test);
        return testList;
    }

    @PostMapping("/delete")
    public List<Test> deleteTest(Test test){

        if(test.getTestId()!=null){

          List<Test> testList= testManageService.deleteTest(test);
          return testList;
        }
       return null;
    }

    @PostMapping("/update")
    public List<Test> updateTest(Test test){
       List<Test> testList = testManageService.updateTest(test);

        return testList;
    }

    @PostMapping("/find")
    public List<Test> findTest(Test test){
       List<Test> testList= testManageService.findTest(test);
        System.out.println("查找的题型："+test.getTestType()+"数量："+testList.size());
        return testList;
    }


    @PostMapping("/findAll")
    public List<Test> findAllTest(Test test){
        List<Test> testList= testManageService.findAllTest(test);
        return testList;
    }

}
