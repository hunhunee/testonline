package com.sie.service.ExamService;

import com.sie.domain.TestEx;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ExamPaperService {
    public List<TestEx> findExamPaper(TestEx testEx);
}
