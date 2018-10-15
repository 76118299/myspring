package com.spring.cloud.eurekaserver.consumer.one.comspringcloudeurekaserverconsumerone.controller;

import com.service.feign.api.IUserService;
import model.User;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
/**
 * feign 客户端
 * 服务消费者 通过 feign 客户端 调用服务提供端的方法 方式二
 * uri会被继承下来
 */
@RestController
public class FeginConsumerClientController1  {
    private IUserService userService;

    public FeginConsumerClientController1(IUserService userService) {
        this.userService = userService;
    }

//    @Override
//    public boolean save(User user) {
//        return userService.save(user);
//    }
//
//    @Override
//    public List<User> getUserList() {
//        return userService.getUserList();
//    }
}
