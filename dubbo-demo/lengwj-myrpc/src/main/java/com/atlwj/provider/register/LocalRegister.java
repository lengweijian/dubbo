package com.atlwj.provider.register;

import java.util.HashMap;
import java.util.Map;

/**
 * 本地注册
 * @author lengweijian
 */

public class LocalRegister {

    /** k:v   接口名:接口ImplClass */
    private static Map<String,Class> map = new HashMap<>();

    public static void regist(String interfaceName,Class implClass){
        map.put(interfaceName,implClass);
    }

    public static Class get(String interfaceName){
        return map.get(interfaceName);
    }
}
