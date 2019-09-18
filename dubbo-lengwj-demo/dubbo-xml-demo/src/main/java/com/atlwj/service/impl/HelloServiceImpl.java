package impl;

import HelloService;

public class HelloServiceImpl implements HelloService {
    @Override
    public String say(String name) {
        return "hello %s !!!\n" + name;
    }
}
