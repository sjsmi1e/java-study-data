package com.fehead.pojo;

/**
 * @Classname FileInfo
 * @Description 文件实体类
 * @Date 2019/1/20 0020 下午 19:39
 * @Created by CR
 */
public class FileInfo {
    private int fileId;
    private int confId;
    private UserInfo userId;
    private String filePath;
    private String fileName;

    public FileInfo() {
    }

    public FileInfo(int fileId, int confId, UserInfo userId, String filePath, String fileName) {
        this.fileId = fileId;
        this.confId = confId;
        this.userId = userId;
        this.filePath = filePath;
        this.fileName = fileName;
    }

    public int getFileId() {
        return fileId;
    }

    public void setFileId(int fileId) {
        this.fileId = fileId;
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

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
