package com.jdkstudy.java8.chapter5useofstream.reduce;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

/**
 * @author llc
 * @description
 * @date 2020/1/3 17:39
 */
public class Reduce {
    public static void reduce() {
        List<Integer> list = Arrays.asList(1, 23, 4, 34, 231);
        Integer reduce = list.stream().reduce(0, (x, y) -> x + y);
        System.out.println(reduce);

        Optional<Integer> reduce1 = list.stream().reduce(Integer::sum);
        if (reduce1.isPresent()) {
            System.out.println(reduce1.get());
        }
    }

    public static void main(String[] args) {
        join();
    }

    /* prefix-1,2,3-suffix */
    public static void join() {
        List<String> names = Arrays.asList("1", "2", "3");
        String collect = names.stream().distinct()
                .collect(Collectors.joining(",","prefix-", "-suffix"));

        System.out.println(collect);
    }

}
