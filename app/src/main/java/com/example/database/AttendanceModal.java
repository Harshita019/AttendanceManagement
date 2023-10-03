package com.example.database;

public class AttendanceModal {


    private String loginDate;
    private String loginTime;
    private String loginRemark;

    public AttendanceModal(String loginDate, String loginTime, String loginRemark) {
        this.loginDate = loginDate;
        this.loginTime = loginTime;
        this.loginRemark = loginRemark;
    }



    public String getLoginDate() {
        return loginDate;
    }

    public void setLoginDate(String loginDate) {
        this.loginDate = loginDate;
    }

    public String getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(String loginTime) {
        this.loginTime = loginTime;
    }

    public String getLoginRemark() {
        return loginRemark;
    }

    public void setLoginRemark(String loginRemark) {
        this.loginRemark = loginRemark;
    }
}
