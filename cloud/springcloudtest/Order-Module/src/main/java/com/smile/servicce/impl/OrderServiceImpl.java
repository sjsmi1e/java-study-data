package com.smile.servicce.impl;

import com.smile.dao.OrderDao;
import com.smile.domain.Order;
import com.smile.servicce.AccountService;
import com.smile.servicce.OrderService;
import com.smile.servicce.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author smi1e
 * @description
 * @Date 2020/5/1 13:47
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Resource
    OrderDao orderDao;
    @Resource
    StorageService storageService;
    @Resource
    AccountService accountService;

    @Override
    @GlobalTransactional
    public void create(Order order) {
        log.info("创建订单");
        orderDao.create(order);
        log.info("创建订单完成");

        log.info("订单微服务：减少库存");
        storageService.decrease(order.getProductId(), order.getCount());
        log.info("订单微服务：减少库存,完成");

        log.info("订单服务，减少余额");
        accountService.decrease(order.getUserId(), order.getMoney());
        log.info("订单服务，减少余额完成");

        log.info("修改订单状态");
        orderDao.update(order.getUserId(), 0);
        log.info("修改订单状态完成");
    }
}
