package com.sumit.datastructures.d_sort.questions;

import java.util.Arrays;

public class Sort_Q4_Segregate {

    // Question : Given an array of positive and negative integers, segregate them in linear time and constant space.
    // The output should print all negative numbers, followed by all positive numbers.
    // input  = {19, -20, 7, -4, -13, 11, -5, 3}
    // Output = {-20, -4, -13, -5, 7, 11, 19, 3}

    public void segregate_1(int[] arr) {
        int firstPositiveIndex = -1;
        for(int i=0; i<arr.length; i++) {
            if (arr[i] >= 0 && firstPositiveIndex == -1) firstPositiveIndex = i;

            if (arr[i] < 0 && firstPositiveIndex != -1) {
                swap(arr, i, firstPositiveIndex);
                firstPositiveIndex += 1;
            }
        }
    }

    public void segregate_2(int[] arr) {
        int left = 0;
        int right = arr.length-1;
        while(left < right) {

            while(arr[left] < 0)    left++;
            while(arr[right] >= 0)    right--;

            if(left < right)
                swap(arr, left++, right--);
        }
    }



    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public static void main(String[] args) {
        Sort_Q4_Segregate obj = new Sort_Q4_Segregate();

        int[] arr1 = {19, -20, 7, -4, -13, 11, -5, 3};
        obj.segregate_1(arr1);
        System.out.println(Arrays.toString(arr1));

        int[] arr2 = {19, -20, 7, -4, -13, 11, -5, 3};
        obj.segregate_2(arr2);
        System.out.println(Arrays.toString(arr2));
    }

}