package com.springcoud.config.client.comspringcoudconfigclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class ComSpringcoudConfigClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(ComSpringcoudConfigClientApplication.class, args);
    }
}
