package com.sumit.datastructures.i_sort.questions;

import java.util.Arrays;

public class Sort_Q1_MoveZeros {

    // LeetCode-283 : https://leetcode.com/problems/move-zeroes/description/


    // Approach-1 : iterate array once and copy all non-zeros on the front
    //              iterate remaining array and put zeros on remaining indexes
    // but beats only 5% users because O(n^2) complexity
    public void moveZeroes_1(int[] nums) {
        // STEP-1 : copy all non-zeros on the front
        int nonZeroIndex = 0;
        for(int num: nums){
            if(num != 0){
                nums[nonZeroIndex++] = num;
            }
        }

        // STEP-2 : put zeros on remaining indexes
        while(nonZeroIndex < nums.length){
            nums[nonZeroIndex++] = 0;
        }
    }


    // Approach-2 : Using Bubble sort
    // but beats only 5% users because O(n^2) complexity
    public void moveZeros_2(int [] arr){
        if(arr == null || arr.length<=1)
            return;

        for(int i=0; i<arr.length-1; i++) {
            for(int j=0; j<arr.length-1-i; j++) {
                if(arr[j] == 0 && arr[j+1] != 0)
                    swap(arr, j, j+1);
            }
        }
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public static void main(String[] args) {
        Sort_Q1_MoveZeros obj = new Sort_Q1_MoveZeros();
        int[] arr = {0, 5, 0, 3, 4};
        obj.moveZeroes_1(arr);
        System.out.println(Arrays.toString(arr));
    }

}