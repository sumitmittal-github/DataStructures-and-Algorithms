package com.sumit.datastructures.recursion.d_sorting;

import java.util.Arrays;

public class Sorting1_BubbleSort {

    public static void main(String[] args) {
        int[] arr1 = {10, 30, 20, 50, 40};
        bubbleSort(arr1);
        System.out.println(Arrays.toString(arr1));

        int[] arr2 = {10, 20, 30, 40, 50};
        bubbleSort(arr2);
        System.out.println(Arrays.toString(arr2));

        int[] arr3 = {50, 40, 30, 20, 10};
        bubbleSort(arr3);
        System.out.println(Arrays.toString(arr3));

        int[] arr4 = {};
        bubbleSort(arr4);
        System.out.println(Arrays.toString(arr4));

        int[] arr5 = {10};
        bubbleSort(arr5);
        System.out.println(Arrays.toString(arr5));

        int[] arr6 = {-50, -440, 332, -990, 0};
        bubbleSort(arr6);
        System.out.println(Arrays.toString(arr6));
    }

    private static void bubbleSort(int[] arr) {
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