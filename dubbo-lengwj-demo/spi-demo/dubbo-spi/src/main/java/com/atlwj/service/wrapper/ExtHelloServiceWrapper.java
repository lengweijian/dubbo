package com.atlwj.service.wrapper;

import com.atlwj.service.ExtHelloService;

/**
 * 扩展实现类包装类01
 */
public class ExtHelloServiceWrapper implements ExtHelloService {

    private ExtHelloService extHelloService;

    public ExtHelloServiceWrapper(ExtHelloService extHelloService) {
        this.extHelloService = extHelloService;
    }

    public void say(String name) {

        System.out.println("after...");
        // 真正的逻辑实现
        extHelloService.say(name);

        System.out.println("before...");
    }
}
