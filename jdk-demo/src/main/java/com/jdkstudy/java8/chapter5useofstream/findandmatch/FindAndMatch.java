package com.jdkstudy.java8.chapter5useofstream.findandmatch;

import com.jdkstudy.java8.chapter4introductionofstream.Dish;

import java.util.Optional;

import static com.jdkstudy.java8.chapter4introductionofstream.Dish.*;
/**
 * @author llc
 * @description
 * @date 2020/1/3 16:42
 */
public class FindAndMatch {
    // 匹配
    /* anyMatch、allMatch、noneMatch都是短路操作 */

    /* anyMatch返回一个Boolean  是一个终端操作 */
    public static void anyMatch() {
        if (menu.stream().anyMatch(Dish::isVegetarian)) {
            System.out.println("the menu is (somewhat) vegetarian friendly!");
        }
    }

    public static void allMatch() {
        boolean isHealthy = menu.stream().allMatch(dish -> dish.getCalories() < 1000);
    }

    // 查找
    public static void findAny() {
        Optional<Dish> any = menu.stream()
                .filter(dish -> dish.isVegetarian())
                .findAny();
    }

}
