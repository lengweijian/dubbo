package com.atlwj.service.impl;


import com.atlwj.service.HelloService;

public class HelloServiceImpl implements HelloService {
    @Override
    public String sayHello(String name) {
        return "hello !! " + name;
    }
}
