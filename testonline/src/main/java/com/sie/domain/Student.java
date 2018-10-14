package com.sie.domain;

import java.util.List;

public class Student {
    @Override
    public String toString() {
        return "Student{" +
                "studentAnswer=" + studentAnswer +
                ", stuName='" + stuName + '\'' +
                ", stuNum='" + stuNum + '\'' +
                '}';
    }
    private List<StudentAnswer> studentAnswer;
    public List<StudentAnswer> getStudentAnswer() {
        return studentAnswer;
    }
    public void setStudentAnswer(List<StudentAnswer> studentAnswer) {
        this.studentAnswer = studentAnswer;
    }

    private int stuId;

    private String stuName;

    private String stuPassword;

    private String stuSex;

    private String stuNum;

    private int stuClass;

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

    public void setStuId(int stuId) {
        this.stuId = stuId;
    }

    public int getStuClass() {
        return stuClass;
    }

    public void setStuClass(int stuClass) {
        this.stuClass = stuClass;
    }
}