package com.streams;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InterviewStreams {

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1, 3, 2, 6, 5, 4);
        List<Integer> evenNumbers =
                numbers.stream().filter(i -> i % 2 == 0).toList();
        System.out.println(evenNumbers);

        int max =
                numbers.stream().max(Comparator.comparingInt(Integer::intValue)).get();
        System.out.println(max);

        int min =
                numbers.stream().max(Comparator.comparingInt(Integer::intValue).reversed()).get();
        System.out.println(min);

        List<Integer> sortedList =
                numbers.stream().sorted(Collections.reverseOrder()).skip(2).toList();

        System.out.println(sortedList);

        countWithPrefix();
        firstNonRepeatedCharacter();
        findDuplicate();
    }

    private static void findDuplicate() {

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 2, 5, 1);

        List<Integer> duplicate =
                numbers.stream()
                        .collect(Collectors.groupingBy(i -> i, Collectors.counting()))
                        .entrySet()
                        .stream()
                        .filter(value -> value.getValue() > 1)
                        .map(key -> key.getKey()).toList();

        System.out.println(duplicate);

    }

    private static void firstNonRepeatedCharacter() {
        System.out.println("firstNonRepeatedCharacter=======>");
        String input = "swiss";

        Map<String, Long> map =
                Stream.of(input.split(""))
                        .collect(Collectors.groupingBy(i -> i, LinkedHashMap::new, Collectors.counting()));

        System.out.println(map);

        String nonRepeated =
                map.entrySet()
                        .stream()
                        .filter(value -> value.getValue() == 1)
                        .map(Map.Entry::getKey).findFirst().get();

        System.out.println(nonRepeated);

        List<String> names = Arrays.asList("java", "stream", "api");
        List<String> upperCase =
                names.stream().map(String::toUpperCase).toList();
        System.out.println(upperCase);

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        int sum =
                numbers.stream().reduce(0, (a, b) -> a + b);

        System.out.println(sum);

        List<String> strings = Arrays.asList("Java", "StreamAPI", "Lambda");
        List<String> matches =
                strings.stream().filter(i -> i.contains("API")).toList();
        System.out.println(matches);


    }

    private static void countWithPrefix() {

        System.out.println("Count with prefix =====>>>>");
        List<String> names = Arrays.asList("Alice", "Bob", "Annie", "Alex", "Charlie");

        Long countA =
                names.stream().filter(i -> i.startsWith("A")).count();

        System.out.println(countA);

        List<String> words = Arrays.asList("Stream", "API", "is", "powerful");

        String joinWords = words.stream().collect(Collectors.joining(" "));
        System.out.println(joinWords);
        System.out.println(words.stream().reduce("", (a, b) -> a + " " + b).trim());

        String longest =
                words.stream().max(Comparator.comparingInt(String::length)).get();
        System.out.println(longest);

        List<Integer> numbers = Arrays.asList(10, 20, 30, 40, 50);

        numbers.stream().collect(Collectors.toMap(word -> word, Integer::intValue));

        System.out.println(numbers.stream().collect(Collectors.toMap(word -> word, Integer::intValue)));
        double average = numbers.stream().mapToInt(i -> i).average().getAsDouble();
        System.out.println(average);

        List<String> names1 =
                Arrays.asList("Ameer", "John", "David", "Sam", "Alexander");

        System.out.println(names1.stream().filter(i -> i.length() > 5).toList());

        List<Integer> list =
                Arrays.asList(10, 15, 25, 35, 45, 55);

        int first = list.stream().filter(i -> i > 30).findFirst().get();
        System.out.println(first);

    }
}
