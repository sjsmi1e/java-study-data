package com.fehead.pojo;

/**
 * @Classname UserInfo
 * @Description 用户实体类
 * @Date 2019/1/20 0020 下午 19:44
 * @Created by CR
 */
public class UserInfo {
    private int userId;
    private String userName;
    private String passWord;
    private String userTel;
    private String userSex;
    private int userAge;
    private String userDesc;
    private String userImg;


    public UserInfo() {
    }

    public UserInfo(String userName, String passWord, String userTel,
                    String userSex, int userAge, String userDesc, String userImg) {
        this.userName = userName;
        this.passWord = passWord;
        this.userTel = userTel;
        this.userSex = userSex;
        this.userAge = userAge;
        this.userDesc = userDesc;
        this.userImg = userImg;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", userTel='" + userTel + '\'' +
                ", userSex='" + userSex + '\'' +
                ", userAge=" + userAge +
                ", userDesc='" + userDesc + '\'' +
                ", userImg='" + userImg + '\'' +
                '}';
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getUserTel() {
        return userTel;
    }

    public void setUserTel(String userTel) {
        this.userTel = userTel;
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    public int getUserAge() {
        return userAge;
    }

    public void setUserAge(int userAge) {
        this.userAge = userAge;
    }

    public String getUserDesc() {
        return userDesc;
    }

    public void setUserDesc(String userDesc) {
        this.userDesc = userDesc;
    }

    public String getUserImg() {
        return userImg;
    }

    public void setUserImg(String userImg) {
        this.userImg = userImg;
    }
}
