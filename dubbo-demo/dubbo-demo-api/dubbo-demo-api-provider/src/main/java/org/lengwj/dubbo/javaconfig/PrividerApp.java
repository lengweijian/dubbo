package org.lengwj.dubbo.javaconfig;

import org.apache.dubbo.rpc.RpcContext;
import org.lengwj.dubbo.javaconfig.config.Provider;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;

public class PrividerApp {
    public static void main(String[] args) throws IOException {
        AnnotationConfigApplicationContext ioc = new AnnotationConfigApplicationContext(Provider.class);
        RpcContext context = RpcContext.getContext();
        ioc.start();
        System.out.printf("%s server has provided a service!!", context.getLocalHostName());
        System.in.read();
    }
}
