package com.sie;

import com.sie.domain.Lesson;
import com.sie.service.LessonManageService.LessonManagerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class LessonTest {
    @Autowired
    private LessonManagerService lessonManagerService;

    @Test
    public void testLessonByNameAndById()throws Exception{
        Lesson lesson = new Lesson();
        lesson.setLesName("english");
        lesson.setLesId('0');
        List<Lesson> lessonByLesNameAndByLesId = lessonManagerService.findLessonByLesNameAndByLesId(lesson);
        System.out.println(lessonByLesNameAndByLesId.get(0).getLesName()+lessonByLesNameAndByLesId.get(0).getLesId());
    }
}
