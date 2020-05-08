package com.fehead.pojo;

public class ProjectInfo {

    private int projectId;
    private int confId;
    private UserInfo userId;
    private int  fileId;
    private String projectName;
    private double projectAvg;
    private double projectSum;
    private String projectDesc;


    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
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

    public int getFileId() {
        return fileId;
    }

    public void setFileId(int fileId) {
        this.fileId = fileId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public double getProjectAvg() {
        return projectAvg;
    }

    public void setProjectAvg(double projectAvg) {
        this.projectAvg = projectAvg;
    }

    public double getProjectSum() {
        return projectSum;
    }

    public void setProjectSum(double projectSum) {
        this.projectSum = projectSum;
    }

    public String getProjectDesc() {
        return projectDesc;
    }

    public void setProjectDesc(String projectDesc) {
        this.projectDesc = projectDesc;
    }


    public ProjectInfo() {
    }

    public ProjectInfo(int projectId, int confId, UserInfo userId, int fileId, String projectName, double projectAvg, double projectSum, String projectDesc) {
        this.projectId = projectId;
        this.confId = confId;
        this.userId = userId;
        this.fileId = fileId;
        this.projectName = projectName;
        this.projectAvg = projectAvg;
        this.projectSum = projectSum;
        this.projectDesc = projectDesc;
    }

    @Override
    public String toString() {
        return "ProjectInfo{" +
                "projectId=" + projectId +
                ", confId=" + confId +
                ", userId=" + userId +
                ", fileId=" + fileId +
                ", projectName='" + projectName + '\'' +
                ", projectAvg=" + projectAvg +
                ", projectSum=" + projectSum +
                ", projectDesc='" + projectDesc + '\'' +
                '}';
    }
}
