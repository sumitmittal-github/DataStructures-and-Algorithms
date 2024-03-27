package com.sumit.datastructures.i_sort.e_mergesort;

import java.util.Arrays;

public class Mergesort2_InPlaceSorting {

    public static void main(String[] args) {
        int[] arr1 = {10, 30, 20, 50, 40};
        mergeSortInPlace(arr1);
        System.out.println(Arrays.toString(arr1));

        int[] arr2 = {10, 20, 30, 40, 50};
        mergeSortInPlace(arr2);
        System.out.println(Arrays.toString(arr2));

        int[] arr3 = {50, 40, 30, 20, 10};
        mergeSortInPlace(arr3);
        System.out.println(Arrays.toString(arr3));

        int[] arr4 = {};
        mergeSortInPlace(arr4);
        System.out.println(Arrays.toString(arr4));

        int[] arr5 = {10};
        mergeSortInPlace(arr5);
        System.out.println(Arrays.toString(arr5));

        int[] arr6 = {-50, -440, 332, -990, 0};
        mergeSortInPlace(arr6);
        System.out.println(Arrays.toString(arr6));
    }

    public static void mergeSortInPlace(int[] arr) {
        if(arr == null || arr.length <= 1)
            return;

        int startIndex = 0;
        int endIndex = arr.length-1;
        mergeSort(arr, startIndex, endIndex);
    }


    public static void mergeSort(int[] arr, int startIndex, int endIndex) {
        if(endIndex-startIndex == 0)
            return;

        // divide the array in half
        int midIndex = startIndex + (endIndex-startIndex)/2;
        mergeSort(arr, startIndex, midIndex);
        mergeSort(arr, midIndex+1, endIndex);

        merge(arr, startIndex, midIndex, endIndex);
    }

    private static void merge(int[] arr, int startIndex, int midIndex, int endIndex) {
        int[] mix = new int[endIndex-startIndex+1];

        int i=startIndex;    // pointer of left array
        int j=midIndex+1;    // pointer of right array
        int k=0;    // pointer of merged array

        while(i <= midIndex && j <= endIndex) {
            if(arr[i] < arr[j]){
                mix[k] = arr[i];
                i++;
            } else {
                mix[k] = arr[j];
                j++;
            }
            k++;
        }

        // it may be possible that one of the array is not complete. so copy the remaining elements
        while(i <= midIndex){
            mix[k] = arr[i];
            i++;
            k++;
        }
        while(j <= endIndex){
            mix[k] = arr[j];
            j++;
            k++;
        }

        // copy the answer from mix array to original array
        for (int l = 0; l < mix.length; l++) {
            arr[startIndex+l] = mix[l];
        }
    }

}