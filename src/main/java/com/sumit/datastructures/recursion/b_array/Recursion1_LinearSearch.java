package com.sumit.datastructures.recursion.b_array;

public class Recursion1_LinearSearch {

    public static void main(String[] args) {
        int[] arr1 = {3, 2, 1, 18, 9};

        System.out.println(linearSearch(arr1, 3));
        System.out.println(linearSearchWithRecursion(arr1, 3));

        System.out.println(linearSearch(arr1, 0));
        System.out.println(linearSearchWithRecursion(arr1, 0));

        System.out.println(linearSearch(arr1, 9));
        System.out.println(linearSearchWithRecursion(arr1, 9));

        System.out.println(linearSearch(arr1, 999));
        System.out.println(linearSearchWithRecursion(arr1, 999));
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
}