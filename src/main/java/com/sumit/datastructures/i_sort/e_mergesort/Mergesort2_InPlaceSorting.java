package com.sumit.datastructures.i_sort.e_mergesort;

import java.util.Arrays;

public class Mergesort2_InPlaceSorting {

    public static void mergeSort(int[] arr) {
        if(arr == null || arr.length <= 1)
            return;

        mergeSort(arr, 0, arr.length-1);
    }


    public static void mergeSort(int[] arr, int start, int end) {
        if(end-start == 0)
            return;

        int mid = start + (end-start)/2;

        mergeSort(arr, start, mid);
        mergeSort(arr, mid+1, end);

        // merge the arrays
        merge(arr, start, mid, end);
    }

    private static void merge(int[] arr, int start, int mid, int end) {
        int[] arr1 = Arrays.copyOfRange(arr, start, mid+1);
        int[] arr2 = Arrays.copyOfRange(arr, mid+1, end+1);
        int index1 = 0, index2 = 0, indexMainArr = start;

        while(index1 < arr1.length && index2 < arr2.length) {
            if(arr1[index1] <= arr2[index2])        arr[indexMainArr++] = arr1[index1++];
            else                                    arr[indexMainArr++] = arr2[index2++];
        }

        while(index1 < arr1.length) {
            arr[indexMainArr++] = arr1[index1++];
        }
        while(index2 < arr2.length) {
            arr[indexMainArr++] = arr2[index2++];
        }
    }




    public static void main(String[] args) {
        int[] arr1 = {10, 30, 20, 50, 40};
        mergeSort(arr1);
        System.out.println(Arrays.toString(arr1));

        int[] arr2 = {10, 20, 30, 40, 50};
        mergeSort(arr2);
        System.out.println(Arrays.toString(arr2));

        int[] arr3 = {50, 40, 30, 20, 10};
        mergeSort(arr3);
        System.out.println(Arrays.toString(arr3));

        int[] arr4 = {};
        mergeSort(arr4);
        System.out.println(Arrays.toString(arr4));

        int[] arr5 = {10};
        mergeSort(arr5);
        System.out.println(Arrays.toString(arr5));

        int[] arr6 = {-50, -440, 332, -990, 0};
        mergeSort(arr6);
        System.out.println(Arrays.toString(arr6));
    }

}