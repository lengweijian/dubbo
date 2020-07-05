package com.atlwj.provider.impl;

import com.atlwj.provider.api.HelloService;

/**
 * 服务实现
 * @author lengweijian
 */
public class HelloServiceImpl implements HelloService {

    @Override
    public String sayHello(String name) {
        return "Hello !!:" + name;
    }
}
