package com.spring.rest.comspringrest.com.config;

import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.ErrorPageRegistrar;
import org.springframework.boot.web.server.ErrorPageRegistry;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;

/**
 * spring boot 异常处理用的，跳转到错误页面
 * Spring boot 处理
 */
@Configuration
public class MyErrorPage implements ErrorPageRegistrar {
    @Override
    public void registerErrorPages(ErrorPageRegistry registry) {
        //注册错误页面的跳转的路径
        registry.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND,"/404.html"));
    }
}
