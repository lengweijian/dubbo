package com.atlwj.protocol.http;

import com.alibaba.fastjson.JSONObject;
import com.atlwj.framework.Invocation;
import com.atlwj.provider.register.LocalRegister;
import org.apache.commons.io.IOUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class HttpServletHandler {
    public void handler(HttpServletRequest req, HttpServletResponse resp){
        // 请求处理
        try {
            Invocation invocation = JSONObject.parseObject(req.getInputStream(), Invocation.class);
            Class clazz = LocalRegister.get(invocation.getInterfaceName());
            Method method = clazz.getMethod(invocation.getMethodName(), invocation.getParamTypes());
            String result = (String) method.invoke(clazz.newInstance(),invocation.getParams());
            System.out.println("tomcat: ....." + result);
            IOUtils.write(result,resp.getOutputStream());
        } catch (IOException | NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }
}
