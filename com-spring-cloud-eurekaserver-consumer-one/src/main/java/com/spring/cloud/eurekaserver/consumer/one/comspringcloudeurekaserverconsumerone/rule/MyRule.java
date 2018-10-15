package com.spring.cloud.eurekaserver.consumer.one.comspringcloudeurekaserverconsumerone.rule;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;

import java.util.List;

/**
 * ribbon 自定义负载均衡
 */
public class MyRule extends AbstractLoadBalancerRule {
    @Override
    public void initWithNiwsConfig(IClientConfig iClientConfig) {

    }

    @Override
    public Server choose(Object key) {
        Server server = null;
        ILoadBalancer loadBalanceda = getLoadBalancer();
        List<Server> allServers = ((ILoadBalancer) loadBalanceda).getAllServers();


        return allServers.get(0);
    }
}
