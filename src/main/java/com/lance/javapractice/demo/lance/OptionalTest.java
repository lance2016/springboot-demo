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
        user.setUsername("h");
        user.setUser(new User("root", "password", null));
        User user2 = null;
        // 链路中只要有一个为null，都执行orElse中的内容
        String name = Optional.ofNullable(user).map(User::getUser).map(root -> root.getUsername()).orElse("匿名");
        String name2 = Optional.ofNullable(user2).map(User::getUsername).orElse("匿名");
        System.out.println(name);
        System.out.println(name2);
        User user3 = Optional.ofNullable(user).orElse(new User("默认名字", "有密码", null));
        System.out.println(user3.getUsername());
    }
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class User {
    String username;
    String password;
    User user;
}
