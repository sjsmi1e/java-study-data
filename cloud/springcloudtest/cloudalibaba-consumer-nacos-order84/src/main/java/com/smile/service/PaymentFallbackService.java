package com.smile.service;

import com.smile.entities.CommonResult;
import com.smile.entities.Payment;
import org.springframework.stereotype.Component;

/**
 * @author smi1e
 * @description
 * @Date 2020/4/29 11:00
 */
@Component
public class PaymentFallbackService implements PaymentService {
    @Override
    public CommonResult<Payment> paymentSQL(Long id) {
        return new CommonResult<>(44444,"服务降级返回,---PaymentFallbackService",new Payment(id,"errorSerial"));
    }
}
