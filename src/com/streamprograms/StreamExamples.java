package com.streamprograms;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamExamples {

    public static void main(String[] args) {
        countEachCharacter();
        findAnagrams();
        missingMultiple();
        streamNumbers();
        splitNumbers();
        checkPalindrome();

    }

    private static void checkPalindrome() {

    }

    private static void splitNumbers() {

        List<Object> numbers = Arrays.asList(1, 2, 3, "a", "b", "@");
        System.out.println(numbers.stream().filter(Integer.class::isInstance).
                map(Integer.class::cast).toList()
                .stream().reduce(0, Integer::sum));

        System.out.println(numbers.stream().filter(String.class::isInstance).map(String.class::cast)
                .toList());


    }

    private static void streamNumbers() {
        int[] arr = {1, 3, 5, 6, 2};
        List<Integer> listArr = Arrays.asList(1, 3, 5, 6, 2);
        System.out.println(Arrays.stream(arr).max().getAsInt());
        System.out.println("secondMax " + listArr.stream().sorted(Collections.reverseOrder()).skip(1).findFirst().get());
        System.out.println(listArr.stream().max(Comparator.comparingInt(Integer::intValue)).get());
        System.out.println(listArr.stream().map(n -> n * 2).toList());
    }


    private static void missingMultiple() {
        int[] arr = {1, 2, 3, 5, 7};
        Set<Integer> set = Arrays.stream(arr).boxed().collect(Collectors.toSet());
        System.out.println(IntStream.rangeClosed(1, arr.length + 2).filter(i -> !set.contains(i)).boxed().toList());

        int[] singleArray = {1, 2, 3, 5};

        int actual = Arrays.stream(singleArray).sum();
        int expected = IntStream.rangeClosed(1, singleArray.length + 1).sum();
        System.out.println(expected - actual);


    }

    private static void findAnagrams() {

        String s1 = "silent";
        String s2 = "listen";
        System.out.println(Stream.of(s1.split("")).sorted().collect(Collectors.joining())
                .equals(Stream.of(s2.split("")).sorted().collect(Collectors.joining())));

        List<String> anagrams = Arrays.asList
                ("silent", "listen", "act", "cat", "help", "pal");

        Map<String, List<String>> anagramList =
                anagrams.stream().collect(Collectors.groupingBy(word -> {
                    char[] c = word.toCharArray();
                    Arrays.sort(c);
                    return new String(c);
                }));
        System.out.println(anagramList);

        List<List<String>> anagram =
                anagramList.values().stream().filter(group -> group.size() > 1).toList();

        System.out.println(anagram);

        List<String> anagramsLists =
                anagram.stream().flatMap(List::stream).toList();
        System.out.println(anagramsLists);

    }

    private static void countEachCharacter() {

        String input = "java spring boot";

        Map<String, Long> map =
                Stream.of(input.split(""))
                        .filter(i -> !i.isBlank())
                        .collect(Collectors.groupingBy(i -> i, Collectors.counting()));
        System.out.println(map);

        List<String> values = Arrays.asList("ameer", "john", "ameer", "sharuk");
        System.out.println(values.stream().collect(Collectors.groupingBy(i -> i, Collectors.counting())));

        List<Integer> intValues = Arrays.asList(1, 2, 3, 4, 1, 3);
        System.out.println(intValues.stream().collect(Collectors.groupingBy(i -> i, Collectors.counting())));

        List<String> duplicate =
                Stream.of(input.split(""))
                        .filter(i -> !i.isBlank())
                        .collect(Collectors.groupingBy(i -> i, Collectors.counting()))
                        .entrySet().stream().filter(value -> value.getValue() > 1)
                        .map(key -> key.getKey()).toList();
        System.out.println(duplicate);

        String nonRepeated =
                Stream.of(input.split(""))
                        .filter(i -> !i.isBlank())
                        .collect(Collectors.groupingBy(i -> i, LinkedHashMap::new, Collectors.counting()))
                        .entrySet().stream().filter(value -> value.getValue() == 1)
                        .map(key -> key.getKey()).findFirst().get();
        System.out.println(nonRepeated);

        Stream.of(input.split(""))
                .filter(i -> !i.isBlank())
                .collect(Collectors.groupingBy(i -> i, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .forEach(entry -> System.out.print(entry.getKey() + "" + entry.getValue()));

        Stream.of(input.split(""))
                .filter(i -> !i.isBlank())
                .collect(Collectors.groupingBy(i -> i, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .forEach(entry -> System.out.print(entry.getKey() + "" + entry.getValue()));

        System.out.println();

        String repeated = Stream.of(input.split(""))
                .filter(i -> !i.isBlank())
                .collect(Collectors.groupingBy(i -> i, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .map(key -> key.getKey().repeat(key.getValue().intValue()))
                .collect(Collectors.joining());

        System.out.println(repeated);

        String reverse = Stream.of(input.split("")).reduce((a, b) -> b + a).get();
        System.out.println(reverse);

        System.out.println("builder " + Arrays.stream(input.split(" ")).map(i -> new StringBuilder(i).reverse().toString()).collect(Collectors.joining()));

    }
}
