package com.spring.cloud.eurekaserver.consumer.one.comspringcloudeurekaserverconsumerone;

import com.service.feign.api.IUserService;
import com.spring.cloud.eurekaserver.consumer.one.comspringcloudeurekaserverconsumerone.rule.MyRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.ribbon.FeignLoadBalancer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
@EnableHystrix
@EnableFeignClients(clients = IUserService.class)
//@RibbonClient(value = "eurekaserver-provider-one" ,configuration =ComSpringCloudEurekaserverConsumerOneApplication.class )
public class ComSpringCloudEurekaserverConsumerOneApplication {


    public static void main(String[] args) {
        SpringApplication.run(ComSpringCloudEurekaserverConsumerOneApplication.class, args);

    }
//    @Bean
//    public MyRule getRule(){
//        return  new MyRule();
//    }

    /**
     * restTemplate 实现远程调用
     * @return
     */
    @LoadBalanced
    @Bean
    public RestTemplate getTemplable(){
        return new RestTemplate();
    }

}
