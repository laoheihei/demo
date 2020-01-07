package com.jdkstudy.java8.chapter3composite.lambda;

import java.util.Arrays;
import java.util.function.Consumer;

/**
 * @author llc
 * @description
 * @date 2020/1/6 16:47
 */
public class ConsumerLearning {
    public static void main(String[] args) {
        Consumer<Integer> integerConsumer = (Integer i) -> System.out.println(i);
        Arrays.asList(1, 2, 3, 4, 5).stream().forEach(integerConsumer);
    }
}
