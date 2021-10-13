package com.lance.javapractice.demo.lance.base;

/**
 * @program: demo  BaseTest
 * @description:
 * @author: flchen
 * @create: 2021-10-12 22:45
 **/

public class BaseTest {
    public static void main(String[] args) {
        // 变量大小
        variableSize();
        //
    }


    /**
     * 各个数据类型存储大小,单位 bit     8 bits = 1 byte
     */
    private static void variableSize() {
        // Boolean  不确定，  理论上true和false 用 1，0表示就可以 ；   实际： 00000001， 00000000
        // 1 byte
        System.out.println("Byte: " + Byte.SIZE / 8);
        System.out.println("Byte MAX_VALUE:" + Byte.MAX_VALUE);
        System.out.println("Byte MIN_VALUE:" + Byte.MIN_VALUE);
        // 2 bytes
        System.out.println("Short: " + Short.SIZE / 8);
        System.out.println("Character: " + Character.SIZE / 8);
        // 4 bytes
        System.out.println("Integer: " + Integer.SIZE / 8);
        System.out.println("Float: " + Float.SIZE / 8);
        // 8 bytes
        System.out.println("Long: " + Long.SIZE / 8);
        System.out.println("Double: " + Double.SIZE / 8);
    }
}
