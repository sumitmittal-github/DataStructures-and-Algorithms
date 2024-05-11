package com.sumit.datastructures.i_sort.e_mergesort;

import java.util.Arrays;

public class Mergesort1_WithNewChildArrays {

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
        int index1 = 0, index2 = 0, indexMainArr = 0;

        int[] mix = new int[left.length + right.length];
        while(index1 < left.length && index2 < right.length) {
            if(left[index1] <= right[index2])       mix[indexMainArr++] = left[index1++];
            else                                    mix[indexMainArr++] = right[index2++];
        }

        while(index1 < left.length) {
            mix[indexMainArr++] = left[index1++];
        }
        while(index2 < right.length) {
            mix[indexMainArr++] = right[index2++];
        }

        return mix;
    }




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

}
