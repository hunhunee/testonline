package com.sie.service.TestManageService;

import com.sie.domain.Test;
import com.sie.domain.TestEx;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface TestManageService {
    public List<TestEx> addTest(Test test,HttpSession session);

    public List<TestEx> deleteTest(Test test, HttpSession session);

    public List<TestEx> updateTest(Test test,HttpSession session);

    public List<TestEx> findTest(Test test);

    public List<TestEx> findAllTest(Test test);
}
