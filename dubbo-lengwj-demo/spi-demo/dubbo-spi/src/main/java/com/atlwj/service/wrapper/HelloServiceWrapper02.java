package wrapper;

import DemoService;

/**
 * 扩展实现类包装类01
 */
public class HelloServiceWrapper02 implements DemoService {

    private DemoService demoService;

    public HelloServiceWrapper02(DemoService demoService) {
        this.demoService = demoService;
    }


    @Override
    public void sayHi(String name) {
        System.out.println("before02...");

        // 真正的逻辑实现
        demoService.sayHi(name);

        System.out.println("after02...");

    }
}
