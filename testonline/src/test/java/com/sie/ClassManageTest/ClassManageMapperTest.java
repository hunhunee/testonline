package com.sie.ClassManageTest;

import com.sie.domain.Class_;
import com.sie.domain.Lesson;
import com.sie.mapper.ClassManageMapper.ClassManageMapper;
import com.sie.mapper.LessonManageMapper.LessonManageMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ClassManageMapperTest {
    @Autowired
    private ClassManageMapper classManageMapper;

    @Test
    public  void addClass(){
        Class_ class_ = new Class_();
        class_.setClassId(5);
        class_.setClassName("java");
       classManageMapper.addClass(class_);
    }
    @Test
    public void deleteClass() {
        Class_ class_ = new Class_();
        class_.setClassName("java");
        classManageMapper.deleteClass(class_);
    }

     @Test
        public void  updateClass(){
        Class_ class_ =new Class_();
          class_.setClassId(1);
          class_.setClassName("1A");

         classManageMapper.updateClass(class_);
        }
        @Test
         public  void findClassByNameTest(){
             Class_ class_=new Class_();
            Class_ class1_=new Class_();
             class_.setClassName("1A");
            class1_=classManageMapper.findClassByName(class_);
            if(class1_!=null){
                System.out.println("yes");
            }else{
                System.out.println("no");
            }
            //System.out.println("科目"+les.getLesId());
                    }
        @Test
        public  void findAllClassTest(){

           List<Class_> classList=classManageMapper.findAllClass();
            System.out.println(classList.size());
        }



 }

