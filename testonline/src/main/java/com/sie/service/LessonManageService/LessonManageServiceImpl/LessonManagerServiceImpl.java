package com.sie.service.LessonManageService.LessonManageServiceImpl;

import com.sie.domain.Lesson;
import com.sie.mapper.LessonManageMapper.LessonManageMapper;
import com.sie.service.LessonManageService.LessonManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.spel.ast.NullLiteral;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Null;
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
   public  List<Lesson>  findLessonByName(Lesson lesson ) {
   List<Lesson> lessonList=lessonManageMapper.findLessonByName(lesson);

        return lessonList;

   }

   @Override
   public List<Lesson> findAllLessonr() {

      return lessonManageMapper.findAllLesson();
   }

   //<!--科目增加之前的判断是否已存在-->
   public List<Lesson> findLessonByLesNameAndByLesId(Lesson lesson){
      List<Lesson> lessonByLesNameAndByLesId = lessonManageMapper.findLessonByLesNameAndByLesId(lesson);
      if (lessonByLesNameAndByLesId.size() != 0 ){
         return lessonByLesNameAndByLesId;
      }
      return null;
   }
}
