package com.sumit.datastructures.e_arrays.a_1DArray;

public class Array1D_4_ArraySorted {

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 4, 8, 9, 12};
        System.out.println(isArraySorted(arr1));
        System.out.println(isArraySortedWithRecursion(arr1));
        System.out.println(isArraySortedWithRecursion2(arr1));

        int[] arr2 = {1, 2, 4, 8, 9, 12, -67};
        System.out.println(isArraySorted(arr2));
        System.out.println(isArraySortedWithRecursion(arr2));
        System.out.println(isArraySortedWithRecursion2(arr2));

        int[] arr3 = {};
        System.out.println(isArraySorted(arr3));
        System.out.println(isArraySortedWithRecursion(arr3));
        System.out.println(isArraySortedWithRecursion2(arr3));

        int[] arr4 = {3};
        System.out.println(isArraySorted(arr4));
        System.out.println(isArraySortedWithRecursion(arr4));
        System.out.println(isArraySortedWithRecursion2(arr4));

    }


    // Approach-1 : General approach
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

    // Approach-2 : with recursion
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


    // Approach-3 : with recursion and AND operator
    private static boolean isArraySortedWithRecursion2(int[] arr) {
        if(arr == null || arr.length == 0)
            return false;
        if(arr.length == 1)
            return true;
        return helper2(arr, 0);
    }

    private static boolean helper2(int[] arr, int currentIndex) {
        if(currentIndex == arr.length-1)
            return true;

        return (arr[currentIndex] <= arr[currentIndex+1]) && helper2(arr,currentIndex+1);
    }
}