package com.springcoud.config.client.comspringcoudconfigclient;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.cloud.context.refresh.ContextRefresher;

import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.List;
import java.util.Set;


@SpringBootApplication
@EnableScheduling
public class ComSpringcoudConfigClientApplication {
    private ContextRefresher contextRefresher;
    private Environment environment;
    @Autowired
    public ComSpringcoudConfigClientApplication(ContextRefresher contextRefresher,Environment environment) {
        this.contextRefresher = contextRefresher;
        this.environment = environment;
    }
    //自动刷新服务的配置信息
    @Scheduled(fixedRate = 5*1000 ,initialDelay = 1000)
    public void autoRefresh(){
        Set<String> refresh = this.contextRefresher.refresh();
        if(!refresh.isEmpty()){
            for (String properName : refresh){
                String property = environment.getProperty(properName);
                System.out.println(property);
            }
        }

    }
    public static void main(String[] args) {
        SpringApplication.run(ComSpringcoudConfigClientApplication.class, args);
    }
}
