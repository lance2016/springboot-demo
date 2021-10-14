package com.lance.javapractice.demo.lance.proxy.cglib;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @program: demo  MyMethodInterceptor
 * @description:
 * @author: flchen
 * @create: 2021-10-14 17:59
 **/

public class MyMethodInterceptor implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("before method "+method.getName() + "");
        Object result = methodProxy.invokeSuper(o, objects);
        System.out.println("after method "+ method.getName() + "");
        return result;
    }
}
