package com.sie.mapper.LessonManageMapper;

import com.sie.domain.Lesson;

import java.util.List;

public interface LessonManageMapper {
    public void addLesson(Lesson lesson);

    public void  deleteLesson(Lesson lesson);

    public void  updateLesson(Lesson lesson);

    public Lesson findLessonByName(Lesson lesson);

    public List<Lesson> findAllLesson();

    public List<Lesson> findLessonByLesNameAndByLesId(Lesson lesson);


}
