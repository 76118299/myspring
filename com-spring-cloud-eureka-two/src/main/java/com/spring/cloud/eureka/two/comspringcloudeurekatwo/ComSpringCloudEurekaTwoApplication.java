package com.spring.cloud.eureka.two.comspringcloudeurekatwo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ComSpringCloudEurekaTwoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ComSpringCloudEurekaTwoApplication.class, args);
    }
}
