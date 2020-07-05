package com.atlwj.protocol.http;

import com.atlwj.framework.AbstractProtocol;
import com.atlwj.framework.Invocation;
import com.atlwj.framework.Url;

public class HttpProtocol extends AbstractProtocol {

    @Override
    public void start(Url url) {
         new HttpServer(url.getHostname(),url.getPort());
    }

    @Override
    public String send(Url url, Invocation invocation) {
        return new HttpClient().send(url.getHostname(),url.getPort(),invocation);
    }
}
