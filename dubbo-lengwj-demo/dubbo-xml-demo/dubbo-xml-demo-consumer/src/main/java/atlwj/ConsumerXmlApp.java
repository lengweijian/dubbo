package atlwj;

import HelloService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class ConsumerXmlApp {
    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("consumer-xml-application.xml");
        HelloService helloService = (HelloService) context.getBean("helloService");
        //这个对象其实是一个代理对象
        System.out.println(helloService.sayHello("lengweijian"));
        System.in.read();
    }
}
