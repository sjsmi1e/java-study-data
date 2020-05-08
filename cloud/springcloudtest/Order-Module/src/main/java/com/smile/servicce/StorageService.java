package com.smile.servicce;


import com.smile.entities.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author smi1e
 * @description
 * @Date 2020/5/1 14:40
 */
@FeignClient(value = "seata-storage-service")
public interface StorageService {
    /**
     * 减少库存
     * @param productId
     * @param count
     * @return
     */
    @PostMapping(value = "/storage/decrease")
    CommonResult decrease(@RequestParam("productId") Long productId, @RequestParam("count") Integer count);
}
