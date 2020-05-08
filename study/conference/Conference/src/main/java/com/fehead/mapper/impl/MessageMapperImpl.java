package com.fehead.mapper.impl;

import com.alibaba.druid.util.StringUtils;
import com.fehead.mapper.MessageMapper;
import com.fehead.util.RedisConfig;
import redis.clients.jedis.Jedis;

import java.util.*;

/**
 * 参加会议的消息提醒用redis的Hash存储
 * 存储格式：
 *  key_name：ask_conf_message+messageId
 *      confId：
 *          val1
 *      userId：
 *          val2
 *      roleName：
 *          val3
 *      desc：
 *          val4
 * @author lmwis on 2019-01-28 18:55
 */
public class MessageMapperImpl implements MessageMapper {
    private static Jedis jedis = new Jedis(RedisConfig.host);



    /**
     * 将用户请求参加会议的信息存入redis中
     * @param confId
     * @param userId
     * @param roleName
     * @param desc
     */
    @Override
    public synchronized void addAskConfMessage(String confId, String userId, String roleName, String desc) {
        jedis.select(1);
        Map<String,String> hash = new HashMap<String,String>();
        Set<String> set = jedis.keys("ask_conf_message?");
        Iterator<String> it = set.iterator();
        while(it.hasNext()){
            String name = it.next();
            Map<String,String> data = jedis.hgetAll(name);
            if(StringUtils.equals(data.get("confId"),confId)
                    &&StringUtils.equals(data.get("userId"),userId) ){  //重复数据不写入redis
                return;
            }
        }
        hash.put("confId",confId);
        hash.put("userId",userId);
        hash.put("roleName",roleName);
        hash.put("desc",desc);

        int count = jedis.keys("ask_conf_message?").size();
        count++;
        jedis.hmset("ask_conf_message"+count,hash);
    }


    /**
     * 根据会议id获取请求参加会议信息
     * @param confId
     * @return
     */
    @Override
    public List<Map<String, String>> getAskConfMessageByConfId(String confId) {
        if(StringUtils.isEmpty(confId)){
            return null;
        }
        List list = new ArrayList<Map<String, String>>();
        Set<String> set = jedis.keys("ask_conf_message?");
        Iterator<String> it = set.iterator();
        while(it.hasNext()){
            String name = it.next();
            Map<String,String> hash = jedis.hgetAll(name);
            if(hash.size()==0){
                continue;
            }
            if(StringUtils.isEmpty(hash.get("confId"))){
               continue;
            }
            if(StringUtils.equals(hash.get("confId"),confId)){
                list.add(hash);
            }
        }
        return list;
    }
}
