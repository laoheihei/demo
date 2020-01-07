package com.jdkstudy.java8.chapter3composite;

import java.util.function.Function;

/**
 * @author llc
 * @description
 * @date 2020/1/3 15:00
 */
public class Letter {
    public static String addHeader(String text) {
        return "from llc: " + text;
    }

    public static String addFoooter(String text) {
        return text + "xixixi regards";
    }

    public static String checkSpelling(String text) {
        return text.replaceAll("labda", "lambda");
    }


    public static String pipeline(String text) {
        Function<String, String> addHeader = Letter::addHeader;
        Function<String, String> stringStringFunction = addHeader.andThen(Letter::checkSpelling)
                .andThen(Letter::addFoooter);
        String apply = stringStringFunction.apply(text);

        return apply;
    }
}

