package com.fehead.pojo;

/**
 * @Classname ConferenceUser
 * @Description TODO
 * @Date 2019/1/22 16:56
 * @Created by smile丶
 */
public class ConferenceUser {
    private Conference conference;
    private UserInfo userInfo;
    private Role role;

    public ConferenceUser() {
    }

    public ConferenceUser(Conference conference, UserInfo userInfo, Role role) {
        this.conference = conference;
        this.userInfo = userInfo;
        this.role = role;
    }

    public Conference getConference() {
        return conference;
    }

    public void setConference(Conference conference) {
        this.conference = conference;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
