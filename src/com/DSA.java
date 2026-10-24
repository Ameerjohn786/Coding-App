package com;


public class DSA {

    public static void main(String[] args) {

        int[] arr = {1, 3, 5, 7, 1};
        int key = 3;
        findIndex(arr, key);
    }

    private static void findIndex(int[] arr, int key) {

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                System.out.println(arr[i]);
            }
        }
    }
}
