package com.smile;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author smi1e
 * @description
 * @Date 2020/4/22 19:34
 */
@EnableEurekaServer
@SpringBootApplication
public class CloudEurekaServer7001 {
    public static void main(String[] args) {
        SpringApplication.run(CloudEurekaServer7001.class, args);
    }
}
