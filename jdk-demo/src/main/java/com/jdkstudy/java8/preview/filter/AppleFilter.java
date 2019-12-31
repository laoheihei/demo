package com.jdkstudy.java8.preview.filter;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author llc
 * @description
 * @date 2019/12/23 11:45
 */
public class AppleFilter {
    public static List<Apple> filterApple(List<Apple> apples, Predicate<Apple> predicate) {
        return apples.stream().filter(predicate).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        ArrayList<Apple> apples = new ArrayList<>();
        List<Apple> collect = apples.parallelStream().filter(apple -> apple.getWeight() > 150 && "green".equals(apple.getColor())).collect(Collectors.toList());

        Apple a = new Apple();
        if ("green".equals(a.getColor())) {
            System.out.println("绿了");
        } else {
            System.out.println("红了");
        }
    }

}
