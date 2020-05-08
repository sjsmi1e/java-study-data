package com.smile.controller;

import com.smile.entities.CommonResult;
import com.smile.entities.Payment;
import com.smile.service.impl.PaymentServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @author smi1e
 * @description
 * @Date 2020/4/22 17:45
 */
@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentServiceImpl paymentService;
    @Value("${server.port}")
    private String serverPort;

    @PostMapping("/payment/create")
    public CommonResult create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("插入结果：" + result);
        if (result > 0) {
            return new CommonResult(200, "插入数据成功,serverPort:"+serverPort, result);
        } else {
            return new CommonResult(444, "插入数据失败", null);
        }
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult create(@PathVariable Long id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info("查询结果：" + payment);
        if (payment != null) {
            return new CommonResult(200, "查询数据成功,serverPort:"+serverPort, payment);
        } else {
            return new CommonResult(444, "没有记录，查询Id：" + id, null);
        }
    }

    @GetMapping(value = "/payment/feign/timeout")
    public String paymentFeignTimeout(){
        try { TimeUnit.SECONDS.sleep(3); }catch (Exception e) {e.printStackTrace();}
        return serverPort;
    }
}
