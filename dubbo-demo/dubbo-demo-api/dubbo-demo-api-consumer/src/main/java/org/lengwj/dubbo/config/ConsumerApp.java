package org.lengwj.dubbo.config;

import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.context.annotation.*;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.support.SimpleTransactionStatus;

import java.io.IOException;

@ComponentScan(value = "org.lengwj.dubbo.config")
@EnableDubbo(scanBasePackageClasses = DemoServiceImpl02.class)
@EnableTransactionManagement // 激活事务管理
class ConsumerConfig{

    @Bean(value = "applicationConfig")
    @Description("当前应用配置")
    public ApplicationConfig applicationConfig(){
        ApplicationConfig applicationConfig = new ApplicationConfig();
        applicationConfig.setName("dubbo-demo-api-consumer");
        return applicationConfig;
    }

    @Bean(value = "registryConfig")
    @Description("当前连接注册中心配置")
    public RegistryConfig registryConfig(){
        RegistryConfig registryConfig = new RegistryConfig();
        registryConfig.setAddress("zookeeper://127.0.0.1:2181");
        return registryConfig;
    }

    @Bean
    @Description("自定义事务管理器")
    @Primary
    public PlatformTransactionManager transactionManager(){
        PlatformTransactionManager transactionManager = new PlatformTransactionManager() {
            @Override
            public TransactionStatus getTransaction(TransactionDefinition transactionDefinition) throws TransactionException {
                System.out.println("get transaction ...");
                return new SimpleTransactionStatus();
            }

            @Override
            public void commit(TransactionStatus transactionStatus) throws TransactionException {
                System.out.println("commit transaction ...");
            }

            @Override
            public void rollback(TransactionStatus transactionStatus) throws TransactionException {
                System.out.println("rollback transaction ...");
            }
        };
        return transactionManager;
    }
}
public class ConsumerApp {
    public static void main(String[] args) throws IOException {
        final AnnotationConfigApplicationContext ioc = new AnnotationConfigApplicationContext(ConsumerConfig.class);
        System.out.println(ioc.getBean(DemoServiceImpl02.class).sayHello("lengweijian"));
        System.in.read();
    }
}
