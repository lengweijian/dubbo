package com.atlwj.service.impl;

import com.atlwj.service.DemoService;

public class DemoServiceWrapper02 implements DemoService {

    private DemoService demoService;

    public DemoServiceWrapper02(DemoService demoService){  //具体的实现类
        this.demoService = demoService;
    }

    @Override
    public void sayHi(String msg) {
        System.out.println("Wrapper2" + "before2.....");
        // before
        demoService.sayHi(msg);
        // after
        System.out.println("Wrapper2" + "after2.....");

    }
}
