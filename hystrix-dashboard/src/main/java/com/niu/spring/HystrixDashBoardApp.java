package com.niu.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * Hello world!
 */
@EnableHystrixDashboard
@SpringBootApplication
public class HystrixDashBoardApp {
    public static void main(String[] args) {
        SpringApplication.run(HystrixDashBoardApp.class, args);
    }
}
