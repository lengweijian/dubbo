package com.atlwj.service.impl;

public class HelloServiceImpl02 implements com.atlwj.service.HelloService {
    @Override
    public void say(String name) {
        System.out.printf("HelloServiceImpl02.....你好！！ %s\n",name);
    }
}
