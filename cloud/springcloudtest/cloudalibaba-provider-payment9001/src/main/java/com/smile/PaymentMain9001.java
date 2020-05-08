package com.smile;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author smi1e
 * @description
 * @Date 2020/4/27 13:24
 */
@EnableDiscoveryClient
@SpringBootApplication
public class PaymentMain9001 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentMain9001.class, args);
    }

    @RestController
    @RefreshScope
    public class PaymentController {
        @Value("${server.port}")
        private String serverPort;

        @Value("${config.info}")
        private String configInfo;

        @GetMapping(value = "/payment/nacos/{id}")
        public String getPayment(@PathVariable("id") Integer id) {
            return "nacos registry, serverPort: " + serverPort + "\t id" + id;
        }
        @GetMapping("/config/info")
        public String getConfigInfo() {
            return configInfo;
        }
    }
}
