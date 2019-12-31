package com.jdkstudy.java8.preview.filter;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author llc
 * @description
 * @date 2019/12/23 11:51
 */
public class AppleFilterTest {

    public static List<Apple> redApples = new ArrayList<>();

    static {
        Apple apple = new Apple();
        apple.setColor("red");
        redApples.add(apple);
    }

    @Test
    public void filterApple() {
        List<Apple> appleList = AppleFilter.filterApple(redApples, Apple::isGreenApple);
        assertEquals(0, appleList.size());


        List<Apple> apples = AppleFilter.filterApple(redApples, ((Apple apple) -> "red".equals(apple.getColor())));
        assertEquals(1, apples.size());
    }


}