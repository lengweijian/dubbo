package com.atlwj.config;

import com.atlwj.service.HelloService;
import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.ReferenceConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import java.io.IOException;

/**
 * JavaConfig consumer
 */
@Configurable
public class Config {

    private static final String APP_NAME = "dubbo-javaconfig-consumer-demo";

    private static final String DUBBO_PROTOCAL_NAME = "dubbo";

    private static final String ZK_ADDRESS = "zookeeper://127.0.0.1:2181";

    @Bean
    public ApplicationConfig applicationConfig(){
        ApplicationConfig applicationConfig = new ApplicationConfig();
        applicationConfig.setName(APP_NAME);
        return applicationConfig;
    }

    @Bean
    public RegistryConfig registryConfig (){
        RegistryConfig registryConfig = new RegistryConfig();
        registryConfig.setAddress(ZK_ADDRESS);
        return registryConfig;
    }

    @Bean
    public ReferenceConfig referenceConfig() {
        // 此实例很重，封装了与注册中心的连接以及与提供者的连接，请自行缓存，否则可能造成内存和连接泄漏
        ReferenceConfig<HelloService> reference = new ReferenceConfig<>();
        reference.setApplication(applicationConfig());
        // 多个注册中心可以用setRegistries()
        reference.setRegistry(registryConfig());
        reference.setInterface(HelloService.class);
        reference.setVersion("1.0.0");
        return reference;
    }

    public static void main(String[] args) throws IOException {
        AnnotationConfigApplicationContext ioc = new AnnotationConfigApplicationContext(Config.class);
        ioc.start();
        HelloService bean = (HelloService) ioc.getBean(ReferenceConfig.class).get();
        bean.sayHello("lengweijian");
        System.in.read();
    }
}
