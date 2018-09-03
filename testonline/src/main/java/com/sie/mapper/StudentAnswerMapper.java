package com.sie.mapper;

import com.sie.domain.StudentAnswer;

public interface StudentAnswerMapper {
    int deleteByPrimaryKey(Integer stuAnsId);

    int insert(StudentAnswer record);

    int insertSelective(StudentAnswer record);

    StudentAnswer selectByPrimaryKey(Integer stuAnsId);

    int updateByPrimaryKeySelective(StudentAnswer record);

    int updateByPrimaryKey(StudentAnswer record);
}