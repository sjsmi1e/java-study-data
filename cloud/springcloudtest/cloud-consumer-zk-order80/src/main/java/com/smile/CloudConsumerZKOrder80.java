package com.smile;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author smi1e
 * @description
 * @Date 2020/4/23 13:45
 */
@SpringBootApplication
@EnableDiscoveryClient
public class CloudConsumerZKOrder80 {
    public static void main(String[] args) {
        SpringApplication.run(CloudConsumerZKOrder80.class, args);
    }
}
