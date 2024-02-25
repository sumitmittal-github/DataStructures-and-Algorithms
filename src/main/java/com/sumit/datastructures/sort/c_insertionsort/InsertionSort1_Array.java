package com.sumit.datastructures.sort.c_insertionsort;

import java.util.Arrays;

public class InsertionSort1_Array {

    public static void main(String[] args) {
        int[] arr1 = {10, 30, 20, 50, 40};
        insertionSort(arr1);
        System.out.println(Arrays.toString(arr1));

        int[] arr2 = {10, 20, 30, 40, 50};
        insertionSort(arr2);
        System.out.println(Arrays.toString(arr2));

        int[] arr3 = {50, 40, 30, 20, 10};
        insertionSort(arr3);
        System.out.println(Arrays.toString(arr3));

        int[] arr4 = {};
        insertionSort(arr4);
        System.out.println(Arrays.toString(arr4));

        int[] arr5 = {10};
        insertionSort(arr5);
        System.out.println(Arrays.toString(arr5));

        int[] arr6 = {-50, -440, 332, -990, 0};
        insertionSort(arr6);
        System.out.println(Arrays.toString(arr6));
    }

    private static void insertionSort(int[] arr) {

        for (int i = 0; i <= arr.length-2; i++) {

            for (int j = i+1; j >= 1; j--) {
                // if previous element is bigger than current element, only than swap the elements
                // else LHS array is already sorted. therefore break the inner loop.
                if(arr[j-1] > arr[j])
                    swap(arr, j-1, j);
                else
                    break;
            }
        }
    }

    private static void swap(int[] arr, int index1, int index2){
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

}