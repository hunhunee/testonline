package com.sie.service.TestManageService;

import com.sie.domain.Test;
import com.sie.domain.TestEx;

import java.util.List;

public interface TestManageService {
    public List<TestEx> addTest(Test test);

    public List<TestEx> deleteTest(Test test);

    public List<TestEx> updateTest(Test test);

    public List<TestEx> findTest(Test test);

    public List<TestEx> findAllTest(Test test);
}
