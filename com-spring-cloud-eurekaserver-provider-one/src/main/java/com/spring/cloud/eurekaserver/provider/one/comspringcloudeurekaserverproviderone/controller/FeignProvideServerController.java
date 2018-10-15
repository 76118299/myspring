package com.spring.cloud.eurekaserver.provider.one.comspringcloudeurekaserverproviderone.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * feign 服务端 服务提供者的方法
 * 方法的uri要和服务调用方的uri 一样 实现契约统一
 */
@RestController
public class FeignProvideServerController {
    @PostMapping("/user/save")
    public boolean save(@RequestBody User user){
        System.err.println("服务提供方8081 被调用");
        return false;
    }
    @GetMapping("/user/list")
    @HystrixCommand(fallbackMethod = "fallbackUserList",commandProperties = {
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value = "1000")
    })
    public List<User> getUserList(){
        System.err.println("服务提供方8081 被调用");
        return  null;
    }

    public List<User> fallbackUserList(){
        return  null;
    }


}
