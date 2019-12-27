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

    public static List<AppleFilter.Apple> redApples = new ArrayList<>();

    static {
        AppleFilter.Apple apple = new AppleFilter.Apple();
        apple.setColor("red");
        redApples.add(apple);
    }

    @Test
    public void filterApple() {
        List<AppleFilter.Apple> appleList = AppleFilter.filterApple(redApples, AppleFilter.Apple::isGreenApple);
        assertEquals(0, appleList.size());


        List<AppleFilter.Apple> apples = AppleFilter.filterApple(redApples, ((AppleFilter.Apple apple) -> "red".equals(apple.getColor())));
        assertEquals(1, apples.size());
    }


}