package com.atlwj.service.Impl;

import com.atlwj.service.ExtHelloService;

/**
 * Ext 01
 */
public class ExtHelloServiceImpl implements ExtHelloService {

    public void say(String name) {
        System.out.printf("ExtHelloServiceImpl.....你好！！%s\n",name);
    }
}
