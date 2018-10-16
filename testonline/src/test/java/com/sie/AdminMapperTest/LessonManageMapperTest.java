package com.sie.AdminMapperTest;

import com.sie.domain.Lesson;
import com.sie.mapper.LessonManageMapper.LessonManageMapper;
import com.sun.org.apache.xpath.internal.SourceTree;
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
        com.sie.domain.Lesson les = new com.sie.domain.Lesson();
        les.setLesId(11);
        les.setLesName("ss");
       lessonManageMapper.addLesson(les);
    }

    @Test
    public void deleteLesson() {
        com.sie.domain.Lesson les = new com.sie.domain.Lesson();
        les.setLesName("java");
        lessonManageMapper.deleteLesson(les);
    }

     @Test
        public void  updateLesson(){
        com.sie.domain.Lesson les=new com.sie.domain.Lesson();
         les.setLesId(4);
         les.setLesName("clanguage");

         lessonManageMapper.updateLesson(les);
        }
        @Test
         public  void findLessonByNameTest(){
            com.sie.domain.Lesson les = new com.sie.domain.Lesson();
            les.setLesName("java1");
            les=lessonManageMapper.findLessonByName(les);
            if(les!=null){
                System.out.println("yes");
            }else{
                System.out.println("no");
            }
            //System.out.println("科目"+les.getLesId());
                    }
        @Test
        public  void findAllLessonTest(){

           List<com.sie.domain.Lesson> lessonList=lessonManageMapper.findAllLesson();
            System.out.println(lessonList.size());
        }



 }

