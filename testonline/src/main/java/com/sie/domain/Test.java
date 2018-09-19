package com.sie.domain;

public class Test {
    private Integer testId;

    private String testContent;

    private String testAns1;

    private String testAns2;

    private String testAns3;

    private String testAns4;

    private String rightans;

    private String testCourse;

<<<<<<< HEAD
    private Integer pub;
=======
    private String testType;

    private Integer testStatus;
>>>>>>> zjBranch

    private String testXxx1;

    private String testXxx2;

    public Integer getTestId() {
        return testId;
    }

    public void setTestId(Integer testId) {
        this.testId = testId;
    }

    public String getTestContent() {
        return testContent;
    }

    public void setTestContent(String testContent) {
        this.testContent = testContent == null ? null : testContent.trim();
    }

    public String getTestAns1() {
        return testAns1;
    }

    public void setTestAns1(String testAns1) {
        this.testAns1 = testAns1 == null ? null : testAns1.trim();
    }

    public String getTestAns2() {
        return testAns2;
    }

    public void setTestAns2(String testAns2) {
        this.testAns2 = testAns2 == null ? null : testAns2.trim();
    }

    public String getTestAns3() {
        return testAns3;
    }

    public void setTestAns3(String testAns3) {
        this.testAns3 = testAns3 == null ? null : testAns3.trim();
    }

    public String getTestAns4() {
        return testAns4;
    }

    public void setTestAns4(String testAns4) {
        this.testAns4 = testAns4 == null ? null : testAns4.trim();
    }

    public String getRightans() {
        return rightans;
    }

    public void setRightans(String rightans) {
        this.rightans = rightans == null ? null : rightans.trim();
    }

    public String getTestCourse() {
        return testCourse;
    }

    public void setTestCourse(String testCourse) {
        this.testCourse = testCourse == null ? null : testCourse.trim();
    }

<<<<<<< HEAD
    public Integer getPub() {
        return pub;
=======
    public String getTestType() {
        return testType;
    }

    public void setTestType(String testType) {
        this.testType = testType == null ? null : testType.trim();
    }

    public Integer getTestStatus() {
        return testStatus;
>>>>>>> zjBranch
    }

    public void setTestStatus(Integer testStatus) {
        this.testStatus = testStatus;
    }

    public String getTestXxx1() {
        return testXxx1;
    }

    public void setTestXxx1(String testXxx1) {
        this.testXxx1 = testXxx1 == null ? null : testXxx1.trim();
    }

    public String getTestXxx2() {
        return testXxx2;
    }

    public void setTestXxx2(String testXxx2) {
        this.testXxx2 = testXxx2 == null ? null : testXxx2.trim();
    }
}