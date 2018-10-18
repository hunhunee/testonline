package com.sie.service.LessonManageService;

import com.sie.domain.Lesson;
import java.util.List;
public interface LessonManagerService {
    public List<Lesson> addLesson(Lesson lesson);

    public List<Lesson> deleteLesson(Lesson lesson);

    public List<Lesson> updateLesson(Lesson lesson);

    public  Lesson  findLessonByName(Lesson lesson);

    public List<Lesson> findAllLessonr();

    public List<Lesson> findLessonByLesNameAndByLesId(Lesson lesson);

}
