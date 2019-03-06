package com.niu.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.turbine.stream.EnableTurbineStream;

/**
 * Hello world!
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableTurbineStream
public class TurbineAmqpApp {
    public static void main(String[] args) {
        SpringApplication.run(TurbineAmqpApp.class, args);
    }
}
