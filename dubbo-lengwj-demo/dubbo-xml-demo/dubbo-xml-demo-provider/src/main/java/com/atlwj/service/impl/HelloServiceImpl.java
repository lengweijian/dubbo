package com.atlwj.service.impl;


import com.atlwj.service.HelloService;

public class HelloServiceImpl implements HelloService {


    @Override
    public String sayHello(String username) {
        return "hello !!" + username + "我是xml方式提供的helloService服务...";
    }
}
