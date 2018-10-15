package com.spring.cloud.eurekaserver.provider.one.comspringcloudeurekaserverproviderone;

import com.service.feign.api.IUserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient         //激活eureka客户端
@EnableHystrix    //激活熔断处理
public class ComSpringCloudEurekaserverProviderOneApplication {

    public static void main(String[] args) {
        SpringApplication.run(ComSpringCloudEurekaserverProviderOneApplication.class, args);
    }
}
