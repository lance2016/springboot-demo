package com.lance.javapractice.demo.lance.collection;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @program: demo  TestMap
 * @description:
 * @author: flchen
 * @create: 2021-10-13 10:14
 **/

public class TestMap {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("DataIO", "");
        map.put("de", null);
        Map.Entry<String, String> entry = map.entrySet().stream().filter(x -> null == x.getValue()).findFirst().orElse(null);
        System.out.println(entry.getKey());
    }
}
