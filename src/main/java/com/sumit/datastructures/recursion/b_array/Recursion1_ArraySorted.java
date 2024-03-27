package com.sumit.datastructures.recursion.b_array;

public class Recursion1_ArraySorted {

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 4, 8, 9, 12};
        System.out.println(isArraySorted(arr1));
        System.out.println(isArraySortedWithRecursion(arr1));

        int[] arr2 = {1, 2, 4, 8, 9, 12, -67};
        System.out.println(isArraySorted(arr2));
        System.out.println(isArraySortedWithRecursion(arr2));

        int[] arr3 = {};
        System.out.println(isArraySorted(arr3));
        System.out.println(isArraySortedWithRecursion(arr3));

        int[] arr4 = {3};
        System.out.println(isArraySorted(arr4));
        System.out.println(isArraySortedWithRecursion(arr4));

    }


    // Way-1 : General approach
    private static boolean isArraySorted(int[] arr){
        if(arr == null || arr.length == 0)
            return false;
        if(arr.length == 1)
            return true;

        // compare till length-2 elements, otherwise array index out of bound exception
        for(int i = 0; i < arr.length-1; i++) {
            if(arr[i] > arr[i+1])
                return false;
        }
        return true;
    }

    // Way-1 : with recursion
    private static boolean isArraySortedWithRecursion(int[] arr) {
        if(arr == null || arr.length == 0)
            return false;
        if(arr.length == 1)
            return true;
        return helper(arr, 0);
    }

    private static boolean helper(int[] arr, int currentIndex) {
        if(arr[currentIndex] > arr[currentIndex+1])
            return false;

        if(currentIndex == arr.length-2)
            return true;

        return helper(arr,currentIndex+1);
    }

}