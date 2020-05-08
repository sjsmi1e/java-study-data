package com.fehead.pojo;

/**
 * @Classname RoleType
 * @Description 角色对应枚举
 * @Date 2019/1/20 0020 下午 20:23
 * @Created by CR
 */
public enum RoleType {
    MASTER("主持人",1,"主持人召开会议"),ORGANIZE("组织者",2,"协助主持人召开会议"),RATER("评委",3,"为参赛者评分"),PARTICIPANT("参赛者",4,"参加会议");
    private String type;
    private int index;
    private String desc;

    RoleType(String type, int index, String desc) {
        this.type = type;
        this.index = index;
        this.desc = desc;
    }



    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public static RoleType getRoleType(int index) {
        RoleType roleType = RoleType.MASTER;
        for (RoleType role : RoleType.values()) {
            if (role.index == index) {
                return role;
            }
        }
        return roleType;
    }

    public static String getDescByIndex(int index) {
        return getRoleType(index).desc;
    }

    public static String getNameByIndex(int index) {
        return getRoleType(index).type;
    }



    public static void main(String[] args) {
//        System.out.println(RoleType.MASTER.getIndex());
//        System.out.println(RoleType.MASTER.getDesc());
//        System.out.println(RoleType.MASTER.getType());
//        System.out.println(RoleType.MASTER.desc);
//        System.out.println(RoleType.MASTER.getIndex());
//        System.out.println(getRoleType(2).getType());
        System.out.println(getNameByIndex(3));

    }
}
