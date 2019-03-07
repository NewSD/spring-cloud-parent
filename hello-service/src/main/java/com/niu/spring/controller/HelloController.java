package com.niu.spring.controller;

import com.niu.spring.domain.User;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.Random;


/**
 * Created by ami on 2019/3/5.
 */
@RestController
public class HelloController {

    private final Logger logger = Logger.getLogger(getClass());

    @Autowired
    private DiscoveryClient client;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String index() throws Exception {
        ServiceInstance instance = client.getLocalServiceInstance();

//        让线程在此等待几秒
//        int sleepTime = new Random().nextInt(3000);
//        logger.info("sleepTime: " + sleepTime);
//        Thread.sleep(sleepTime);

        logger.info("/hello, host:" + instance.getHost() + ", service_id:" + instance.getServiceId());

        return "Hello World";
    }

    @RequestMapping(value = "/hello2", method = RequestMethod.GET)
    public User hello(@RequestParam String name, @RequestParam Integer age) throws Exception {
        ServiceInstance instance = client.getLocalServiceInstance();
        logger.info("/hello, host:" + instance.getHost() + ", service_id:" + instance.getServiceId());
        return new User(name, age);
    }

    @RequestMapping(value = "/hello1", method = RequestMethod.GET)
    public String hello(@RequestParam String name) throws Exception {
        ServiceInstance instance = client.getLocalServiceInstance();
        logger.info("/hello, host:" + instance.getHost() + ", service_id:" + instance.getServiceId());
        return "Hello " + name;
    }

    @RequestMapping(value = "/hello3", method = RequestMethod.GET)
    public String hello(@RequestBody User user) throws Exception {
        ServiceInstance instance = client.getLocalServiceInstance();
        logger.info("/hello, host:" + instance.getHost() + ", service_id:" + instance.getServiceId());
        return "Hello " + user.getName() + ", " + user.getAge();
    }


}
