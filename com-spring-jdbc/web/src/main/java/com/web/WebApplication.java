package com.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 打成jar 启动方式
 * java -jar xxx.jar  --server.port = 9090
 *
 * 还要目录启动方式
 * java  MAIN - class指定的类
 * java xx.class
 * 如果是war 就启动带War的
 */
@SpringBootApplication
public class WebApplication {
    public static void main(String[] args) {
        SpringApplication.run(WebApplication.class,args);
    }
}
