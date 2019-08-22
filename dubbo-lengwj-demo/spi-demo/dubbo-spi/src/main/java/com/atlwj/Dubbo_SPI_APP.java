package com.atlwj;

import com.atlwj.aop.service.DemoService;
import com.atlwj.di.service.WheelMaker;
import com.atlwj.di.service.impl.AdaptiveWheelMaker;
import org.apache.dubbo.common.URL;
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

        WheelMaker wheel = (WheelMaker) extensionLoader.getExtension("wheel");

    }
}
