package com.niu.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * Hello world!
 */
@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
public class FeignConsumerApp {
    public static void main(String[] args) {
        SpringApplication.run(FeignConsumerApp.class, args);
    }
}
