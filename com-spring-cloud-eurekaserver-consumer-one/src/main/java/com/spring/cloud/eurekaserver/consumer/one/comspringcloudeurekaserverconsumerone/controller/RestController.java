package com.spring.cloud.eurekaserver.consumer.one.comspringcloudeurekaserverconsumerone.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
public class RestController {
    private RestTemplate restTemplate;
    private LoadBalancerClient loadBalancerClient;
    private DiscoveryClient discoveryClient;
    @Autowired
    public RestController(RestTemplate restTemplate,DiscoveryClient discoveryClient,LoadBalancerClient loadBalancerClient) {
        this.restTemplate = restTemplate;
        this.discoveryClient = discoveryClient;
        this.loadBalancerClient = loadBalancerClient;
    }
    @GetMapping("/say")
       public String say(){
        ServiceInstance choose = loadBalancerClient.choose("eurekaserver-provider-one");
        String url = "http://localhost:"+choose.getPort()+"/say";
        return restTemplate.getForObject(url,String.class);
    }


}
