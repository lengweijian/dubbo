package com.atlwj.service;

public class HelloServiceImpl implements HelloService{

    @Override
    public String sayHello(String username) {
        return "你好！！"  + username + "  我是使用JavaConfig方式提供服务。。";
    }
}
