package com.sie.domain;

public class TeacherEx extends Teacher {
    private Lesson lesson;
    private Class_ aClass;

    public Class_ getaClass() {
        return aClass;
    }

    public void setaClass(Class_ aClass) {
        this.aClass = aClass;
    }

    private String lesName;
    private String className;

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Lesson getLesson() {
        return lesson;
    }

    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
    }

    public String getLesName() {
        return lesName;
    }

    public void setLesName(String lesName) {
        this.lesName = lesName;
    }
}
