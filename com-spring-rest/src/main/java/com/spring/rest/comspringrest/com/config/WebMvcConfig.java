package com.spring.rest.comspringrest.com.config;

import com.spring.rest.comspringrest.extend.http.message.PropertiesMessage;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.xml.MappingJackson2XmlHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * 扩展BOOT序列化 需要实现WebMvcConfigurer接口 并实现 extendMessageConverters 方法
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        /**
         * 0 对顺序的调整 ，因为 boot 是按照顺序进行匹配 medtype的
         * 先是精准匹配，如果没有匹配到就模糊匹配，尝试着那些类可以序列化添加到list
         * 让后按照先来先服务进行处理
         */
        converters.set(0,new MappingJackson2XmlHttpMessageConverter());
        //自定义扩展的message
        converters.set(1,new PropertiesMessage());
    }
}
