package com.smile.service;

/**
 * @author smi1e
 * @description
 * @Date 2020/5/1 15:05
 */
public interface StorageService {
    // 扣减库存
    void decrease(Long productId, Integer count);
}
