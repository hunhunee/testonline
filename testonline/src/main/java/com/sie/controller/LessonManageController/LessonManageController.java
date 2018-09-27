package com.sie.controller.LessonManageController;

import com.sie.domain.Lesson;
import com.sie.service.LessonManageService.LessonManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/LessonManage")
public class LessonManageController {
    @Autowired
    private LessonManagerService lessonManagerService;

    @PostMapping("/addLesson")
    public  void addLesson(Lesson lesson){
        System.out.println("增加科目："+lesson.getLesName());
        lessonManagerService.addLesson(lesson);
    }

    @PostMapping("/deleteLesson")
    public List<Lesson> deleteLesson(Lesson lesson){

        if(lesson.getLesName()!=null){
            List<Lesson> lessonList = lessonManagerService.deleteLesson(lesson);
            return lessonList;
        }
        return null;
    }

    @PostMapping("/updateLesson")
    public List<Lesson> updateLesson(Lesson lesson){
       List<Lesson>  lessonList =lessonManagerService.updateLesson(lesson);
        return lessonList;
    }

    @PostMapping("/findLessonByName")
    public  Lesson  findLessonByNameTest(Lesson lesson){
       System.out.println("查找的科目名："+lesson.getLesName());
       Lesson lesson1=lessonManagerService.findLessonByName(lesson);

        return lesson1;
    }

    @PostMapping("/findAllLesson")
    public List<Lesson> findAllLessonTest(){
      List<Lesson> lessonList=lessonManagerService.findAllLessonr();
      return lessonList;

    }
}
