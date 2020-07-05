import com.extadaptpr.service.impl.DubboSpiImpl;
import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.extension.ExtensionLoader;
import org.apache.dubbo.demo.sdi.DubboSpi;

import java.util.List;

/**
 * TODO
 *
 * @author lengweijian
 * @version 1.0
 * @date 2020-07-05 22:56
 */
public class DubboSpiTest {
    public static void main(String[] args) {
//        URL url = URL.valueOf("xxxx://qwewrwr/rtyryr?dubbo.spi=dubbpspi02");
        DubboSpi adaptiveExtension = ExtensionLoader.getExtensionLoader(DubboSpi.class).getAdaptiveExtension();
        String s = adaptiveExtension.dubboSpiM2(URL.valueOf("sss://sss/sss?dubbospi"));
        System.out.println(s);

    }
}
