package com.atlwj.aop.service;

import org.apache.dubbo.common.extension.SPI;


@SPI
public interface DemoService {
    void sayHi(String msg);
}
