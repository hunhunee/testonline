package com.sie.domain;

import java.util.Date;

public class Lesson {
    private Integer lesId;

    private String lesName;

    private Date lesDatatime;

    private String lesXxx1;

    private String lesXxx2;

    public Integer getLesId() {
        return lesId;
    }

    public void setLesId(Integer lesId) {
        this.lesId = lesId;
    }

    public String getLesName() {
        return lesName;
    }

    public void setLesName(String lesName) {
        this.lesName = lesName == null ? null : lesName.trim();
    }

    public Date getLesDatatime() {
        return lesDatatime;
    }

    public void setLesDatatime(Date lesDatatime) {
        this.lesDatatime = lesDatatime;
    }

    public String getLesXxx1() {
        return lesXxx1;
    }

    public void setLesXxx1(String lesXxx1) {
        this.lesXxx1 = lesXxx1 == null ? null : lesXxx1.trim();
    }

    public String getLesXxx2() {
        return lesXxx2;
    }

    public void setLesXxx2(String lesXxx2) {
        this.lesXxx2 = lesXxx2 == null ? null : lesXxx2.trim();
    }
}