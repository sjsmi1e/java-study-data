package com.smile.controller;

import com.alibaba.fastjson.JSON;
import com.smile.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：smile丶
 * @date ：Created in 19-3-14 下午7:53
 * @description：${description}
 * @modified By：
 * @version: $version$
 */

@RestController
@RequestMapping("/customer")
public class CustomerController {

//    @Autowired
//    CustomerService customerService;
//    @RequestMapping("/getqueue")
//    public String getMessageQueue(){
//            String msg = customerService.getMessageQueue("11");
//            System.out.println("进入customercontroller");
//            System.out.println(msg);
//        return JSON.toJSONString(msg);
//    }
}
