package com.sumit.datastructures.i_sort.e_mergesort;

import java.util.Arrays;

public class Mergesort1_WithNewChildArrays {

    public static void main(String[] args) {
        int[] arr1 = {10, 30, 20, 50, 40};
        int[] ans1 = mergeSort(arr1);
        System.out.println(Arrays.toString(ans1));

        int[] arr2 = {10, 20, 30, 40, 50};
        int[] ans2 = mergeSort(arr2);
        System.out.println(Arrays.toString(ans2));

        int[] arr3 = {50, 40, 30, 20, 10};
        int[] ans3 = mergeSort(arr3);
        System.out.println(Arrays.toString(ans3));

        int[] arr4 = {};
        int[] ans4 = mergeSort(arr4);
        System.out.println(Arrays.toString(ans4));

        int[] arr5 = {10};
        int[] ans5 = mergeSort(arr5);
        System.out.println(Arrays.toString(ans5));

        int[] arr6 = {-50, -440, 332, -990, 0};
        int[] ans6 = mergeSort(arr6);
        System.out.println(Arrays.toString(ans6));
    }

    public static int[] mergeSort(int[] arr) {
        if(arr == null || arr.length <= 1)
            return arr;

        // divide the array in half
        int midIndex = arr.length/2;
        int[] left = mergeSort(Arrays.copyOfRange(arr, 0, midIndex));     // 0 -> midIndex-1 (because in copyOfRange TO is exclusive)
        int[] right = mergeSort(Arrays.copyOfRange(arr, midIndex, arr.length)); // midIndex -> length-1

        return merge(left, right);
    }

    private static int[] merge(int[] left, int[] right) {
        int[] mix = new int[left.length + right.length];

        int i=0;    // pointer of left array
        int j=0;    // pointer of right array
        int k=0;    // pointer of merged array

        while(i < left.length && j< right.length) {
            if(left[i] < right[j]){
                mix[k] = left[i];
                i++;
            } else {
                mix[k] = right[j];
                j++;
            }
            k++;
        }

        // it may be possible that one of the array is not complete. so copy the remaining elements
        while(i < left.length){
            mix[k] = left[i];
            i++;
            k++;
        }
        while(j < right.length){
            mix[k] = right[j];
            j++;
            k++;
        }

        return mix;
    }


}
