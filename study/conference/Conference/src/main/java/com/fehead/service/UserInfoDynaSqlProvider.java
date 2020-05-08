package com.fehead.service;

import com.fehead.pojo.UserInfo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;

/**
 * @Classname UserInfoDynaSqlProvider
 * @Description 获取动态SQL语句
 * @Date 2019/1/23 13:47
 * @Created by smile丶
 */
public class UserInfoDynaSqlProvider {
    public static String updateUserinfo(final UserInfo userInfo){
        System.out.println(" UserInfoDynaSqlProvider"+userInfo);
        return new SQL(){
            {
                UPDATE("user_info");
                if(userInfo.getUserName()!=null){
                    SET("user_name = #{userName}");
                }
                if(userInfo.getUserName()!=null){
                    SET("user_tel = #{userTel}");
                }
                if(userInfo.getUserName()!=null){
                    SET("user_sex= #{userSex}");
                }
                if(userInfo.getUserAge()!= 0){
                    SET("user_age= #{userAge}");
                }
                if(userInfo.getUserName()!=null){
                    SET("user_desc= #{userDesc}");
                }
                if(userInfo.getUserName()!=null){
                    SET("user_img= #{userImg}");
                }
                WHERE("user_id = #{userId}");
            }

        }.toString();
    }


}
