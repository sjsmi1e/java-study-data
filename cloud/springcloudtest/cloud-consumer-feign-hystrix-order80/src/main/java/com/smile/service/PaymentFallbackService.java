package com.smile.service;

import org.springframework.stereotype.Component;

/**
 * @author smi1e
 * @description
 * @Date 2020/4/24 12:44
 */
@Component
public class PaymentFallbackService implements OrderService {
    @Override
    public String paymentInfo_OK(Integer id) {
        return "-----PaymentFallbackService fall back-paymentInfo_OK , (┬＿┬)";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "-----PaymentFallbackService fall back-paymentInfo_TimeOut , (┬＿┬)";
    }

}
