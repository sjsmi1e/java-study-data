package com.fehead.mapper;

import com.fehead.pojo.Conference;
import com.fehead.service.ConferenceDynaSqlProvider;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Conference数据库映射类
 * @author lmwis on create 2019-01-19
 */
@Repository
public interface ConferenceMapper {

    @Select("select * from conference_info")
    @Results({
            @Result(id = true, column = "conf_id", property = "confId"),
            @Result(column = "user_id", property = "userId",one = @One(select="com.fehead.mapper.UserMapper.selectUserById")),
            @Result(column = "conf_name", property = "confName"),
            @Result(column = "conf_starttime", property = "confStarttime"),
            @Result(column = "conf_endtime", property = "confEndtime"),
            @Result(column = "conf_location", property = "confLocation"),
            @Result(column = "conf_desc", property = "confDesc"),
            @Result(column = "conf_img",property = "confImg"),
            @Result(column = "conf_fee",property = "confFee"),
            @Result(column = "conf_notice",property = "confNotice"),
            @Result(column = "conf_org",property = "confOrg"),
            @Result(column = "conf_deadline",property = "confDeadline")
    })
    public List<Conference> getAllConference();


    @Select("select * from conference_info where conf_id=#{id}" )
    @Results({
            @Result(id = true, column = "conf_id", property = "confId"),
            @Result(column = "user_id", property = "userId",one = @One(select="com.fehead.mapper.UserMapper.selectUserById")),
            @Result(column = "conf_name", property = "confName"),
            @Result(column = "conf_starttime", property = "confStarttime"),
            @Result(column = "conf_endtime", property = "confEndtime"),
            @Result(column = "conf_location", property = "confLocation"),
            @Result(column = "conf_desc", property = "confDesc"),
            @Result(column = "conf_img",property = "confImg"),
            @Result(column = "conf_fee",property = "confFee"),
            @Result(column = "conf_notice",property = "confNotice"),
            @Result(column = "conf_org",property = "confOrg"),
            @Result(column = "conf_deadline",property = "confDeadline")
    })
    public Conference getConferenceById(@Param("id") int id);


    @Select("select * from conference_info where conf_name=#{name}" )
    @Results({
            @Result(id = true, column = "conf_id", property = "confId"),
            @Result(column = "user_id", property = "userId",one = @One(select="com.fehead.mapper.UserMapper.selectUserById")),
            @Result(column = "conf_name", property = "confName"),
            @Result(column = "conf_starttime", property = "confStarttime"),
            @Result(column = "conf_endtime", property = "confEndtime"),
            @Result(column = "conf_location", property = "confLocation"),
            @Result(column = "conf_desc", property = "confDesc"),
            @Result(column = "conf_img",property = "confImg"),
            @Result(column = "conf_fee",property = "confFee"),
            @Result(column = "conf_notice",property = "confNotice"),
            @Result(column = "conf_org",property = "confOrg"),
            @Result(column = "conf_deadline",property = "confDeadline")
    })
    public Conference selectConferenceByName(@Param("name") String name);


    /**
     * userid查询会议
     * @param id
     * @return
     */

    @Select("select * from conference_info where conf_id in" +
            "(select conf_id from conference_role_user_info " +
            "where user_id = #{id})")
    @Results({
            @Result(id = true, column = "conf_id", property = "confId"),
            @Result(column = "user_id", property = "userId",one = @One(select="com.fehead.mapper.UserMapper.selectUserById")),
            @Result(column = "conf_name", property = "confName"),
            @Result(column = "conf_starttime", property = "confStarttime"),
            @Result(column = "conf_endtime", property = "confEndtime"),
            @Result(column = "conf_location", property = "confLocation"),
            @Result(column = "conf_desc", property = "confDesc"),
            @Result(column = "conf_img", property = "confImg"),
            @Result(column = "conf_fee", property = "confFee"),
            @Result(column = "conf_notice", property = "confNotice"),
            @Result(column = "conf_org", property = "confOrg"),
            @Result(column = "conf_deadline", property = "confDeadline")
    })
    public List<Conference> getConferenceByUserId(@Param("id") int id);

