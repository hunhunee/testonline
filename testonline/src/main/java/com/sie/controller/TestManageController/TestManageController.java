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
    public void addTest(Test test){
        System.out.println("增加题目类容："+test.getTestContent());
        testManageService.addTest(test);
    }

    @PostMapping("/delete")
    public void deleteTest(String id){
        System.out.println("删除id:"+id);
        if(id!=null){
            int i =Integer.parseInt(id);
            testManageService.deleteTest(i);
        }


    }

    @PostMapping("/update")
    public void updateTest(Test test){
        testManageService.updateTest(test);
        System.out.println("更新的内容："+test.getTestId()+":"+test.getTestContent()+":"+test.getRightans1());
    }

    @PostMapping("/find")
    public List<Test> findTest(Test test){
       List<Test> testList= testManageService.findTest(test);
        System.out.println("查找的题型："+test.getTestType()+"数量："+testList.size());
        return testList;
    }
}
