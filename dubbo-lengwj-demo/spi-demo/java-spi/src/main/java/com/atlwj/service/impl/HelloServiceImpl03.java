package com.atlwj.service.impl;

public class HelloServiceImpl03 implements com.atlwj.service.HelloService {
    @Override
    public void say(String name) {
        System.out.printf("HelloServiceImpl03.....你好！！ %s\n",name);
    }
}
