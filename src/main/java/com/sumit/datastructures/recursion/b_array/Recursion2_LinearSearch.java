package com.sumit.datastructures.recursion.b_array;

public class Recursion2_LinearSearch {

    public static void main(String[] args) {
        int[] arr1 = {3, 2, 1, 18, 9};

        System.out.println(linearSearch(arr1, 3));
        System.out.println(linearSearchWithRecursion(arr1, 3));
        System.out.println(linearSearchWithRecursion2(arr1, 3));

        System.out.println(linearSearch(arr1, 0));
        System.out.println(linearSearchWithRecursion(arr1, 0));
        System.out.println(linearSearchWithRecursion2(arr1, 0));

        System.out.println(linearSearch(arr1, 9));
        System.out.println(linearSearchWithRecursion(arr1, 9));
        System.out.println(linearSearchWithRecursion2(arr1, 9));

        System.out.println(linearSearch(arr1, 999));
        System.out.println(linearSearchWithRecursion(arr1, 999));
        System.out.println(linearSearchWithRecursion2(arr1, 999));
    }


    // Way-1 : linear search
    private static int linearSearch(int[] arr, int target) {
        if(arr == null || arr.length == 0)
            return -1;

        for(int i=0; i< arr.length; i++) {
            if(arr[i] == target)
                return i;
        }
        return -1;
    }


    // Way-2 : linear search with recursion
    private static int linearSearchWithRecursion(int[] arr, int target) {
        if(arr == null || arr.length==0)
            return -1;

        return helper(arr, target, 0);
    }

    private static int helper(int[] arr, int target, int currentIndex) {
        if(currentIndex == arr.length)
            return -1;

        if(arr[currentIndex] == target)
            return currentIndex;

        return helper(arr, target, currentIndex+1);
    }

    // Way-3 : linear search with recursion and OR operator
    private static boolean linearSearchWithRecursion2(int[] arr, int target) {
        if(arr == null || arr.length==0)
            return false;

        return helper2(arr, target, 0);
    }

    private static boolean helper2(int[] arr, int target, int currentIndex) {
        if(currentIndex == arr.length)
            return false;

        return ((arr[currentIndex] == target) || helper2(arr, target, currentIndex+1));
    }
}