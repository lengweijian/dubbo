package com.atlwj;

import com.atlwj.service.HelloService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class ConsumerApp {

    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("consumer.xml");
        context.start();
        HelloService helloService = (HelloService) context.getBean("helloService");
        System.out.println(helloService.sayHello("lengwj"));
        System.in.read();


    }
}
