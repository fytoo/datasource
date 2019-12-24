package com.example.datasource.poxy.cglib;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class ChinesePoxy implements MethodInterceptor {

    @Override
    public Object intercept(Object object, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        Object intercept = methodProxy.invokeSuper(object, args);
        System.out.println("-------- end ---------");
        return intercept;
    }
}