package com.sie.service.TestManageService;

import com.sie.domain.Test;

import java.util.List;

public interface TestManageService {
    public void addTest(Test test);

    public List<Test> deleteTest(Test test);

    public List<Test> updateTest(Test test);

    public List<Test> findTest(Test test);

    public List<Test> findAllTest(Test test);
}
