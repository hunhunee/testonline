package com.sie.domain;

public class StudentAnswer {
    private Integer stuAnsId;

    private Lesson lesson;

    private Class_ aClass;
    private String className;

    public Class_ getaClass() {
        return aClass;
    }

    public void setaClass(Class_ aClass) {
        this.aClass = aClass;
    }

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

    private Integer stuId;

    private String stuAnswerone;

    private String stuAnswertwo;

    private String stuAnswerthree;

    private String stuAnswerfour;

    private  String stuNum;
    private  String stuName;
    public String getStuNum() {
        return stuNum;
    }
    public void setStuNum(String stuNum) {
        this.stuNum = stuNum;
    }
    public String getStuName() {
        return stuName;
    }
    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    @Override
    public String toString() {
        return "StudentAnswer{" +
                "lesName='" + lesName + '\'' +
                ", totalscore=" + totalscore +
                ", stuClass='" + stuClass + '\'' +
                '}';
    }
//    private String stuNum;
//    public String getStuNum() {
//        return stuNum;
//    }
//    public void setStuNum(String stuNum) {
//        this.stuNum = stuNum;
//    }

    private String rightanswerone;

    private String rightanswertwo;

    private String rightanswerthree;

    private String rightanswerfour;

    private String lesName;

    private String onescore;

    private String twoscore;

    private String threescore;

    private String fourscore;

    private Double totalscore;

    public Double getTotalscore() {
        return totalscore;
    }

    public void setTotalscore(Double totalscore) {
        this.totalscore = totalscore;
    }

    private String stuClass;


    private String stuAnsXxx2;

    private String stuAnsXxx3;

    public Integer getStuAnsId() {
        return stuAnsId;
    }

    public void setStuAnsId(Integer stuAnsId) {
        this.stuAnsId = stuAnsId;
    }

    public Integer getStuId() {
        return stuId;
    }

    public void setStuId(Integer stuId) {
        this.stuId = stuId;
    }

    public String getStuAnswerone() {
        return stuAnswerone;
    }

    public void setStuAnswerone(String stuAnswerone) {
        this.stuAnswerone = stuAnswerone == null ? null : stuAnswerone.trim();
    }

    public String getStuAnswertwo() {
        return stuAnswertwo;
    }

    public void setStuAnswertwo(String stuAnswertwo) {
        this.stuAnswertwo = stuAnswertwo == null ? null : stuAnswertwo.trim();
    }

    public String getStuAnswerthree() {
        return stuAnswerthree;
    }

    public void setStuAnswerthree(String stuAnswerthree) {
        this.stuAnswerthree = stuAnswerthree == null ? null : stuAnswerthree.trim();
    }

    public String getStuAnswerfour() {
        return stuAnswerfour;
    }

    public void setStuAnswerfour(String stuAnswerfour) {
        this.stuAnswerfour = stuAnswerfour == null ? null : stuAnswerfour.trim();
    }

    public String getRightanswerone() {
        return rightanswerone;
    }

    public void setRightanswerone(String rightanswerone) {
        this.rightanswerone = rightanswerone == null ? null : rightanswerone.trim();
    }

    public String getRightanswertwo() {
        return rightanswertwo;
    }

    public void setRightanswertwo(String rightanswertwo) {
        this.rightanswertwo = rightanswertwo == null ? null : rightanswertwo.trim();
    }

    public String getRightanswerthree() {
        return rightanswerthree;
    }

    public void setRightanswerthree(String rightanswerthree) {
        this.rightanswerthree = rightanswerthree == null ? null : rightanswerthree.trim();
    }

    public String getRightanswerfour() {
        return rightanswerfour;
    }

    public void setRightanswerfour(String rightanswerfour) {
        this.rightanswerfour = rightanswerfour == null ? null : rightanswerfour.trim();
    }

    public String getLesName() {
        return lesName;
    }

    public void setLesName(String lesName) {
        this.lesName = lesName;
    }

    public String getOnescore() {
        return onescore;
    }

    public void setOnescore(String onescore) {
        this.onescore = onescore == null ? null : onescore.trim();
    }

    public String getTwoscore() {
        return twoscore;
    }

    public void setTwoscore(String twoscore) {
        this.twoscore = twoscore == null ? null : twoscore.trim();
    }

    public String getThreescore() {
        return threescore;
    }

    public void setThreescore(String threescore) {
        this.threescore = threescore == null ? null : threescore.trim();
    }

    public String getFourscore() {
        return fourscore;
    }

    public void setFourscore(String fourscore) {
        this.fourscore = fourscore == null ? null : fourscore.trim();
    }


    public String getStuClass() {
        return stuClass;
    }

    public void setStuClass(String stuClass) {
        this.stuClass = stuClass;
    }

    public String getStuAnsXxx2() {
        return stuAnsXxx2;
    }

    public void setStuAnsXxx2(String stuAnsXxx2) {
        this.stuAnsXxx2 = stuAnsXxx2 == null ? null : stuAnsXxx2.trim();
    }

    public String getStuAnsXxx3() {
        return stuAnsXxx3;
    }

    public void setStuAnsXxx3(String stuAnsXxx3) {
        this.stuAnsXxx3 = stuAnsXxx3 == null ? null : stuAnsXxx3.trim();
    }
}