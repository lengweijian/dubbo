package com.atlwj.service.Impl;

import com.atlwj.service.ExtHelloService;

public class ExtHelloServiceImpl02 implements ExtHelloService {
    
    public void say(String name) {
        System.out.printf("ExtHelloServiceImpl02.....你好！！%s\n",name);
    }
}
