package com.atlwj.service.impl;

import com.atlwj.service.DemoService;

public class DemoServiceImpl_01 implements DemoService {
    @Override
    public void sayHi(String msg) {
        System.out.println("hello !!" + msg + "DemoServiceImpl_01....");
        return ;
    }
}
