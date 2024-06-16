package com.sumit.datastructures.e_arrays.a_1DArray;

import java.util.Arrays;

public class Array1D_8_RotateArray {

    // LeetCode-189 : https://leetcode.com/problems/rotate-array/description/


    // Not a good approach : because taking extra space
    public int[] rotate_approach1(int[] nums, int k) {
        if(k <= 0 || nums.length == 1)
            return nums;

        // ex: if length = 4 and we want to rotate 10 times then we can only rotate 2 times.
        if(k > nums.length)
            k = k % nums.length;

        int[] arr = new int[nums.length];

        for(int i=0; i<nums.length; i++){
            int index = (i+k) % nums.length;
            arr[index] = nums[i];
        }
        return arr;
    }


    // Better approach : because without extra space and also modifying the existing array
    public void rotate_approach2(int[] nums, int k) {
        if (k <= 0 || nums.length == 1)
            return;

        // ex: if length = 4 and we want to rotate 10 times then we can only rotate 2 times.
        if (k > nums.length)
            k = k % nums.length;


        // STEP-1 : reverse part-1 and part-2 of the array
        //          part-1 starts from 0
        //          part-2 starts from length-k
        int part2StartIndex = nums.length - k;
        reverse(nums, 0, part2StartIndex - 1);
        reverse(nums, part2StartIndex, nums.length - 1);


        // STEP-2 : reverse entire array
        reverse(nums, 0, nums.length - 1);
    }

    public void reverse(int[] arr, int startIndex, int endIndex) {
        while (startIndex < endIndex) {
            int temp = arr[startIndex];
            arr[startIndex] = arr[endIndex];
            arr[endIndex] = temp;
            startIndex++;
            endIndex--;
        }
    }
    public static void main(String[] args) {
        Array1D_8_RotateArray obj = new Array1D_8_RotateArray();
        int[] nums = {1,2,3,4,5,6,7};

        // Approach-1
        System.out.println("Before : ");
        System.out.println(Arrays.toString(nums));
        int[] ans = obj.rotate_approach1(nums, 3);
        System.out.println("After : ");
        System.out.println(Arrays.toString(ans));


        // Approach-2
        System.out.println("Before : ");
        System.out.println(Arrays.toString(nums));
        obj.rotate_approach2(nums, 3);
        System.out.println("After : ");
        System.out.println(Arrays.toString(nums));
    }



}
