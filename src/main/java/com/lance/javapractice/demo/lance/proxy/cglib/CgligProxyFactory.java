package com.lance.javapractice.demo.lance.proxy.cglib;

import net.sf.cglib.proxy.Enhancer;

/**
 * @program: demo  CgligProxyFactory
 * @description:
 * @author: flchen
 * @create: 2021-10-14 18:02
 **/

public class CgligProxyFactory {

    public static Object getProxy(Class<?> clazz) {
        Enhancer enhancer = new Enhancer();
        enhancer.setClassLoader(clazz.getClassLoader());
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(new MyMethodInterceptor());
        return enhancer.create();
    }
}
