package com.spring.rest.comspringrest.extend.http.message;

import com.spring.rest.comspringrest.entity.User;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

import java.io.*;
import java.nio.charset.Charset;
import java.util.Properties;

/**
 * 扩展properties 形式的消息 需要继承AbstractHttpMessageConverter
 */
public class PropertiesMessage  extends AbstractHttpMessageConverter<User> {
    public PropertiesMessage(){
        //设置MediaType
        super(MediaType.valueOf("application/propertiesuser"));
        //设置字符集
        setDefaultCharset(Charset.forName("UTF-8"));
    }
    @Override
    protected boolean supports(Class<?> clazz) {
        return clazz.isAssignableFrom(User.class);
    }

    /**
     * 将请求的参数 封装User
     * @param clazz
     * @param inputMessage
     * @return
     * @throws IOException
     * @throws HttpMessageNotReadableException
     */
    @Override
    protected User readInternal(Class<? extends User> clazz, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
        InputStream requestBody = inputMessage.getBody();
        Properties properties = new Properties();
        properties.load(new InputStreamReader(requestBody,getDefaultCharset()));
        User user = new User();
        user.setId(Integer.valueOf(properties.getProperty("user.id")));
        user.setName(properties.getProperty("user.name"));
        return user;
    }

    /**
     * 将User对象写出到浏览器中
     * @param user
     * @param outputMessage
     * @throws IOException
     * @throws HttpMessageNotWritableException
     */
    @Override
    protected void writeInternal(User user, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
        OutputStream responseBody = outputMessage.getBody();
        Properties properties = new Properties();
        properties.setProperty("user.id",String.valueOf(user.getId()));
        properties.setProperty("user.name",user.getName());
        properties.store(new OutputStreamWriter(responseBody,getDefaultCharset()),"");

    }
}
