package com.sie.mapper;

import com.sie.domain.Teacher;

public interface TeacherMapper {
    int deleteByPrimaryKey(Integer teaId);

    int insert(Teacher record);

    int insertSelective(Teacher record);

    Teacher selectByPrimaryKey(Integer teaId);

    int updateByPrimaryKeySelective(Teacher record);

    int updateByPrimaryKey(Teacher record);
}