package com.spring.cloud.eureka.one.comspringcloudeurekaone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ComSpringCloudEurekaOneApplication {

    public static void main(String[] args) {
        SpringApplication.run(ComSpringCloudEurekaOneApplication.class, args);
    }
}
