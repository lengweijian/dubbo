package com.atlwj.aop.service.impl;

import com.atlwj.aop.service.DemoService;

public class DemoServiceImpl_02 implements DemoService {
    @Override
    public void sayHi(String msg) {
        System.out.println("hello !!" + msg + "DemoServiceImpl_02.....");
        return ;
    }
}
