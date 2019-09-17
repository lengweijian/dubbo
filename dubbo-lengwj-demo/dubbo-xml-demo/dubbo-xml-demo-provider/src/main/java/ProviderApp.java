import org.apache.dubbo.rpc.RpcContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * 服务提供者
 */
public class ProviderApp {

    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext ioc = new ClassPathXmlApplicationContext("classpath:provider.xml");
        ioc.start();
        System.out.println(RpcContext.getServerContext().getLocalAddressString() + "服务已经提供");
        System.in.read();
    }
}
