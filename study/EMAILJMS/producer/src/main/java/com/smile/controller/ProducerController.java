package com.smile.controller;

import com.alibaba.fastjson.JSON;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Date;

/**
 * @author ：smile丶
 * @date ：Created in 19-3-14 下午5:39
 * @description：${description}
 * @modified By：
 * @version: $version$
 */

@RestController
@RequestMapping("/producer")
public class ProducerController {

    @Autowired
    JmsMessagingTemplate jmsMessagingTemplate;

    @RequestMapping("/queue")
    public String cusMessage(){
        //定义目的地
        ActiveMQQueue destination = new ActiveMQQueue("controller-mq");
        //定义消息
        String message = "消息:现在的时间是  "+ new Date().getTime();
        jmsMessagingTemplate.convertAndSend(destination,message);
        System.out.println("消息发送成功...");
        return  JSON.toJSONString("success", true);
    }
}
