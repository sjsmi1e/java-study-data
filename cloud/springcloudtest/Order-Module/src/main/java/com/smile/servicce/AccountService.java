package com.smile.servicce;

import com.smile.entities.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 * @author smi1e
 * @description
 * @Date 2020/5/1 14:41
 */
@FeignClient(value = "seata-account-service")
public interface AccountService {
    /**
     * 减少余额
     * @param userId
     * @param money
     * @return
     */
    @PostMapping(value = "/account/decrease")
    CommonResult decrease(@RequestParam("userId") Long userId, @RequestParam("money") BigDecimal money);

}
