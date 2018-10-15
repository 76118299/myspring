package com.service.hystrix;

import com.service.feign.api.IUserService;
import model.User;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * Hystix 熔断处理
 */
public class UserHystrix implements IUserService {
    @Override
    public boolean save(@RequestBody User user) {
        return false;
    }

    @Override
    public List<User> getUserList() {
        return null;
    }
}
