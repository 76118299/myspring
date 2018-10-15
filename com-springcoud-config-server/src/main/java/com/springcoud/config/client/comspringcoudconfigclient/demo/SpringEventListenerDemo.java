package com.springcoud.config.client.comspringcoudconfigclient.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 自定义sping 事件监听器
 */
public class SpringEventListenerDemo {
    public static void main(String[] args) {
        //创建spring 上下文
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();


        //添加事件监听器
        context.addApplicationListener(new ApplicationListener<MyApplicationEvent>() {
            @Override
            public void onApplicationEvent(MyApplicationEvent event) {
                System.err.println(event.getSource());
            }
        });
        context.refresh();
        //添加事件源 发布一个事件
        context.publishEvent(new MyApplicationEvent("xxx",context));
    }

    /**
     * 自定义事件
     */
    public static class MyApplicationEvent extends ApplicationEvent{
        public MyApplicationEvent(Object source, ApplicationContext applicationContext) {
            super(source);
            this.applicationContext = applicationContext;
        }

        public ApplicationContext getApplicationContext() {
            return applicationContext;
        }

        private ApplicationContext applicationContext;

        /**
         * Create a new ApplicationEvent.
         *
         * @param source the object on which the event initially occurred (never {@code null})
         */
        public MyApplicationEvent(Object source) {
            super(source);
        }
    }
}
