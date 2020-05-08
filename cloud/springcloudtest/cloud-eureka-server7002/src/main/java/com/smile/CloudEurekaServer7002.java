package com.smile;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author smi1e
 * @description
 * @Date 2020/4/22 19:46
 */
@EnableEurekaServer
@SpringBootApplication
public class CloudEurekaServer7002 {
    public static void main(String[] args) {
        SpringApplication.run(CloudEurekaServer7002.class, args);
    }
}
