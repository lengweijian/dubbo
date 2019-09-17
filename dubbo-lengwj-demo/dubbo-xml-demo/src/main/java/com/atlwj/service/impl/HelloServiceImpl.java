package com.atlwj.service.impl;

import com.atlwj.service.HelloService;

public class HelloServiceImpl implements HelloService {
    @Override
    public String say(String name) {
        return "hello %s !!!\n" + name;
    }
}
