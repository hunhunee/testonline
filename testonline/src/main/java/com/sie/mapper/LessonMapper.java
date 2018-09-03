package com.sie.mapper;

import com.sie.domain.Lesson;

public interface LessonMapper {
    int deleteByPrimaryKey(Integer lesId);

    int insert(Lesson record);

    int insertSelective(Lesson record);

    Lesson selectByPrimaryKey(Integer lesId);

    int updateByPrimaryKeySelective(Lesson record);

    int updateByPrimaryKey(Lesson record);
}