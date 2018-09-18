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
   public void addLesson(Lesson lesson) {

      lessonManageMapper.addLesson(lesson);
   }

   @Override
   public void deleteLesson(String id) {
      lessonManageMapper.deleteLesson(id);
   }

   @Override
   public void updateLesson(Lesson lesson) {
      lessonManageMapper.updateLesson(lesson);
   }

   @Override
   public Lesson findLessonByName(Lesson lesson) {
      return null;
   }

   @Override
   public List<Lesson> findAllLessonr() {
      return null;
   }
}
