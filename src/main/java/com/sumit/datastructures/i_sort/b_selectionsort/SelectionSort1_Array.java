package com.sumit.datastructures.i_sort.b_selectionsort;

import java.util.Arrays;

public class SelectionSort1_Array {

    public static void main(String[] args) {
        int[] arr1 = {10, 30, 20, 50, 40};
        selectionSortWithRecursion(arr1);
        System.out.println(Arrays.toString(arr1));

        int[] arr2 = {10, 20, 30, 40, 50};
        selectionSortWithRecursion(arr2);
        System.out.println(Arrays.toString(arr2));

        int[] arr3 = {50, 40, 30, 20, 10};
        selectionSortWithRecursion(arr3);
        System.out.println(Arrays.toString(arr3));

        int[] arr4 = {};
        selectionSortWithRecursion(arr4);
        System.out.println(Arrays.toString(arr4));

        int[] arr5 = {10};
        selectionSortWithRecursion(arr5);
        System.out.println(Arrays.toString(arr5));

        int[] arr6 = {-50, -440, 332, -990, 0};
        selectionSortWithRecursion(arr6);
        System.out.println(Arrays.toString(arr6));

    }


    // Way-1 : using for loop
    private static void selectionSort(int[] arr){

        for (int i = 0; i <= arr.length-1; i++) {

            // find the max element and it's position
            int max = arr[0];       //max element
            int maxPosition = 0;    //position of max element

            int lastUnsortedPosition = arr.length-i-1;
            for (int j = 1; j <= lastUnsortedPosition; j++) {
                if(max < arr[j]){
                    max = arr[j];
                    maxPosition = j;
                }
            }

            // swap
            swap(arr, maxPosition, lastUnsortedPosition);
        }
    }


    // Way-2 : using recursion
    private static void selectionSortWithRecursion(int[] arr){
        if(arr == null || arr.length <= 1)
            return;

        int i = 0;  // to maintain the iteration count/ iteration index
        int j = 0;  // to find out the max element
        int maxElementIndex = 0;
        helper(arr, i, j, maxElementIndex);
    }

    private static void helper(int[] arr, int i, int j, int maxElementIndex) {
        if(i == arr.length-1)
            return;

        int lastUnsortedPosition = arr.length-i-1;

        // it means j has reached till last unsorted position and till now we will have our max element
        // therefor swap it and restart the recursion with j=0
        if(j > lastUnsortedPosition){
            swap(arr, maxElementIndex, lastUnsortedPosition);
            helper(arr, i+1, 0, 0);
        } else {
            if(arr[j] > arr[maxElementIndex]){
                maxElementIndex = j;
            }
            helper(arr, i, j+1, maxElementIndex);
        }
    }


    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}