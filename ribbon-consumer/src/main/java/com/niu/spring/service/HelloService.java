package com.niu.spring.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by ami on 2019/3/6.
 */
@Service
public class HelloService {

    private final Logger logger = Logger.getLogger(getClass());

    @Autowired
    RestTemplate restTemplate;


    @HystrixCommand(fallbackMethod = "helloFallback", commandKey = "helloKey")
    public String helloService() {

        long start = System.currentTimeMillis();
        String result = restTemplate.getForEntity("http://HELLO-SERVICE/hello", String.class).getBody();
        long end = System.currentTimeMillis();
        logger.info("Spend time : " + (end - start));
        return result;
    }

    public String helloFallback() {
        return "error";
    }

}
