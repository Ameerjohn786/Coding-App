package com.interview;

public class Pointers {

    public static void main(String[] args) {

        sumOfTwoUsingPointer();
        palindrome();
        moveZeros();

    }

    private static void moveZeros() {
        int[] arr = {0, 1, 0, 3, 12};
        int left = 0;
        int tmp = 0;
        int right = arr.length - 1;
        while (left < right) {
            if (arr[left] == 0) {
                arr[left] = arr[right];
                arr[right] = tmp;
                tmp = arr[left];
                left++;
            } else {

                right--;
            }
        }
        System.out.println(arr[tmp]);
    }

    private static void palindrome() {

        System.out.println("Palindrome ====>");
        String input = "madam";
        boolean isPalindrome = true;
        int left = 0;
        int right = input.length() - 1;
        while (left < right) {

            if (input.charAt(left) == input.charAt(right)) {
                left++;
                right--;
            } else {
                isPalindrome = false;
                break;
            }
        }
        System.out.println(isPalindrome);
    }

    private static void sumOfTwoUsingPointer() {

        System.out.println("Sum of 2 pointers====>");
        int[] arr = {2, 4, 5, 7, 11, 15};
        int target = 9;
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int sum = arr[left] + arr[right];
            if (sum == target) {
                System.out.println(arr[left] + " " + arr[right]);
                left++;
            } else if (sum > target) {
                right--;
            } else {
                left++;
            }
        }
    }
}
