package com.smile.myhandle;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.smile.entities.CommonResult;

/**
 * @author smi1e
 * @description
 * @Date 2020/4/29 10:34
 */
public class CustomerBlockHandler {
    public static CommonResult handlerException(BlockException exception) {
        return new CommonResult(2020, "自定义限流处理信息....CustomerBlockHandler");
    }
}
