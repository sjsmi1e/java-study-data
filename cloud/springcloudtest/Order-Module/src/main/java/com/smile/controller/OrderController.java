package com.smile.controller;

import com.smile.domain.Order;
import com.smile.entities.CommonResult;
import com.smile.servicce.impl.OrderServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author smi1e
 * @description
 * @Date 2020/5/1 14:48
 */
@RestController
@Slf4j
public class OrderController {

    @Resource
    OrderServiceImpl orderService;

    @GetMapping("/order/create")
    public CommonResult create(Order order) {
        log.info("" + order);
        orderService.create(order);
        return new CommonResult(200, "订单创建成功");
    }

}
