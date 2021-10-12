package com.lance.javapractice.demo.lance;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Optional;

/**
 * @program: demo  OptionalTest
 * @description: 测试Java8 Optional特性
 * @author: flchen
 * @create: 2021-10-12 16:34
 **/

public class OptionalTest {

    public static void main(String[] args) {
        User user = new User();
        user.setPassword("123");
        user.setUsername(null);
        User user2 = null;
        String name  = Optional.ofNullable(user).map(User::getUsername).orElse("匿名");
        String name2  = Optional.ofNullable(user2).map(User::getUsername).orElse("匿名");
        System.out.println(name);
        System.out.println(name2);
    }
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class User{
    String username;
    String password;
}
