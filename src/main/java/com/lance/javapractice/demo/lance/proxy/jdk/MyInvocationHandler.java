package com.lance.javapractice.demo.lance.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @program: demo  MyInvocationHandler
 * @description:
 * @author: flchen
 * @create: 2021-10-14 16:49
 **/

public class MyInvocationHandler implements InvocationHandler {
    private Object target;
    MyInvocationHandler(Object target){
        this.target = target;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before "+method.getName() + "");
        Object result = method.invoke(target, args);
        System.out.println("after "+method.getName() + "");
        return result;
    }
}
