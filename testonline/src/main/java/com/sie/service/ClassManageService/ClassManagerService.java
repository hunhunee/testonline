package com.sie.service.ClassManageService;

import com.sie.domain.Class_;
import com.sie.domain.Lesson;

import java.util.List;

public interface ClassManagerService {
    public List<Class_> addClass(Class_ class_);

    public List<Class_> deleteClass(Class_ class_);

    public List<Class_> updateClass(Class_ class_);

    public  List<Class_>  findClassByName(Class_ class_);

    public  List<Class_>  findClassById(Class_ class_);

    public List<Class_> findAllClass();

}
