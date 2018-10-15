package com.service.feign.api;

import java.util.List;

import com.service.hystrix.UserHystrix;
import model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * 订阅 feign 和 服务提供方的契约 就uri要和服务提供方的一样
 */
@FeignClient(value = "eurekaserver-provider-one" ,fallback = UserHystrix.class)
public interface IUserService {
    @PostMapping("/user/save")
    public boolean save(@RequestBody User user);
    @GetMapping("/user/list")
    public List<User> getUserList();
}
