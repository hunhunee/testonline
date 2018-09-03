package com.sie.domain;

public class Student {
    private Integer stuId;

    private String stuName;

    private String stuPassword;

    private String stuSex;

    private String stuNum;

    private String stuXxx2;

    public Integer getStuId() {
        return stuId;
    }

    public void setStuId(Integer stuId) {
        this.stuId = stuId;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName == null ? null : stuName.trim();
    }

    public String getStuPassword() {
        return stuPassword;
    }

    public void setStuPassword(String stuPassword) {
        this.stuPassword = stuPassword == null ? null : stuPassword.trim();
    }

    public String getStuSex() {
        return stuSex;
    }

    public void setStuSex(String stuSex) {
        this.stuSex = stuSex == null ? null : stuSex.trim();
    }

    public String getStuNum() {
        return stuNum;
    }

    public void setStuNum(String stuNum) {
        this.stuNum = stuNum == null ? null : stuNum.trim();
    }

    public String getStuXxx2() {
        return stuXxx2;
    }

    public void setStuXxx2(String stuXxx2) {
        this.stuXxx2 = stuXxx2 == null ? null : stuXxx2.trim();
    }
}