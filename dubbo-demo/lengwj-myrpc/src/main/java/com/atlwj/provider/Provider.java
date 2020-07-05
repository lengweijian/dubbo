package com.atlwj.provider;

import com.atlwj.framework.Protocol;
import com.atlwj.framework.ProtocolFactory;
import com.atlwj.framework.Url;
import com.atlwj.provider.api.HelloService;
import com.atlwj.provider.impl.HelloServiceImpl;
import com.atlwj.provider.register.LocalRegister;
import com.atlwj.provider.register.RemoteMapRegister;

import java.net.MalformedURLException;

/**
 * httpclient
 */
public class Provider {
    public static void main(String[] args) throws MalformedURLException {
        // 1.本地注册（接口名：实现类）
        LocalRegister.regist(HelloService.class.getName(), HelloServiceImpl.class);

        // 2.注册中心注册（接口名： List<URL> urls）
//        Url url = new Url("localhost",8080);
//        RemoteMapRegister.regist(HelloService.class.getName(),url);

        // 3.启动tomcat
//        Protocol protocol = ProtocolFactory.getProtocol();
//        protocol.start(url);
    }
}
