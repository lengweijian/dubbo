package impl;

import DemoService;

public class DemoServiceImpl_02 implements DemoService {
    @Override
    public void sayHi(String msg) {
        System.out.println("hello !!" + msg + "DemoServiceImpl_02.....");
        return ;
    }
}
