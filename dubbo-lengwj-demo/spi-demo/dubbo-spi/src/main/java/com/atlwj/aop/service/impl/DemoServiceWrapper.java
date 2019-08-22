package com.atlwj.aop.service.impl;

import com.atlwj.aop.service.DemoService;

public class DemoServiceWrapper implements DemoService {

    private DemoService demoService;

    public DemoServiceWrapper(DemoService demoService){  //具体的实现类
        this.demoService = demoService;
    }

    @Override
    public void sayHi(String msg) {
        System.out.println("Wrapper" + "before.....");
        // before
        demoService.sayHi(msg);
        // after
        System.out.println("Wrapper" + "after.....");

    }
}
