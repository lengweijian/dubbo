package com.atlwj.config;

import com.atlwj.service.HelloService;
import com.atlwj.service.HelloServiceImpl;
import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.ProtocolConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.apache.dubbo.config.ServiceConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@Configuration
public class Config {

    private static final String DUBBO_PROTOCAL_NAME = "dubbo";

    private static final String ZK_ADDRESS = "zookeeper://127.0.0.1:2181";

    private static final String APP_NAME = "dubbo-javaconfig-provider-demo";

    @Bean
    public ApplicationConfig applicationConfig(){
        ApplicationConfig applicationConfig = new ApplicationConfig();
        applicationConfig.setName(APP_NAME);
        return applicationConfig;
    }

    @Bean
    public RegistryConfig registryConfig(){
        RegistryConfig registryConfig = new RegistryConfig();
        registryConfig.setAddress(ZK_ADDRESS);
        return registryConfig;
    }

    @Bean
    public ProtocolConfig protocolConfig(){
        ProtocolConfig protocolConfig = new ProtocolConfig();
        protocolConfig.setName(DUBBO_PROTOCAL_NAME);
        protocolConfig.setPort(20881);
        return protocolConfig;
    }

    @Bean
    public ServiceConfig<HelloService> serviceConfig(){
        ServiceConfig<HelloService> serviceConfig = new ServiceConfig<>();
        serviceConfig.setVersion("1.0.0");
        serviceConfig.setProtocol(protocolConfig());
        serviceConfig.setRegistry(registryConfig());
        serviceConfig.setApplication(applicationConfig());
        serviceConfig.setInterface(HelloService.class);
        serviceConfig.setRef(helloService());

        // 暴露及注册服务
        serviceConfig.export();
        return serviceConfig;
    }

    @Bean
    public HelloService helloService(){
        return new HelloServiceImpl();
    }

    public static void main(String[] args) throws IOException {
        AnnotationConfigApplicationContext ioc = new AnnotationConfigApplicationContext(Config.class);
        ioc.start();
        System.out.println("JavaConfig服务提供已完成。。。");
        System.in.read();
    }
}
