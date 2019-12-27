package com.jdkstudy.java8.preview.filter;

import lombok.Data;

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

    @Data
    public static class Apple {
        private String color;
        private double weight;

        public static boolean isGreenApple(Apple apple) {
            return "green".equals(apple.getColor());
        }

        public static boolean isHeavyApple(Apple apple) {
            return apple.getWeight() > 150;
        }
    }
}
