package com.sie.controller.ExamController;

import com.sie.domain.TestEx;
import com.sie.service.ExamService.ExamPaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/exam")
public class ExamPaperController {

    @Autowired
    private ExamPaperService examPaperService;

    @PostMapping("/findExamPaper")
    public List<TestEx> findExamPaper(TestEx testEx){
        List<TestEx> testExList = examPaperService.findExamPaper(testEx);
        return testExList;
    }

}
