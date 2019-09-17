package com.atlwj.comsumer;

import com.atlwj.framework.ProxyFactory;
import com.atlwj.provider.api.HelloService;

public class Consumer {
    public static void main(String[] args) {
        HelloService proxy = ProxyFactory.getProxy(HelloService.class);
        System.out.printf("您好！%s\n",proxy.sayHello("lengwj"));
    }
}
