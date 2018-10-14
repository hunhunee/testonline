package com.sie.service.ClassManageService.ClassManageServiceImpl;

import com.sie.domain.Class_;
import com.sie.domain.Lesson;
import com.sie.mapper.ClassManageMapper.ClassManageMapper;
import com.sie.mapper.LessonManageMapper.LessonManageMapper;
import com.sie.service.ClassManageService.ClassManagerService;
import com.sie.service.LessonManageService.LessonManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassManagerServiceImpl implements ClassManagerService {

   @Autowired
   private ClassManageMapper classManageMapper;



   public List<Class_> addClass(Class_ class_) {
      classManageMapper.addClass(class_);
      List<Class_> lessonList=classManageMapper.findAllClass();
      return  lessonList;
   }


   public List<Class_> deleteClass(Class_ class_) {
      classManageMapper.deleteClass(class_);
      List<Class_> lessonList=classManageMapper.findAllClass();
      return lessonList;
   }


   public List<Class_> updateClass(Class_ class_) {
      classManageMapper.updateClass(class_);
      List<Class_> lessonList=classManageMapper.findAllClass();
      return lessonList;

   }


   public  List<Class_>  findClassByName(Class_ class_) {
      List<Class_> lessonList=classManageMapper.findClassByName(class_);

        return lessonList;

   }


   public List<Class_> findAllClass() {

      return classManageMapper.findAllClass();
   }
}
