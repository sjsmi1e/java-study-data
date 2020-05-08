package com.fehead.pojo;

import java.util.List;

/**
 * @Classname Conference
 * @Description 会议实体类
 * @Date 2019/1/20 0020 下午 19:41
 * @Created by CR
 */
public class Conference {
    private int confId;
    private UserInfo userId;
    private String confName;
    private String confStarttime;
    private String confEndtime;
    private String confLocation;
    private String confDesc;
    private String confImg;
    private double confFee;
    private String confNotice;
    private String confOrg;
    private String confDeadline;
    private List<Role> roles;
    public Conference() {
    }

    public Conference(int confId, UserInfo userId, String confName,
                      String confStarttime, String confEndtime, String confLocation,
                      String confDesc, String confImg, double confFee, String confNotice,
                      String confOrg, String confDeadline) {
        this.confId = confId;
        this.userId = userId;
        this.confName = confName;
        this.confStarttime = confStarttime;
        this.confEndtime = confEndtime;
        this.confLocation = confLocation;
        this.confDesc = confDesc;
        this.confImg = confImg;
        this.confFee = confFee;
        this.confNotice = confNotice;
        this.confOrg = confOrg;
        this.confDeadline = confDeadline;
    }

    @Override
    public String toString() {
        return "Conference{" +
                "confId=" + confId +
                ", userId=" + userId +
                ", confName='" + confName + '\'' +
                ", confStarttime='" + confStarttime + '\'' +
                ", confEndtime='" + confEndtime + '\'' +
                ", confLocation='" + confLocation + '\'' +
                ", confDesc='" + confDesc + '\'' +
                ", confImg='" + confImg + '\'' +
                ", confFee=" + confFee +
                ", confNotice='" + confNotice + '\'' +
                ", confOrg='" + confOrg + '\'' +
                ", confDeadline='" + confDeadline + '\'' +
                '}';
    }

    public int getConfId() {
        return confId;
    }

    public void setConfId(int confId) {
        this.confId = confId;
    }

    public UserInfo getUserId() {
        return userId;
    }

    public void setUserId(UserInfo userId) {
        this.userId = userId;
    }

    public String getConfName() {
        return confName;
    }

    public void setConfName(String confName) {
        this.confName = confName;
    }

    public String getConfStarttime() {
        return confStarttime;
    }

    public void setConfStarttime(String confStarttime) {
        this.confStarttime = confStarttime;
    }

    public String getConfEndtime() {
        return confEndtime;
    }

    public void setConfEndtime(String confEndtime) {
        this.confEndtime = confEndtime;
    }

    public String getConfLocation() {
        return confLocation;
    }

    public void setConfLocation(String confLocation) {
        this.confLocation = confLocation;
    }

    public String getConfDesc() {
        return confDesc;
    }

    public void setConfDesc(String confDesc) {
        this.confDesc = confDesc;
    }

    public String getConfImg() {
        return confImg;
    }

    public void setConfImg(String confImg) {
        this.confImg = confImg;
    }

    public double getConfFee() {
        return confFee;
    }

    public void setConfFee(double confFee) {
        this.confFee = confFee;
    }

    public String getConfNotice() {
        return confNotice;
    }

    public void setConfNotice(String confNotice) {
        this.confNotice = confNotice;
    }

    public String getConfOrg() {
        return confOrg;
    }

    public void setConfOrg(String confOrg) {
        this.confOrg = confOrg;
    }

    public String getConfDeadline() {
        return confDeadline;
    }

    public void setConfDeadline(String confDeadline) {
        this.confDeadline = confDeadline;
    }
}
