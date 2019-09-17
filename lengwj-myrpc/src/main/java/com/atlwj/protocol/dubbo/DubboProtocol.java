package com.atlwj.protocol.dubbo;

import com.atlwj.framework.AbstractProtocol;
import com.atlwj.framework.Invocation;
import com.atlwj.framework.Url;
import com.atlwj.protocol.http.HttpClient;

public class DubboProtocol extends AbstractProtocol {
    @Override
    public void start(Url url) {
        new NettyServer().start(url.getHostname(),url.getPort());
    }

    @Override
    public String send(Url url, Invocation invocation) {
        return new HttpClient().send(url.getHostname(),url.getPort(),invocation);
    }
}
