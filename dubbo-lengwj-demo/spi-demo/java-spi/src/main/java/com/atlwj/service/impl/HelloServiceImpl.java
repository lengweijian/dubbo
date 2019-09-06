package com.atlwj.service.impl;

public class HelloServiceImpl implements com.atlwj.service.HelloService {
    @Override
    public void say(String name) {
        System.out.printf("HelloServiceImpl.......你好！！ %s\n",name);
    }
}
