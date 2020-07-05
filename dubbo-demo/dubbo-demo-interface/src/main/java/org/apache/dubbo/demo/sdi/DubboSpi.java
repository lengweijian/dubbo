package org.apache.dubbo.demo.sdi;

import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.extension.Adaptive;
import org.apache.dubbo.common.extension.SPI;

/**
 * TODO
 *
 * @author lengweijian
 * @version 1.0
 * @date 2020-07-05 22:53
 */
@SPI("dubbospi")
public interface DubboSpi {
    @Adaptive
    String dubboSpiM1(URL url);
    @Adaptive
    String dubboSpiM2(URL url);
}
