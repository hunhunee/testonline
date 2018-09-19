package com.sie.mapper.TestManageMapper;

import com.sie.domain.Test;

import java.util.List;

public interface TestManageMapper {
    public void addTest(Test test);

    public void deleteTest(Test test);

    public void updateTest(Test test);

    public List<Test> findTest(Test test);

    public List<Test> findAllTest(Test test);
 }
