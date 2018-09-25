package com.sie.domain;

public class Admin {
    private Integer admId;

    private String admName;

    private String admPassword;

    private String admNum;

    public Integer getAdmId() {
        return admId;
    }

    public void setAdmId(Integer admId) {
        this.admId = admId;
    }

    public String getAdmName() {
        return admName;
    }

    public void setAdmName(String admName) {
        this.admName = admName == null ? null : admName.trim();
    }

    public String getAdmPassword() {
        return admPassword;
    }

    public void setAdmPassword(String admPassword) {
        this.admPassword = admPassword == null ? null : admPassword.trim();
    }

    public String getAdmNum() {
        return admNum;
    }

    public void setAdmNum(String admNum) {
        this.admNum = admNum == null ? null : admNum.trim();
    }
}