package com.atlwj.aop.service.impl;

import com.atlwj.aop.service.DemoService;

public class DemoServiceImpl_01 implements DemoService {
    @Override
    public void sayHi(String msg) {
        System.out.println("hello !!" + msg + "DemoServiceImpl_01....");
        return ;
    }
}
