package com.sie.service.LessonManageService;

import com.sie.domain.Lesson;
import java.util.List;
public interface LessonManagerService {
    public void addLesson(Lesson lesson);

    public void deleteLesson(String id);

    public void updateLesson(Lesson lesson);

    public Lesson findLessonByName(Lesson lesson);

    public List<Lesson> findAllLessonr();
}
