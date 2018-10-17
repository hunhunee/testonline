package com.sie.controller.ClassManageController;

import com.sie.domain.Class_;
import com.sie.domain.Lesson;
import com.sie.service.ClassManageService.ClassManagerService;
import com.sie.service.LessonManageService.LessonManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ClassManage")
public class ClassManageController {
    @Autowired
    private ClassManagerService classManagerService;

    @PostMapping("/addClass")
    public  List<Class_> addClass(Class_ class_){
        System.out.println("增加班级："+class_.getClassName());
        List<Class_> classList = classManagerService.addClass(class_);
        return classList;
    }

    @PostMapping("/deleteClass")
    public List<Class_> deleteClass(Class_ class_){

        if(class_.getClassName() !=null){
            List<Class_> classList = classManagerService.deleteClass(class_);
            return classList;
        }
        return null;
    }

    @PostMapping("/updateClass")
    public List<Class_> updateClass(Class_ class_){
       List<Class_>  classList =classManagerService.updateClass(class_);
        return classList;
    }

    @PostMapping("/findClassByName")
    public  List<Class_>  findClassByNameTest(Class_ class_){
       System.out.println("查找的班级名："+class_.getClassName());
        List<Class_> class1=classManagerService.findClassByName(class_);

        return class1;
    }

    @PostMapping("/findClassById")
    public  List<Class_>  findClassByIdTest(Class_ class_){
        System.out.println("查找的班级ID："+class_.getClassId());
        List<Class_> class1=classManagerService.findClassById(class_);
        return class1;
    }
    @PostMapping("/findAllClass")
    public List<Class_> findAllClassTest(){
      List<Class_> classList=classManagerService.findAllClass();
      return classList;

    }
}
