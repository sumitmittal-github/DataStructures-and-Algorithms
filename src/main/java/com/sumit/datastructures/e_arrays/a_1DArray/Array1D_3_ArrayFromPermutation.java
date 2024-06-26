package com.sumit.datastructures.e_arrays.a_1DArray;

import java.util.Arrays;

public class Array1D_3_ArrayFromPermutation {

    // LeetCode-1920 : https://leetcode.com/problems/build-array-from-permutation/description/

    public static void main(String[] args) {
        System.out.println(Arrays.toString(buildArray(new int[]{0,2,1,5,3,4})));        // Output: [0, 1, 2, 4, 5, 3]
        System.out.println(Arrays.toString(buildArray(new int[]{5,0,1,2,3,4})));        // Output: [4, 5, 0, 1, 2, 3]

    }

    public static int[] buildArray(int[] nums) {
        if(nums.length <= 1)
            return nums;

        int[] output = new int[nums.length];
        for(int i=0; i<nums.length; i++) {
            output[i] = nums[nums[i]];
        }

        return output;
    }


}
