package com.atlwj.framework;

import com.atlwj.provider.api.HelloService;
import com.atlwj.provider.register.RemoteMapRegister;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;

public class ProxyFactory {

    public static <T> T getProxy(Class interfaceName){

        return (T)Proxy.newProxyInstance(interfaceName.getClassLoader(), new Class[]{interfaceName}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Protocol protocol = ProtocolFactory.getProtocol();
                Invocation invocation = new Invocation(HelloService.class.getName(),method.getName(),method.getParameterTypes(),args);
                List<Url> urls = RemoteMapRegister.get(interfaceName.getName());
                Url url = MyLoadbalance.random(urls);
                return protocol.send(url, invocation);
            }
        });
    }
}
