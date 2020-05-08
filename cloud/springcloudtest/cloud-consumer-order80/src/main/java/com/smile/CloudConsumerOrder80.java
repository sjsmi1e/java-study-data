package com.smile;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author smi1e
 * @description
 * @Date 2020/4/22 18:07
 */
@EnableEurekaClient
@SpringBootApplication
public class CloudConsumerOrder80 {
    public static void main(String[] args) {
        SpringApplication.run(CloudConsumerOrder80.class, args);
    }
}
