package com.sie.service.TestManageService;

import com.sie.domain.Test;

import java.util.List;

public interface TestManageService {
    public void addTest(Test test);

    public void deleteTest(int id);

    public void updateTest(Test test);

    public List<Test> findTest(Test test);

    public List<Test> findAllTest(Test test);
}
