package com.sumit.datastructures.arrays.others;

import java.util.Arrays;

public class ArrayFromPermutation {

    // https://leetcode.com/problems/build-array-from-permutation/description/

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
