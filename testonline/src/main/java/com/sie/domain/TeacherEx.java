package com.sie.domain;

public class TeacherEx extends Teacher {
    private Lesson lesson;
    private String lesName;

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
