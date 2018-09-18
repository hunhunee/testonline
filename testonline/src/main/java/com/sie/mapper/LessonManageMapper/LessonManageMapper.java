package com.sie.mapper.LessonManageMapper;

import com.sie.domain.Lesson;

import java.util.List;

public interface LessonManageMapper {
    public void addLesson(Lesson lesson);

    public void deleteLesson(String id);

    public void updateLesson(Lesson lesson);

    public Lesson findLessonByName(String name);

    public List<Lesson> findAllLesson();


}
