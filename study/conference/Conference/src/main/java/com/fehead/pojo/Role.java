package com.fehead.pojo;

/**
 * @Classname Role
 * @Description 角色类
 * @Date 2019/1/20 0020 下午 20:20
 * @Created by CR
 */
public class
Role {
    int confId;
    String roleName;
    String roleDesc;
    int roleId;

    @Override
    public String toString() {
        return "Role{" +
                "confId=" + confId +
                ", roleName='" + roleName + '\'' +
                ", roleDesc='" + roleDesc + '\'' +
                ", roleId=" + roleId +
                '}';
    }

    public int getConfId() {
        return confId;
    }

    public void setConfId(int confId) {
        this.confId = confId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public Role(int confId, String roleName, String roleDesc, int roleId) {

        this.confId = confId;
        this.roleName = roleName;
        this.roleDesc = roleDesc;
        this.roleId = roleId;
    }

    public Role() {

    }
}