    /**
     * 创建会议
     * @param conference
     * @return
     */
@Insert("insert into conference_info(user_id,conf_name,conf_starttime," +
        "conf_endtime,conf_location,conf_desc,conf_img,conf_fee,conf_notice,conf_org,conf_deadline)" +
        " values(#{conference.userId.userId},#{conference.confName},#{conference.confStarttime},#{conference.confEndtime}," +
        "#{conference.confLocation},#{conference.confDesc},#{conference.confImg},#{conference.confFee},#{conference.confNotice},#{conference.confOrg},#{conference.confDeadline})")
@Options(useGeneratedKeys=true, keyProperty="conference.confId",keyColumn = "conf_id")
public void addConference(@Param("conference") Conference conference);

    /**
     * 增加conference_role_info表信息
     * @param conf_id
     * @param role_id
     * @param role_name
     * @param role_desc
     */
    @Insert("insert into conference_role_info(conf_id,role_id,role_name,role_desc)values (#{conf_id},#{role_id},#{role_name},#{role_desc})")
@Options(useGeneratedKeys = true,keyProperty = "conf_role_id",keyColumn = "conf_role_id")
public void addConferenceRoleInfo(@Param("conf_role_id") int conf_role_id, @Param("conf_id") int conf_id, @Param("role_id") int role_id, @Param("role_name") String role_name,
                                  @Param("role_desc") String role_desc);


    /**
     * 增加conference_role_user_info表信息
     */
    @Insert("insert into conference_role_user_info(user_id,conf_id,role_id)"+
            "values(#{user_id},#{conf_id},#{role_id})")
    @Options(useGeneratedKeys = true,keyProperty = "conf_role_user_id",keyColumn = "conf_role_user_id")
    public void addConferenceRoleUserInfo(@Param("conf_role_user_id") int conf_role_user_id, @Param("user_id") int user_id,
                                          @Param("conf_id") int conf_id, @Param("role_id") int role_id);

    /**
     * 得到最大的conf_id
     * @return
     */
    @Select("select max(conf_id) from conference_info")
public int getLastConf_id();
//
//    /**
//     * 更新会议信息
//     */
//    @Update("update  conference_info set user_id=conference.userId,conf_name=conference.confName," +
//            "conf_starttime=conference.confStarttime,conf_endtime=confernce.confEndtime,conf_location= conference.confLocation,"+
//            "conf_desc = conference.confDesc,conf_img=conference.confImg,conf_fee=conference.confFee,conf_notice=conference.confNotice)" +
//            "conf_org=conference.conOrg,conf_deadline=conference.confDeadline  where conf_id = conference.confId")
//    public void updateUser(@Param("conference") Conference conference);

    /**
     * 得到会议已经存在的所有角色id
     */
    @Select("select role_id from conference_role_info where conf_id=#{conf_id}")
    public List<Integer> getAllRoleTypeByConfid(@Param("conf_id") int conf_id);

    /**
     * 通过会议ID得到主持人ID
     */
    @Select("select user_id from conference_info where conf_id=#{conf_id}")
    public int getMasterIdByconfId(@Param("conf_id") int conf_id);


    /**
     * 更新会议信息
     */
    @UpdateProvider(type= ConferenceDynaSqlProvider.class,method="updateConference")
    public void updateConference(Conference conference);

    /**
     * 通过会议id和用户id查询role_id
     * @param conf_id
     * @param user_id
     * @return
     */
    @Select("select role_id from conference_role_user_info where conf_id = #{conf_id} and user_id = #{user_id}")
    public List<Integer> getRoleIdByconfId_UserId(@Param("conf_id") int conf_id, @Param("user_id") int user_id);

    /**
     * 通过会议id和角色id查询用户id
     * @param conf_id
     * @param role_id
     * @return
     */
    @Select("select user_id from conference_role_user_info where conf_id = #{conf_id} and role_id = #{role_id}")
    public List<Integer> getUserIdByconfId_RoleId(@Param("conf_id") int conf_id, @Param("role_id") int role_id);


    /**
     * 获取用户拥有发送通知权限的会议
     * @param user_id
     *
     */
    @Select(
            "select conf_id from conference_role_user_info  where user_id = #{user_id} and (role_id = 1 or role_id = 2)"
    )
    public List<Integer> getAllRightConferenceIdByUserId(@Param("user_id") int user_id);
}
