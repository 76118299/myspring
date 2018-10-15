package com.spring.cloud.eurekaserver.consumer.one.comspringcloudeurekaserverconsumerone.controller;

import com.service.feign.api.IUserService;
import model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * feign 客户端
 * 服务消费者 通过 feign 客户端 调用服务提供端的方法 方式一
 */
@RestController
public class FeginConsumerClientController  {
    private IUserService userService;

    public FeginConsumerClientController(IUserService userService) {
        this.userService = userService;
    }
    @PostMapping("/user/save")
    public boolean save(@RequestBody User user) {
        System.err.println("服务消费方被8082");
        return userService.save(user);
    }


    @GetMapping("/user/list11")
    public List<User> getUserList() {
        System.err.println("服务消费方被8082");
        return userService.getUserList();
    }
}
