package com.jdkstudy.java8.chapter3composite.lambda;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author llc
 * @description
 * @date 2020/1/6 16:49
 */
public class FunctionLearning {
    public static void main(String[] args) {
        Set<Float> collect = Arrays.asList(1, 2, 3, 4, 5).stream().map((Integer i) -> i.floatValue()).collect(Collectors.toSet());
        System.out.println(collect);
    }
}
