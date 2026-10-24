package com.interview;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapSort {

    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("Sharuk", 2);
        map.put("Ameer", 4);
        map.put("john", 1);
        map.put("Shaffin", 3);

        System.out.println(map);

        map.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .forEach(i ->
                        System.out.println(i.getKey() + " " + i.getValue()));

        System.out.println(map.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed()).toList());

        List<Map.Entry<String, Integer>> list = map.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed()).toList();

        System.out.println(list);
        map.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .findFirst().get();


        System.out.println(map.entrySet().stream()
                .max(Map.Entry.<String, Integer>comparingByValue())
                .map(i -> i.getKey() + i.getValue())
                .get());


        map.entrySet().stream()
                .max(Map.Entry.<String, Integer>comparingByValue()).get();
    }
}
