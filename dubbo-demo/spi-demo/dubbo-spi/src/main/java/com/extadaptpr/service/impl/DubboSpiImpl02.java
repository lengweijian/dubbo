package com.extadaptpr.service.impl;

import org.apache.dubbo.common.URL;
import org.apache.dubbo.demo.sdi.DubboSpi;

/**
 * TODO
 *
 * @author lengweijian
 * @version 1.0
 * @date 2020-07-05 22:55
 */
public class DubboSpiImpl02 implements DubboSpi {

    @Override
    public String dubboSpiM1(URL url) {
        return "DubboSpiImpl02...dubboSpiM1";
    }

    @Override
    public String dubboSpiM2(URL url) {
        return "DubboSpiImpl02...dubboSpiM2";
    }
}
