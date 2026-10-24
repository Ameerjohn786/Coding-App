package com.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SetTwo {

    public static void main(String[] args) {
        findDuplicateElements();
        findLongestString();
    }

    private static void findLongestString() {

        List<String> names = Arrays.asList(
                "Java",
                "SpringBoot",
                "Kafka",
                "Microservices",
                "Docker");

        String longestString = names.stream().max(Comparator.comparingInt(String::length)).get();
        System.out.println(longestString);

        List<String> sortingLongestString =
                names.stream().sorted((i, j) -> i.length() > j.length() ? 1 : -1).toList();

        System.out.println(sortingLongestString);
    }

    private static void findDuplicateElements() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 2, 5, 3, 6, 1);

        Map<Integer, Long> map =
                list.stream().collect(Collectors.groupingBy(i -> i, Collectors.counting()));

        List<Integer> duplicate =
                map.entrySet()
                        .stream()
                        .filter(value -> value.getValue() > 1)
                        .map(key -> key.getKey())
                        .toList();
        System.out.println(duplicate);

        List<Integer> uniqueElements =
                map.entrySet()
                        .stream()
                        .filter(value -> value.getValue() == 1)
                        .map(key -> key.getKey())
                        .toList();
        System.out.println(uniqueElements);


        List<Integer> distinct =
                list.stream().distinct().toList();

        System.out.println(distinct);
    }
}
