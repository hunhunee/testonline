package com.sie.domain;

public class Test {
    private Integer testId;

    private String testContent;

    private String testAns1;

    private String testAns2;

    private String testAns3;

    private String testAns4;

    private String rightans1;

    private String rightans2;

    private String rightans3;

    private String rightans4;

    private String testCourse;

    private String testType;

    private Integer testStatus;

    private String testXxx2;

    public Test() {
    }

    public Test(Integer testId, String testContent, String testAns1, String testAns2, String testAns3, String testAns4, String rightans1, String rightans2, String rightans3, String rightans4, String testCourse, String testType, Integer testStatus, String testXxx2) {
        this.testId = testId;
        this.testContent = testContent;
        this.testAns1 = testAns1;
        this.testAns2 = testAns2;
        this.testAns3 = testAns3;
        this.testAns4 = testAns4;
        this.rightans1 = rightans1;
        this.rightans2 = rightans2;
        this.rightans3 = rightans3;
        this.rightans4 = rightans4;
        this.testCourse = testCourse;
        this.testType = testType;
        this.testStatus = testStatus;

        this.testXxx2 = testXxx2;
    }

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

    public String getRightans1() {
        return rightans1;
    }

    public void setRightans1(String rightans1) {
        this.rightans1 = rightans1 == null ? null : rightans1.trim();
    }

    public String getRightans2() {
        return rightans2;
    }

    public void setRightans2(String rightans2) {
        this.rightans2 = rightans2 == null ? null : rightans2.trim();
    }

    public String getRightans3() {
        return rightans3;
    }

    public void setRightans3(String rightans3) {
        this.rightans3 = rightans3 == null ? null : rightans3.trim();
    }

    public String getRightans4() {
        return rightans4;
    }

    public void setRightans4(String rightans4) {
        this.rightans4 = rightans4 == null ? null : rightans4.trim();
    }

    public String getTestCourse() {
        return testCourse;
    }

    public void setTestCourse(String testCourse) {
        this.testCourse = testCourse == null ? null : testCourse.trim();
    }

    public String getTestType() {
        return testType;
    }

    public void setTestType(String testType) {
        this.testType = testType == null ? null : testType.trim();
    }

    public Integer getTestStatus() {
        return testStatus;
    }

    public void setTestStatus(Integer testStatus) {
        this.testStatus = testStatus;
    }

    public String getTestXxx2() {
        return testXxx2;
    }

    public void setTestXxx2(String testXxx2) {
        this.testXxx2 = testXxx2 == null ? null : testXxx2.trim();
    }
}