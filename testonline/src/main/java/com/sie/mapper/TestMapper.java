package com.sie.mapper;

import com.sie.domain.Test;

public interface TestMapper {
    int deleteByPrimaryKey(Integer testId);

    int insert(Test record);

    int insertSelective(Test record);

    Test selectByPrimaryKey(Integer testId);

    int updateByPrimaryKeySelective(Test record);

    int updateByPrimaryKey(Test record);
}