package com.jdkstudy.java8.preview.filter;

import lombok.Data;

/**
 * @author llc
 * @description
 * @date 2019/12/31 15:28
 */
@Data
public class Apple {
    private String color;
    private double weight;

    public static boolean isGreenApple(Apple apple) {
        return "green".equals(apple.getColor());
    }

    public static boolean isHeavyApple(Apple apple) {
        return apple.getWeight() > 150;
    }
}
