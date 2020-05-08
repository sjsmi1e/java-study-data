package com.smile.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author smi1e
 * @description
 * @Date 2020/4/25 12:02
 */
@RestController
@RefreshScope
public class ConfigClientController {
    @Value("${config_info}")
    private String configInfo;

    @Value("${version}")
    private String versionNum;

    @GetMapping("/configInfo")
    public String getConfigInfo() {
        return configInfo + "\t" + versionNum;
    }


}
