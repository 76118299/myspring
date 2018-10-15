package com.spring.cloud.eurekaserver.provider.one.comspringcloudeurekaserverproviderone.service;

import com.service.feign.api.IUserService;
import model.User;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserService implements IUserService {
    @Override
    public boolean save(User user) {
        return false;
    }

    @Override
    public List<User> getUserList() {
        return null;
    }
}
