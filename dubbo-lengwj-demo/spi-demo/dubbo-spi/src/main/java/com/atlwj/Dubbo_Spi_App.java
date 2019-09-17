package com.atlwj;

import com.atlwj.service.DemoService;
import com.atlwj.di.service.WheelMaker;
import org.apache.dubbo.common.extension.ExtensionLoader;

/**
 * dubbo spi特性:
 *      1.自动注入： setter
 *      2.AOP: Wrapper01、Wrapper02
 */
public class Dubbo_SPI_APP {
    public static void main(String[] args) {
        ExtensionLoader<DemoService> extensionLoader = ExtensionLoader.getExtensionLoader(DemoService.class);
        DemoService extension = extensionLoader.getExtension("02");
        extension.sayHi("lengweijian");
//
//        DemoService demoService = extensionLoader.getAdaptiveExtension();
//        demoService.sayHi("hello");
    }
}
