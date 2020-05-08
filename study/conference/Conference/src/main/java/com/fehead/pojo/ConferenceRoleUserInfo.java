package com.fehead.pojo;

public class ConferenceRoleUserInfo {

    private int confRoleUserId;
    private int userId;
    private int confId;
    private int roleId;

    public ConferenceRoleUserInfo(int confRoleUserId, int userId, int confId, int roleId) {
        this.confRoleUserId = confRoleUserId;
        this.userId = userId;
        this.confId = confId;
        this.roleId = roleId;
    }

    public ConferenceRoleUserInfo() {
    }

    public int getConfRoleUserId() {
        return confRoleUserId;
    }

    public void setConfRoleUserId(int confRoleUserId) {
        this.confRoleUserId = confRoleUserId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getConfId() {
        return confId;
    }

    public void setConfId(int confId) {
        this.confId = confId;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    @Override
    public String toString() {
        return "ConferenceRoleUserInfo{" +
                "confRoleUserId=" + confRoleUserId +
                ", userId=" + userId +
                ", confId=" + confId +
                ", roleId=" + roleId +
                '}';
    }


}