package com.smile;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author smi1e
 * @description 主启动类
 * @Date 2020/4/22 17:19
 */
@EnableEurekaClient
@SpringBootApplication
public class CloudProviderPayment8002 {
    public static void main(String[] args) {
        SpringApplication.run(CloudProviderPayment8002.class, args);
    }
}
