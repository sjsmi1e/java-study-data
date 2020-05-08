package com.smile.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author smi1e
 * @description
 * @Date 2020/4/23 13:47
 */
@RestController
public class OrderController {

    public static final String INVOME_URL = "http://cloud-provider-payment";

    @Resource
    RestTemplate restTemplate;

    @GetMapping("/consumer/payment/zk")
    public String payment() {
        String result = restTemplate.getForObject(INVOME_URL + "/payment/zk", String.class);
        return result;
    }

}
