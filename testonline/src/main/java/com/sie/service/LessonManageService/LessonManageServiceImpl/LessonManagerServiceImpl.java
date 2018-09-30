package com.sie.service.LessonManageService.LessonManageServiceImpl;

import com.sie.domain.Lesson;
import com.sie.mapper.LessonManageMapper.LessonManageMapper;
import com.sie.service.LessonManageService.LessonManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LessonManagerServiceImpl implements LessonManagerService{

   @Autowired
   private LessonManageMapper lessonManageMapper;


   @Override
   public List<Lesson> addLesson(Lesson lesson) {
      lessonManageMapper.addLesson(lesson);
      List<Lesson> lessonList=lessonManageMapper.findAllLesson();
      return  lessonList;
   }

   @Override
   public List<Lesson> deleteLesson(Lesson lesson) {
      lessonManageMapper.deleteLesson(lesson);
      List<Lesson> lessonList=lessonManageMapper.findAllLesson();
      return lessonList;
   }

   @Override
   public List<Lesson> updateLesson(Lesson lesson) {
      lessonManageMapper.updateLesson(lesson);
      List<Lesson> lessonList=lessonManageMapper.findAllLesson();
      return lessonList;

   }

@Override
   public  Lesson  findLessonByName(Lesson lesson ) {
        Lesson lessonList=lessonManageMapper.findLessonByName(lesson);

        return lessonList;

   }

   @Override
   public List<Lesson> findAllLessonr() {

      return lessonManageMapper.findAllLesson();
   }
}
