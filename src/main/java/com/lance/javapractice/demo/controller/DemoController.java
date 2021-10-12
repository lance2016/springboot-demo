package com.lance.javapractice.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: demo  DemoController
 * @description:
 * @author: flchen
 * @create: 2021-10-09 21:43
 **/

@RestController
@RequestMapping("/demo")
public class DemoController {

    @GetMapping("/login")
    public String hello(@RequestParam(name="username") String name, @RequestParam String password){
        // 数据库查询是否有这个用户名
        System.out.println("查询数据库...");
        // 有的话，判断密码是否正确
        // 正确则成功，否则失败
        if(name.equals("lance") && password.equals("123")){
            return "login success";
        }else{
            return "login failed";
        }
    }
}
