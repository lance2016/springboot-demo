package com.lance.javapractice.demo.lance.proxy.jdk;

/**
 * @program: demo  Main
 * @description:
 * @author: flchen
 * @create: 2021-10-14 16:54
 **/

public class Main {
    public static void main(String[] args) {
        SendMessageService sendMessageService = new SendMessageServiceImpl();
        SendMessageService service = (SendMessageService) JdkProxyFactory.getProxy(sendMessageService);
        service.sendMessage();
    }
}
