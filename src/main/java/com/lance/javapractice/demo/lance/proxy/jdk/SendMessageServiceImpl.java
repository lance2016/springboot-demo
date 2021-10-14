package com.lance.javapractice.demo.lance.proxy.jdk;

/**
 * @program: demo  SendMessageServiceImpl
 * @description:
 * @author: flchen
 * @create: 2021-10-14 16:48
 **/

public class SendMessageServiceImpl implements SendMessageService {
    @Override
    public void sendMessage() {
        System.out.println("send message");
    }
}
