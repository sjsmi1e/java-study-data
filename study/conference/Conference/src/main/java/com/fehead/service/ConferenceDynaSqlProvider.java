package com.fehead.service;

import com.fehead.pojo.Conference;
import org.apache.ibatis.jdbc.SQL;

public class ConferenceDynaSqlProvider {
    public String updateConference(final Conference conference){
        return new SQL(){
            {
                UPDATE("conference_info");
                if(conference.getConfStarttime() != null){
                    SET("conf_starttime= #{confStarttime}");
                }
                if(conference.getConfDeadline() != null){
                    SET("conf_deadline = #{confDeadline}");
                }
                if(conference.getUserId().getUserId() != 0){
                    SET("user_id = #{userId.userId}");
                }
                if(conference.getConfFee()!= 0){
                    SET("conf_fee= #{confFee}");
                }
                if(conference.getConfDesc() != null){
                    SET("conf_desc= #{confDesc}");
                }
                if(conference.getConfName() != null){
                    SET("conf_name= #{confName}");
                }
                if(conference.getConfLocation() != null){
                    SET("conf_location= #{confLocation}");
                }
                if(conference.getConfImg() != null){
                    SET("conf_img= #{confImg}");
                }
                if(conference.getConfNotice() != null){
                    SET("conf_notice= #{confNotice}");
                }
                if(conference.getConfOrg() != null){
                    SET("conf_org= #{confOrg}");
                }
                if(conference.getConfEndtime() != null){
                    SET("conf_endtime= #{confEndtime}");
                }
                WHERE("conf_id = #{confId}");
            }

        }.toString();
    }
}
