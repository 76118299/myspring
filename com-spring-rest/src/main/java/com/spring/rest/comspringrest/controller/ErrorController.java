package com.spring.rest.comspringrest.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Spring mvc 的全局异常处理的Controller
 */
@RestControllerAdvice(basePackages = {""})  //可以指定不同包
public class ErrorController {
    @ExceptionHandler(Exception.class)
    public Object errorMessage( Throwable throwable){
        return  throwable.getMessage();
    }
}
