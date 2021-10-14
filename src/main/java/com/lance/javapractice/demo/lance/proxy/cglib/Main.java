package com.lance.javapractice.demo.lance.proxy.cglib;

/**
 * @program: demo  Main
 * @description:
 * @author: flchen
 * @create: 2021-10-14 18:01
 **/

public class Main {
    public static void main(String[] args) {
        SendMessageService service = (SendMessageService) CgligProxyFactory.getProxy(SendMessageService.class);
        service.sendMessage("lance");
        service.sendMes();
    }
}
