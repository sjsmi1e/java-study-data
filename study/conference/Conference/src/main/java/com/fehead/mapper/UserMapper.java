package com.fehead.mapper;


import com.fehead.pojo.UserInfo;
import com.fehead.service.UserInfoDynaSqlProvider;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * User数据库映射类
 * @author lmwis on create 2019-01-19
 */
@Repository
public interface UserMapper {



	/**
	 *
	 * userid查询user信息
	 */
	public List<UserInfo> getUsers();
	@Select("select * from user_info where user_id=#{id}")
	@Results({
			@Result(id = true, column = "user_id", property = "userId"),
			@Result(column = "user_name", property = "userName"),
			@Result(column = "user_password",property = "passWord"),
			@Result(column = "user_tel", property = "userTel"),
			@Result(column = "user_sex", property = "userSex"),
			@Result(column = "user_age", property = "userAge"),
			@Result(column = "user_desc", property = "userDesc"),
			@Result(column = "user_img", property = "userImg")
	})
	public UserInfo selectUserById(@Param("id") int id);

//	/**
//	 * 用户信息补全
//	 */
//
//	@Update("update user_info set user_name=#{user.userName},user_password=#{user.userpassWord},user_tel=#{user.userTel," +
//			"user_sex=#{user.userSex},user_age=#{user.userAge},user_desc=#{user.userDesc},user_img=#{user.userImg} " +
//			"where user_id = #{user.userId")
//	public void updateUserById(@Param("user") UserInfo user);

	//用户增加函数
	@Insert("insert into user_info(user_name,user_password,user_tel," +
			"user_sex,user_age,user_desc,user_img)" +
			" values(#{user.userName},#{user.passWord},#{user.userTel}," +
			"#{user.userSex},#{user.userAge},#{user.userDesc},#{user.userImg})")
	@Options(useGeneratedKeys=true, keyProperty="user.userId",keyColumn = "user_id")
	public void addUser(@Param("user") UserInfo user);

	/**
	 * 得到最大id
	 * @return
	 */
	@Select("select max(user_id) from user_info")
	public int getLastUser_id();

	/**
	 * 更新信息
	 */
	@UpdateProvider(type=UserInfoDynaSqlProvider.class,method="updateUserinfo")
	public void updateUser(UserInfo userInfo);


	/**
	 * 通过userid,roleid=1或者roleid=2得到所有会议id
	 * @param userId
	 * @return
	 */
	@Select("select conf_id from conference_role_user_info" +
			" where user_id=#{userId} and (role_id=1 or role_id=2)")
	@Results({
			@Result(column = "conf_id",property = "confId")
	})
	public List<Integer> getAllConfIdByUserId_RoleId(@Param("userId") int userId);

}


