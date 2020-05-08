package com.fehead.service;

import com.fehead.mapper.ConferenceMapper;
import com.fehead.pojo.Conference;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Classname ConferenceService
 * @Description TODO
 * @Date 2019/1/21 18:02
 * @Created by smile丶
 */
@Service
public class ConferenceService {
    @Autowired
    ConferenceMapper conferenceMapper;

    public List<Conference> getAllConference(){
        return conferenceMapper.getAllConference();
    }

    public Conference selectConferenceByName(String conName){
        return conferenceMapper.selectConferenceByName(conName);
    }

//    public Conference addConference(Conference conference){
//        return conferenceMapper.addConference(conference);
//    }

    public Conference getConferenceById(int id){
        return conferenceMapper.getConferenceById(id);
    }

    public List<Conference> getConferenceByUserId(int id){
        return conferenceMapper.getConferenceByUserId(id);
    }

//    public Conference addConference(Conference conference){
//        return conferenceMapper.addConference(conference);
//    }


    public void addConference(Conference conference){
        conferenceMapper.addConference(conference);
    }

    public int getLastConf_id(){
        return conferenceMapper.getLastConf_id();
    }

    public void addConferenceRoleInfo(int conf_role_id,int conf_id, int role_id, String role_name,
                                      String role_desc){
        conferenceMapper.addConferenceRoleInfo(conf_role_id,conf_id,role_id,role_name,role_desc);
    }

    public void addConferenceRoleUserInfo(int conf_role_user_id,int user_id, int conf_id, int role_id){
        conferenceMapper.addConferenceRoleUserInfo(conf_role_user_id,user_id,conf_id,role_id);
    }

    public List<Integer> getAllRoleTypeByConfid(@Param("conf_id")int conf_id){
        return conferenceMapper.getAllRoleTypeByConfid(conf_id);
    }

    public int getMasterIdByconfId(int conf_id){
        return conferenceMapper.getMasterIdByconfId(conf_id);
    }

    public void updateConference(Conference conference){
        conferenceMapper.updateConference(conference);
    }

    public List<Integer> getRoleIdByconfId_UserId(int conf_id,int user_id){
        return conferenceMapper.getRoleIdByconfId_UserId(conf_id,user_id);
    }

    public List<Integer> getAllRightConferenceIdByUserId(int user_id){
        return conferenceMapper.getAllRightConferenceIdByUserId(user_id);
    }

}
