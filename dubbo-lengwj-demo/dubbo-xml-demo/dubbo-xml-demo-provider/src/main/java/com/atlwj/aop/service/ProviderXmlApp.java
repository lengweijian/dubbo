package com.atlwj.aop.service;

import javafx.fxml.Initializable;
import org.apache.dubbo.rpc.RpcContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class ProviderXmlApp {

    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("provider-xml-application.xml");
        System.out.println("服务" + RpcContext.getContext().getLocalHostName() + "正在提供服务ing");
        System.in.read();
    }
}
