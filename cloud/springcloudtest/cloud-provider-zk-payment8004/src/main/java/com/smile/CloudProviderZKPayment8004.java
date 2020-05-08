package com.smile;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author smi1e
 * @description
 * @Date 2020/4/23 13:36
 */
@SpringBootApplication
@EnableDiscoveryClient
public class CloudProviderZKPayment8004 {
    public static void main(String[] args) {
        SpringApplication.run(CloudProviderZKPayment8004.class, args);
    }
}
