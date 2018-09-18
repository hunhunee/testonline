package com.sie.AdminMapperTest;

import com.sie.domain.Lesson;
import com.sie.mapper.LessonManageMapper.LessonManageMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class LessonManageMapperTest {
    @Autowired
    private LessonManageMapper lessonManageMapper;

    @Test
    public  void addLesson(){
       Lesson lesson = new Lesson();
        lesson.setLesName("java");

       lessonManageMapper.addLesson(lesson);
    }
    @Test
    public void deleteLesson() {
        //Lesson lesson = new Lesson();
        //lesson.setLesName("java");
        lessonManageMapper.deleteLesson("3");
    }

     @Test
        public void  updateLesson(){
         Lesson lesson = new Lesson();
         lesson.setLesId(4);
         lesson.setLesName("clanguage");

         lessonManageMapper.updateLesson(lesson);
        }
        @Test
         public  void findLessonByNameTest(){
             Lesson lesson = lessonManageMapper.findLessonByName("java");
            if(lesson!=null){
                System.out.println("yes");
            }else{
                System.out.println("no");
            }
            System.out.println("科目"+lesson.getLesName());
                    }
        @Test
        public  void findAllLessonTest(){
             List<Lesson> lessonList=lessonManageMapper.findAllLesson();
             System.out.println("科目总数："+lessonList.size());
        }

 }

