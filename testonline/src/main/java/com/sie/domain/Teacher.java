package com.sie.domain;

public class Teacher {
    private Integer teaId;

    private String teaName;

    private String teaPassword;

    private Integer teaCourse;

    private String teaNum;

    private int teaClass;

    public Integer getTeaId() {
        return teaId;
    }

    public void setTeaId(Integer teaId) {
        this.teaId = teaId;
    }

    public String getTeaName() {
        return teaName;
    }

    public void setTeaName(String teaName) {
        this.teaName = teaName == null ? null : teaName.trim();
    }

    public String getTeaPassword() {
        return teaPassword;
    }

    public void setTeaPassword(String teaPassword) {
        this.teaPassword = teaPassword == null ? null : teaPassword.trim();
    }

    public Integer getTeaCourse() {
        return teaCourse;
    }

    public void setTeaCourse(Integer teaCourse) {
        this.teaCourse = teaCourse;
    }

    public String getTeaNum() {
        return teaNum;
    }

    public void setTeaNum(String teaNum) {
        this.teaNum = teaNum == null ? null : teaNum.trim();
    }

    public int getTeaClass() {
        return teaClass;
    }

    public void setTeaClass(int teaClass) {
        this.teaClass = teaClass;
    }
}