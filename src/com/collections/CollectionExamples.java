package com.collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class CollectionExamples {


    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>();
        Thread t = new Thread(() -> {

            map.put(1, "Ameer");
            map.put(2, "john");
            map.put(3, "Sharuk");
            map.put(4, "khan");
            System.out.println(map);
        });

        t.start();
        Thread t1 = new Thread(() -> {

            map.put(1, "Ameer");
            map.put(2, "john");
            map.put(3, "Sharuk");
            map.put(4, "khan");
            System.out.println(map);
        });
        t1.start();
    }
}
