package com.smile.service.impl;

import com.smile.dao.StorageDao;
import com.smile.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author smi1e
 * @description
 * @Date 2020/5/1 15:05
 */
@Service
@Slf4j
public class StorageServiceImpl implements StorageService {

    @Resource
    StorageDao storageDao;

    @Override
    public void decrease(Long productId, Integer count) {
        log.info("------->storage-service中扣减库存开始");
        storageDao.decrease(productId, count);
        log.info("------->storage-service中扣减库存结束");
    }
}
