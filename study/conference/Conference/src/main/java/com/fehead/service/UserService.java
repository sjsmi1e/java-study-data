package com.fehead.service;

import com.fehead.mapper.ConferenceRoleUserMapper;
import com.fehead.mapper.UserMapper;
import com.fehead.mapper.impl.MessageMapperImpl;
import com.fehead.pojo.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Classname UserService
 * @Description TODO
 * @Date 2019/1/21 0021 上午 10:46
 * @Created by Administrator
 */
@Service
public class UserService {
    @Autowired
    public UserMapper userMapper;
    @Autowired
    public ConferenceRoleUserMapper conferenceRoleUserMapper;

    public MessageMapperImpl messageMapper;

    public UserInfo selectUserById(int userId){
        return userMapper.selectUserById(userId);
    }

    /**
     * 更改信息
     */
    public void updateUser(UserInfo user){
        userMapper.updateUser(user);
    }
    /**
     * 新增用户
     */
    public void addUser(UserInfo user){
        userMapper.addUser(user);
    }

    public int getLastUser_id(){
        return userMapper.getLastUser_id();
    }

    public List<Integer> getUserIdByConfId(int conf_id){
        return conferenceRoleUserMapper.getUserIdByConfId(conf_id);
    }

    public List<UserInfo> selectUserIdTelByConfId(int conf_id){
        return conferenceRoleUserMapper.selectUserIdTelByConfId(conf_id);
    }

    //redis存入请求信息
    public synchronized void addAskConfMessage(String confId, String userId, String roleName, String desc){
        messageMapper.addAskConfMessage(confId,userId,roleName,desc);
    }



    /**
     * 根据会议id获取请求参加会议信息
     * @param confId
     * @return
     */
    public List<Map<String, String>> getAskConfMessageByConfId(String confId){
        return messageMapper.getAskConfMessageByConfId(confId);
    }

    /**
     * 通过userid,roleid=1或者roleid=2得到所有会议id
     * @param userId
     * @return
     */
    public List<Integer> getAllConfIdByUserId_RoleId(int userId){
        return userMapper.getAllConfIdByUserId_RoleId(userId);
    }


}
