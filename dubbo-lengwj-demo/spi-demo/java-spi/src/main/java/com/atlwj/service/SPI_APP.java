package com.atlwj.service;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * SPI 全称为 (Service Provider Interface) ,是JDK内置的一种服务提供发现机制。
 *
 * SPI机制的约定
 * 1. 在META-INF/dubbo/目录中创建以Service接口全限定名命名的文件，该文件内容为Service接口具体实现类的全限定名，文件编码必须为UTF-8。
 * 2. 使用ServiceLoader.load(Class class); 动态加载Service接口的实现类。
 * 3. 如SPI的实现类为jar，则需要将其放在当前程序的classpath下。
 * 4. Service的具体实现类必须有一个不带参数的构造方法。
 * 问题有没有什么缺点？？
 *
 * 应用场景mysql JDBC驱动包。
 */
public class SPI_APP {
    public static void main(String[] args) {
        // 这句话的意思就是加载DemoService接口的实现类
        ServiceLoader<DemoService> serviceLoader =  ServiceLoader.load(DemoService.class);
        Iterator<DemoService> iterator = serviceLoader.iterator();
        while (iterator.hasNext() && serviceLoader != null){
            DemoService helloService = iterator.next();
            helloService.sayHi("lengweijian");
        }
    }
}
