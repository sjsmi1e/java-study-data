package com.smile.services;

import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

/**
 * @author ：smile丶
 * @date ：Created in 19-3-14 下午8:13
 * @description：${description}
 * @modified By：
 * @version: $version$
 */

@EnableJms
@Service
public class CustomerService {


    @JmsListener(destination = "controller-mq")
    public String getMessageQueue(String msg){
        System.out.println(msg);
        return msg;
    }
}
