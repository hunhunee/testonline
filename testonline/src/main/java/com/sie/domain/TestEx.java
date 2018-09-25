package com.sie.domain;

import com.alibaba.fastjson.JSONArray;

import java.util.Arrays;

public class TestEx extends Test{
    public TestEx(Integer testId, String testContent, String testAns1, String testAns2, String testAns3, String testAns4, String rightans1, String rightans2, String rightans3, String rightans4, String testCourse, String testType, Integer testStatus, String testXxx2) {
        super(testId, testContent, testAns1, testAns2, testAns3, testAns4, rightans1, rightans2, rightans3, rightans4, testCourse, testType, testStatus, testXxx2);
    }

    public TestEx(Integer testId, String testContent, String testAns1, String testAns2, String testAns3, String testAns4, String rightans1, String rightans2, String rightans3, String rightans4, String testCourse, String testType, Integer testStatus, String testXxx2, String testAnswer, String[] testAnswerArray, int testRandomNum) {
        super(testId,testContent,testAns1,testAns2,testAns3,testAns4,rightans1,rightans2,rightans3,rightans4,testCourse,testType,testStatus,testXxx2);
        this.testAnswer = testAnswer;
        this.testAnswerArray = testAnswerArray;
        this.testRandomNum = testRandomNum;
    }

    public TestEx() {
        super();
    }

    private String testAnswer;
    private String[] testAnswerArray;

    public String[] getTestAnswerArray() {
        return testAnswerArray;
    }

    public void setTestAnswerArray(String[] testAnswerArray) {
        this.testAnswerArray = testAnswerArray;
    }

    public String getTestAnswer() {
        return testAnswer;
    }

    public void setTestAnswer(String testAnswer) {
        this.testAnswer = testAnswer;
    }


    private int testRandomNum;

    public int getTestRandomNum() {
        return testRandomNum;
    }

    public void setTestRandomNum(int testRandomNum) {
        this.testRandomNum = testRandomNum;
    }
}