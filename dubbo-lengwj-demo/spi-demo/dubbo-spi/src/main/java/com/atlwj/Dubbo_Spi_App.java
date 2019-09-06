package com.atlwj;

import com.atlwj.service.ExtHelloService;
import org.apache.dubbo.common.extension.ExtensionLoader;

/**
 * dubbp spi :
 *      Dubbo 改进了 JDK 标准的 SPI 的以下问题：
 *          JDK 标准的 SPI 会一次性实例化扩展点所有实现，如果有扩展实现初始化很耗时，但如果没用上也加载，会很浪费资源。
 *          如果扩展点加载失败，连扩展点的名称都拿不到了。比如：JDK 标准的 ScriptEngine，通过 getName() 获取脚本类型的名称，但如果 RubyScriptEngine 因为所依赖的 jruby.jar 不存在，导致 RubyScriptEngine 类加载失败，这个失败原因被吃掉了，和 ruby 对应不起来，当用户执行 ruby 脚本时，会报不支持 ruby，而不是真正失败的原因。
 *          增加了对扩展点 IoC 和 AOP 的支持，一个扩展点可以直接 setter 注入其它扩展点。
 */
public class Dubbo_Spi_App {
    public static void main(String[] args) {
        ExtensionLoader<ExtHelloService> extensionLoader = ExtensionLoader.getExtensionLoader(ExtHelloService.class);
        extensionLoader.getExtension("ext01").say("lengwj");
    }
}
