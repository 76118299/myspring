package com.spring.cloud.eurekaserver.provider.one.comspringcloudeurekaserverproviderone.controller;

import model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;

@org.springframework.web.bind.annotation.RestController
public class TestController {
    private List<User> userList = new ArrayList<>();
    @GetMapping("/say")
    public String say(){
        return "hello java";
    }
    @GetMapping("/user/getlist")
    public List<User> getUser(){

//        User user = new User();
//        user.setId(1);
//        user.setName("三胖子");
//        userList.add(user);
        return userList;
    }
    @PostMapping("/user/addsave")
    public boolean saveUser(@RequestBody User user){
        boolean add = userList.add(user);
        return add;
    }
}
