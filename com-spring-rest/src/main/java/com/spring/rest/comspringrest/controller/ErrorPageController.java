package com.spring.rest.comspringrest.controller;

import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * spring boot 的错误页面处理
 */
@RestController
public class ErrorPageController {
    /**
     * 404异常
     * @param request
     * @param status
     * @return
     */
//    @GetMapping("/404.html")
//    public Map<String, Object> errorPage(HttpServletRequest  request, HttpStatus status,Throwable throwable){
//        Map<String,Object> errorMap = new HashMap<String,Object> ();
//        //获取错误信息
//        errorMap.put("statuscode",request.getAttribute(""));
//        return errorMap;
//    }
}
