package com.springcoud.config.client.comspringcoudconfigclient.demo;

import java.util.Observable;
import java.util.Observer;

public class Demo {
    public static void main(String[] args) {
        //创建发布者
        MyObservable observable = new MyObservable();
        //添加订阅者
        observable.addObserver(new Observer() {
            @Override
            public void update(Observable o, Object arg) {
                System.out.println("我是订阅者");
            }
        });
        observable.setChanged();

        observable.notifyObservers("我发布事件了");
    }

    public static class MyObservable extends Observable{
        @Override
        public synchronized void setChanged() {
            super.setChanged();
        }
    }
}
