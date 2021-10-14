package com.lance.javapractice.demo.lance.proxy;

import java.lang.reflect.Proxy;

/**
 * @program: demo  JdkProxyFactory
 * @description:
 * @author: flchen
 * @create: 2021-10-14 16:52
 **/

public class JdkProxyFactory {
    public static Object getProxy(Object target){
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new MyInvocationHandler(target));
    }
}
