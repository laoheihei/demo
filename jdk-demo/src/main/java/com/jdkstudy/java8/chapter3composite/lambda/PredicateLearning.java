package com.jdkstudy.java8.chapter3composite.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author llc
 * @description
 * @date 2020/1/6 16:43
 */
public class PredicateLearning {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        Predicate<String> nonEmptyStringPredicate = (String s) -> s.isEmpty();
        List<String> collect = list.stream().filter(nonEmptyStringPredicate).collect(Collectors.toList());
    }
}
