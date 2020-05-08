package com.fehead.controller.viewobject;

/**
 * @program: conference
 * @description: ${description}
 * @author: smile丶
 * @create: 2019-02-22 08:06
 **/
public class ConferenceVO {
    private int confId;
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

    public ConferenceVO() {
    }

    public ConferenceVO(int confId, String confName, String confStarttime, String confEndtime, String confLocation, String confDesc, String confImg, double confFee, String confNotice, String confOrg, String confDeadline) {
        this.confId = confId;
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

    public int getConfId() {
        return confId;
    }

    public void setConfId(int confId) {
        this.confId = confId;
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
