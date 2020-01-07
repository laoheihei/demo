package com.jdkstudy.java8.preview.filter;

import java.nio.file.DirectoryStream;
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
    private static List<Apple> appleList = new ArrayList<>();

    public static List<Apple> filterApple(List<Apple> apples, Predicate<Apple> predicate) {
        return apples.stream().filter(predicate).collect(Collectors.toList());
    }

    /* 谓词复合从左向右确定优先级 */
    public static void test() {
        Predicate<Apple> redApple = (Apple apple) -> "red".equals(apple.getColor());
        Predicate<Apple> notRedApple = redApple.negate();
        Predicate<Apple> weightFitApple = (Apple apple) -> apple.getWeight() > 150;

        Predicate<Apple> or = redApple.and(weightFitApple).or(notRedApple);
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
