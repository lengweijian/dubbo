package org.lengwj.dubbo.javaconfig.config;

import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.ProtocolConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.apache.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

@Configuration
@DubboComponentScan("org.lengwj.dubbo.javaconfig.service.impl") // 扫描 Dubbo 组件
@ComponentScan("org.lengwj.dubbo.javaconfig.service.impl")
@PropertySource(value = "classpath:dubbo-provider.properties")
public class Provider {

    @Value(value = "${zkAddr}")
    private String zkAddr;

    @Value(value = "${protoTypeName}")
    private String protoTypeName;

    @Bean(value = "applicationConfig")
    @Description(value = "this is a unique application name.")
    public ApplicationConfig applicationConfig() {
        ApplicationConfig applicationConfig = new ApplicationConfig();
        applicationConfig.setName("dubbo-demo-api-provider");
        return applicationConfig;
    }

    @Bean(value = "registryConfig")
    @Description(value = "this is registry address.")
    public RegistryConfig registryConfig() {
        RegistryConfig registryConfig = new RegistryConfig();
        registryConfig.setAddress(this.zkAddr);
        return registryConfig;
    }

    @Bean(value = "protocolConfig")
    @Description(value = "dubbo default prototype is dubbo.")
    public ProtocolConfig protocolConfig(){
        ProtocolConfig protocolConfig = new ProtocolConfig();
        protocolConfig.setName(protoTypeName);
        protocolConfig.setPort(20080);
        return protocolConfig;
    }



}
