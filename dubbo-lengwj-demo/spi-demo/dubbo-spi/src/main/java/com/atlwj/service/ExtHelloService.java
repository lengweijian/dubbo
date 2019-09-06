package com.atlwj.service;


import org.apache.dubbo.common.extension.SPI;

@SPI
public interface ExtHelloService {
    void say(String name);
}
