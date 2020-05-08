package com.smile.controller;

import com.smile.entities.CommonResult;
import com.smile.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author smi1e
 * @description
 * @Date 2020/5/1 15:06
 */
@RestController
@Slf4j
public class StorageController {

    @Resource
    private StorageService storageService;

    //扣减库存
    @RequestMapping("/storage/decrease")
    public CommonResult decrease(Long productId, Integer count) {
        log.info("产品id:" + productId);
        log.info("数量:" + count);
        storageService.decrease(productId, count);
        return new CommonResult(200, "扣减库存成功！");
    }

}
