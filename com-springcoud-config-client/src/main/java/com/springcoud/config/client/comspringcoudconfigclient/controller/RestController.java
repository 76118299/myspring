package com.springcoud.config.client.comspringcoudconfigclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.web.bind.annotation.RestController
@RefreshScope  //当git发生变化刷新Bean字段的值
public class RestController {
    @Value("${myname}")
    private String myName;
    @GetMapping("/get/myname")
    public String getMyName(){
        return myName;
    }
}
