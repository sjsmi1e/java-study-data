package com.smile.service;

import com.smile.entities.Payment;

/**
 * @author smi1e
 * @description
 * @Date 2020/4/22 17:41
 */
public interface PaymentService {
    public int create(Payment payment); //写

    public Payment getPaymentById(Long id);  //读取
}
