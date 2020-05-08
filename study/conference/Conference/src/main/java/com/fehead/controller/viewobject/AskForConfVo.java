package com.fehead.controller.viewobject;

public class AskForConfVo {

    //String.valueOf(conf_id),String.valueOf(user_id), RoleType.getNameByIndex(role_id),desc

    private int conf_id;
    private int user_id;
    private String roli_name;
    private String desc;

    @Override
    public String toString() {
        return "AskForConfVo{" +
                "conf_id=" + conf_id +
                ", user_id=" + user_id +
                ", roli_name='" + roli_name + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }

    public int getConf_id() {
        return conf_id;
    }

    public void setConf_id(int conf_id) {
        this.conf_id = conf_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getRoli_name() {
        return roli_name;
    }

    public void setRoli_name(String roli_name) {
        this.roli_name = roli_name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public AskForConfVo(int conf_id, int user_id, String roli_name, String desc) {
        this.conf_id = conf_id;
        this.user_id = user_id;
        this.roli_name = roli_name;
        this.desc = desc;
    }

    public AskForConfVo() {

    }
}
