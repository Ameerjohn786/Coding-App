package com.collections;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Group {

    public static void main(String[] args) {

        callMap();
        //      findEvenOrNot();
        List<String> values = Arrays.asList("a", "bbb", "ccc", "dd");
        Map<Integer, List<String>> map =
                values.stream().collect(Collectors.groupingBy(String::length));
        System.out.println(map);

        List<Integer> list1 = Arrays.asList(1, 4, 2, 6, 5);
        List<Integer> list2 = Arrays.asList(2, 9, 8, 4, 10);

        List<Integer> commonElements =
                list1.stream().filter(list2::contains).toList();
        System.out.println(commonElements);

        List<Integer> merged =
                Stream.concat(list1.stream(), list2.stream()).toList();
        System.out.println(merged);


        List<Map.Entry<Integer, Long>> countDuplicate = merged.stream().collect(Collectors.groupingBy(num -> num, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(value -> value.getValue() > 1)
                .toList();

        System.out.println(countDuplicate);

        List<Integer> removeDuplicate =
                merged.stream().distinct().toList();
        System.out.println(removeDuplicate);

        List<Integer> sortedList =
                removeDuplicate.stream().sorted().toList();
        System.out.println(sortedList);

        List<Integer> reverseSortedList =
                removeDuplicate.stream().sorted(Collections.reverseOrder()).toList();

        System.out.println(reverseSortedList);
        
    }

    private static void findEvenOrNot() {

        int[] arr = {12, 134, 10, 9};
        String value = String.valueOf(arr);
        String evenNumber = "";
        String oddNumber = "";

        for (int i = 0; i < value.length(); i++) {
            if (value.charAt(i) % 2 == 0) {
                evenNumber = value.charAt(i) + "evenNumber";
                System.out.println(evenNumber);
            } else {
                oddNumber = value.charAt(i) + "oddNumber";
                System.out.println(oddNumber);
            }
        }
    }

    private static void callMap() {

        String source = "bbacccddddd";

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < source.length(); i++) {
            if (map.get(source.charAt(i)) == null) {
                map.put(source.charAt(i), 1);
            } else {
                map.put(source.charAt(i), map.get(source.charAt(i)) + 1);
            }

        }
        System.out.println(map);
        int maxValue = Integer.MIN_VALUE;
        char maxKey = ' ';
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {

            if (entry.getValue() > maxValue) {
                maxValue = entry.getValue();
                maxKey = entry.getKey();
            }
        }

        String s = String.valueOf(maxKey + "" + maxValue);
        System.out.println(s);


    }
}
