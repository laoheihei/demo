package com.jdkstudy.java8.chapter5useofstream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author llc
 * @description
 * @date 2020/1/3 15:38
 */
public class Filter {
    public static void filterNum() {
        List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 4, 2, 4, 1, 5);
        List<Integer> collect = numbers.stream()
                .filter(integer -> integer % 2 == 0)
                .distinct()
                .collect(Collectors.toList());

        System.out.println(collect);
    }

    public static void filterCharacter() {
        String[] arrayOfWords = new String[]{"hello", "world", "Goodbye"};
        Stream<String> wordStream = Arrays.stream(arrayOfWords);
        /* !!wrong!! */
        List<Stream<String>> collect = wordStream.map(s -> s.split(""))
                .map(Arrays::stream)
                .distinct()
                .collect(Collectors.toList());

        Stream<String[]> stream = wordStream.map(s -> s.split(""));

        List<String> distinctChar = wordStream.map(s -> s.split(""))

                /* flatMap 将各个生成流扁平化为单个流：把一个流中的每一个值都转成另一个流，然后把所有的流连接起来成为一个流 */
                .flatMap(Arrays::stream)
                .distinct()
                .collect(Collectors.toList());

        System.out.println(distinctChar);
    }

    public static void getSquare() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> collect = numbers.stream()
                .map(integer -> integer * integer)
                .collect(Collectors.toList());

        System.out.println(collect);
    }

    public static void getPair() {
        List<Integer> leftElementList = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> rightElementList = Arrays.asList(6, 7);

        List<int[]> collect = leftElementList.stream()
                .flatMap(i -> rightElementList.stream().map(j -> new int[]{i, j}))
                .filter((int[] ints) -> (ints[0] + ints[1] % 3 == 0) )
                .collect(Collectors.toList());

        Stream<int[]> stream = leftElementList.stream()
                .flatMap(i -> rightElementList.stream().filter(j -> (i + j) % 3 == 0).map(j -> new int[]{i, j}));

    }


    public static void main(String[] args) {
        getSquare();
    }

}
