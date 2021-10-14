package com.lance.javapractice.demo.lance.proxy.cglib;

/**
 * @program: demo  SendMessageService
 * @description:
 * @author: flchen
 * @create: 2021-10-14 16:48
 **/

public class SendMessageService {

    public String sendMessage(String message){
        String msg = "send message" + message;
        System.out.println("execute send"+msg);
        return msg;
    }

    // final修饰的类和方法，不能通过cglib动态代理，因为cglib是通过生成类的子类的方法实现
    public final void sendMes(){
        System.out.println("without param and return");
    }
}
