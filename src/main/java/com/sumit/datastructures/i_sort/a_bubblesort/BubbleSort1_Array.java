package com.sumit.datastructures.i_sort.a_bubblesort;

import java.util.Arrays;

public class BubbleSort1_Array {

    public static void main(String[] args) {
        int[] arr1 = {10, 30, 20, 50, 40};
        bubbleSortWithRecursion(arr1);
        System.out.println(Arrays.toString(arr1));

        int[] arr2 = {10, 20, 30, 40, 50};
        bubbleSortWithRecursion(arr2);
        System.out.println(Arrays.toString(arr2));

        int[] arr3 = {50, 40, 30, 20, 10};
        bubbleSortWithRecursion(arr3);
        System.out.println(Arrays.toString(arr3));

        int[] arr4 = {};
        bubbleSortWithRecursion(arr4);
        System.out.println(Arrays.toString(arr4));

        int[] arr5 = {10};
        bubbleSortWithRecursion(arr5);
        System.out.println(Arrays.toString(arr5));

        int[] arr6 = {-50, -440, 332, -990, 0};
        bubbleSortWithRecursion(arr6);
        System.out.println(Arrays.toString(arr6));

    }


    // Way-1 : using for loop
    // we are not returning the existing array because we will sort the existing array
    // because bubble sort comes under inplace sorting technique.
    public static void bubbleSort(int[] arr) {

        // iterate the entire array n-1 times
        for(int i = 0; i < arr.length-1; i++) {
            boolean isSwapped = false;
            // after each iteration the max element will come at the last respective index
            for (int j = 0; j < arr.length-1-i; j++) {
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    isSwapped = true;
                }
            }

            // if we did not swap for any particular value of i, then it means the array is already sorted now
            // therefore we can come out of the loop and finish the program.
            if(!isSwapped)
                break;
        }
    }


    // Way-2 : using recursion
    public static void bubbleSortWithRecursion(int[] arr) {
        if(arr == null || arr.length == 0)
            return;

        int i=0;
        int j=1;
        helper(arr, i, j);
    }

    private static void helper(int[] arr, int i, int j) {
        if(i == arr.length)
            return;

        // next iteration
        if(j == arr.length)
            helper(arr, i+1, 1);
        else {
            if(arr[j-1] > arr[j])
                swap(arr,j-1, j);

            helper(arr, i, j+1);
        }
    }

    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

}