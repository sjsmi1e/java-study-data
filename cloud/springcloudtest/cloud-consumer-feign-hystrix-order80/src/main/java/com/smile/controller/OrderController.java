package com.smile.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.smile.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author smi1e
 * @description
 * @Date 2020/4/24 12:05
 */
@RestController
@Slf4j
public class OrderController {

    @Resource
    private OrderService orderService;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/order/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id) {
        String result = orderService.paymentInfo_OK(id);
        log.info("*******result:" + result);
        return result;
    }

    @GetMapping("/order/hystrix/timeout/{id}")
    public String paymentInfo_TimeOut(@PathVariable("id") Integer id) {
        String result = orderService.paymentInfo_TimeOut(id);
        log.info("*******result:" + result);
        return result;
    }


}
