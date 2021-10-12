package com.lance.javapractice.demo.lance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @program: demo  StreamTest
 * @description:
 * @author: flchen
 * @create: 2021-10-12 17:28
 **/

public class StreamTest {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<10;i++){
            list.add(new Random().nextInt(10));
        }
        Integer [] intArray = new Integer[]{1,3,5,2,4,6};

        // 1.Collections.stream()
        System.out.println("01");
        list.parallelStream().mapToInt(Integer::intValue).filter(i->i%2==0).forEach(x -> System.out.println("01_"+x));

        // 2.Arrays.stream()
        System.out.println("02");
        Arrays.stream(intArray).mapToInt(Integer::intValue).forEach(System.out::println);

        // 3.Stream.of()
        System.out.println("03");
        List<Integer> list2 = Arrays.stream(intArray).collect(Collectors.toList());
        Stream.of(intArray).forEach(System.out::print);
        Stream.of(list2).forEach(System.out::print);
    }
}
