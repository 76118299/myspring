package com.web.handler;


import com.repository.UserRepository;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;



/**
 * webFlux 处理类
 * 相当于SERVICE
 */
@Component
public class UserHandler {

   private UserRepository userRepository;
    @Autowired
    public UserHandler(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Mono<ServerResponse> save(ServerRequest request){
        Mono<User> userMono = request.bodyToMono(User.class);
        Mono<Boolean> booleanMono = userMono.map(userRepository::save);
       return ServerResponse.ok().body(booleanMono,Boolean.class) ;
    }
}
