package com.wiprocoding;

import java.util.LinkedHashMap;
import java.util.Map;

public class Codings {

    public static void main(String[] args) {
        Map<Character, Integer> map = new LinkedHashMap<>();
        String input = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        for (int i = 0; i < input.length(); i++) {
            map.put(input.charAt(i), i + 1);
        }

        System.out.println(map);

        System.out.println(map.entrySet().stream().filter(i -> i.getKey().equals("A")).toList());

       // map.entrySet();
    }
}
