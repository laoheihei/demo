package com.jdkstudy.java8.chapter4introductionofstream;

import java.util.List;
import java.util.stream.Collectors;

import static com.jdkstudy.java8.chapter4introductionofstream.Dish.*;

/**
 * @author llc
 * @description
 * @date 2020/1/3 15:19
 */
public class DishFilter {
    public static List<String> getThreeHighCaloricDishNames() {
        List<String> collect = menu.stream()
                .filter(dish -> dish.getCalories() > 300)
                .map(Dish::getName)
                .limit(3)
                .collect(Collectors.toList());
        return collect;
    }

    public static List<String> showDetailOfGetThreeHighCaloricDishNames() {
        List<String> collect = menu.stream()
                .filter(dish -> {
                    System.out.println("filtering: " + dish.getName());
                    return dish.getCalories() > 300;
                })
                .map(dish -> {
                    System.out.println("mapping: " + dish.getName());
                    return dish.getName();
                })
                /* limit处进行了短路处理，即只处理stream提供的前3个元素 */
                .limit(3)
                .collect(Collectors.toList());
        return collect;
    }
}
