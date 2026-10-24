package com.streamprograms;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Technical {

    public static void main(String[] args) {
        swiftOnes();

    }

    private static void swiftOnes() {

        List<Integer> input = Arrays.asList(1, 2, 1, 3, 2);
        List<Integer> oneList = input.stream().filter(i -> i == 1).toList();
        List<Integer> nonOneList = input.stream().filter(i -> i != 1).toList();
        System.out.println(Stream.concat(oneList.stream(), nonOneList.stream()).toList());

        List<Integer> concatedList =
                Stream.concat(
                        input.stream().filter(i -> i == 1),
                        input.stream().filter(i -> i != 1)
                ).toList();

        System.out.println("Concated List" + concatedList);

        Map<Boolean, List<Integer>> partitionByOne = input.stream()
                .collect(Collectors.partitioningBy(i -> i == 1));

        List<Integer> getOnes = partitionByOne.get(false);
        List<Integer> nonOnes = partitionByOne.get(true);

        List<Integer> swiftedOnes =
                Stream.concat(getOnes.stream(), nonOnes.stream()).toList();

        System.out.println(swiftedOnes);

        List<Integer> list1 = List.of(1, 2, 3);
        List<Integer> list2 = List.of(4, 5, 6);
        List<Integer> list3 = List.of(7, 8, 9);

        List<List<Integer>> lists = List.of(list1, list2, list3);

        System.out.println(lists);
        List<Integer> result = lists.stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());

        System.out.println(result);


    }
}
