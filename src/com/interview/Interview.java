package com.interview;

import java.util.HashSet;
import java.util.Set;

public class Interview {

    public static void main(String[] args) {

        stringExamples();
        countConsecutiveChar();
        findSubstring();

    }

    private static void stringExamples() {
        String s = "Ameer";
        String s1 = "Ameer";
        s1.concat("John");
        String s3 = new String("Ameer");
        String s4 = new String("Ameer");
        System.out.println(s.equals(s3));
        System.out.println(s == s3);
        System.out.println(s1);
        System.out.println(s + 10 + 10);
        System.out.println(10 + 10 + s);
        System.out.println("Hi"+s3.equals(s4));

    }

    private static void findSubstring() {

        String input = "abcbcabc";
        StringBuilder sb = new StringBuilder();
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < input.length(); i++) {
            if (set.contains(input.charAt(i))) {
                break;
            } else {
                set.add(input.charAt(i));
                sb.append(input.charAt(i));
            }
        }
        System.out.println(sb.toString());

    }


    private static void countConsecutiveChar() {

        String input = "aaaaebbccddddaa";
        int count = 1;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < input.length(); i++) {

            if (input.charAt(i) == input.charAt(i - 1)) {
                count++;
            } else {
                sb.append(count).append(input.charAt(i - 1));
                count = 1;
            }
        }
        sb.append(count).append(input.charAt(input.length() - 1));
        System.out.println(sb.toString());
    }
}
