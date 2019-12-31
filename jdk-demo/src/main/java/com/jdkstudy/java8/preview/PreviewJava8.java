package com.jdkstudy.java8.preview;

import com.jdkstudy.java8.preview.filter.Apple;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author llc
 * @description
 * @date 2019/12/23 11:44
 */
public class PreviewJava8 {
    public static void main(String[] args) {
        List<Apple> appleList = new ArrayList<>();
        appleList.sort(Comparator.comparing(Apple::getWeight));
    }
}
