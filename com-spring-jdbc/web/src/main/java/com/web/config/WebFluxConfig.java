package com.web.config;

import com.repository.UserRepository;
import com.web.handler.UserHandler;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;


import java.util.Collection;

import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

/**
 * webFlux 配置
 * 这里面调用handler的处理类
 */
@Configuration
public class WebFluxConfig {
    @Bean
    public RouterFunction<ServerResponse> saveUser(UserHandler handler){
        //相当于Controller
        return route(POST("/webflux/user/save"),handler::save);
    }
    @Bean
    @Autowired
    public RouterFunction<ServerResponse> getUsers(UserRepository userRepository){
        Collection<User> users = userRepository.getUsers();
        Flux<User> userFlux = Flux.fromIterable(users);
       return RouterFunctions.route(RequestPredicates.path("/user/getusers"),
                request -> ServerResponse.ok().body(userFlux,User.class));
    }
}
