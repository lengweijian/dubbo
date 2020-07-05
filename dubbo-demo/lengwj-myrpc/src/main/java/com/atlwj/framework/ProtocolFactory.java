package com.atlwj.framework;

import com.atlwj.protocol.dubbo.DubboProtocol;
import com.atlwj.protocol.http.HttpProtocol;

public class ProtocolFactory {

    private static final String DUBBO_PROTOCOL = "dubbo";
    private static final String HTTP_PROTOCOL = "http";
    private static final String EMPTY_STR = "";
    private static String PROTOCOL_NAME = System.getProperty("protocolName");

    /**
     * 给大家一个疑问 ： 这样有什么不好？
     * @return
     */
    public static Protocol getProtocol() {
        // 工厂模式
        if (PROTOCOL_NAME == null || PROTOCOL_NAME.equals(EMPTY_STR)) {
            PROTOCOL_NAME = HTTP_PROTOCOL;
        }
        switch (PROTOCOL_NAME) {
            case HTTP_PROTOCOL:
                return new HttpProtocol();
            case DUBBO_PROTOCOL:
                return new DubboProtocol();
            default:
                break;
        }
        return new HttpProtocol();
    }
}
