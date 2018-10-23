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

//    @PostMapping("/addLesson")
//    public  void addLesson(Lesson lesson){
//        System.out.println("增加科目："+lesson.getLesName());
//        lessonManagerService.addLesson(lesson);
//    }
            @PostMapping("/addLesson")
            public  List<Lesson> addLesson(Lesson lesson){
                System.out.println("增加科目："+lesson.getLesName());
                List<Lesson> lessonList = lessonManagerService.addLesson(lesson);
                return lessonList;
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
    public  List<Lesson>  findLessonByNameTest(Lesson lesson){
       System.out.println("查找的科目名："+lesson.getLesName());
        List<Lesson> lesson1=lessonManagerService.findLessonByName(lesson);

        return lesson1;
    }

    @PostMapping("/findAllLesson")
    public List<Lesson> findAllLessonTest(){
      List<Lesson> lessonList=lessonManagerService.findAllLessonr();
      return lessonList;

    }

    //<!--科目增加之前的判断是否已存在-->
    @PostMapping("/findLessonByLesNameAndByLesId")
    public List<Lesson> findLessonByLesNameAndByLesId(Lesson lesson){
        List<Lesson> lessonByLesNameAndByLesId = lessonManagerService.findLessonByLesNameAndByLesId(lesson);
        return lessonByLesNameAndByLesId;
    }
}
