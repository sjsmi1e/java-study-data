package com.fehead.mapper;

import com.fehead.pojo.ConferenceRoleUserInfo;
import com.fehead.pojo.UserInfo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/*
2019-2-22
 */
@Repository
public interface ConferenceRoleUserMapper {
    /*
    通过send_id，conf_id,message_type_id 找到receive_id,
     */

//    @Select("select distinct user_id" +
//            " from conference_role_user_info,message_rule_info" +
//            " where conf_id=#{confId} and conference_role_user_info.role_id=message_rule_info.receive_id and receive_id in(" +
//            " select distinct receive_id" +
//            " from message_rule_info,conference_role_user_info" +
//            " where message_type_id=#{index} and message_rule_info.send_id=conference_role_user_info.role_id and role_id in(" +
//            " select distinct role_id" +
//            " from conference_role_user_info" +
//            " where user_id=#{userId} and conf_id=#{confId})" +
//            ")")
//    @Results({
//            @Result(column="user_id", property="userId")
//    })
//    public List<Integer> getAllReceiveId(@Param("conf_id") int confId, @Param("index") int index, @Param("user_id") int userId);

    /**
     * 查找指定会议所有用户id
     */
    @Select("select user_id from conference_role_user_info" +
            " where conf_id=#{conf_id}")
    @Results({
            @Result(column = "user_id",property = "userId")
    })
    public List<Integer> getUserIdByConfId(@Param("conf_id") int conf_id);


    /**
     * 根据会议id 查询 用户id和电话号码
     * @param confId
     * @return
     */
    @Select("select user_id ,user_tel from user_info where user_id in(" +
            " select user_id from conference_role_user_info" +
            " where conf_id=#{confId})")
    @Results({
            @Result(column = "user_id",property = "userId"),
            @Result(column="user_tel",property = "userTel")
    })
    public List<UserInfo> selectUserIdTelByConfId(@Param("confId") int conf_id);

//
//    /**
//     *  用户申请成功加入会议
//     * @param confRoleUser
//     */
//    @Insert("insert into conference_role_user_info(user_id,conf_id,role_id)" +
//            "values(#{confRoleUser.userId},#{confRoleUser.confId}," +
//            "#{confRoleUser.roleId})")
//    @Options(useGeneratedKeys=true, keyProperty="confRoleUser.confRoleUserId",keyColumn = "conf_role_user_id")
//    public void addConfRoleUser(@Param("confRoleUser") ConferenceRoleUserInfo confRoleUser);

//    /**
//     *  删除指定会议中的用户
//     * @param userId
//     * @param confId
//     */
//    @Delete("delete from conference_role_user_info" +
//            " where user_id=#{userId} and conf_id=#{confId}")
//    public void deleteUserId(@Param("user_id") int userId, @Param("conf_id") int confId);
}
