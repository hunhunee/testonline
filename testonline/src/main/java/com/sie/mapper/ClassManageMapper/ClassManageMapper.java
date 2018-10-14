package com.sie.mapper.ClassManageMapper;

import com.sie.domain.Class_;
import com.sie.domain.Lesson;

import java.util.List;

public interface ClassManageMapper {
    public void addClass(Class_ class_);

    public void  deleteClass(Class_ class_);

    public void  updateClass(Class_ class_);

    public Class_ findClassByName(Class_ class_);

    public List<Class_> findAllClass();


}
