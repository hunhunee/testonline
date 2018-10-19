package com.sie.mapper.ExamMapper;

import com.sie.domain.StudentAnswer;
import com.sie.domain.Test;
import com.sie.domain.TestEx;

import java.util.List;

public interface ExamPaperMapper {
    public List<TestEx> findPriorExamPaper(Test testEx);

    public List<TestEx> findRandomExamPaper(Test testEx);

    public void addExamResult(StudentAnswer studentAnswer);
}
