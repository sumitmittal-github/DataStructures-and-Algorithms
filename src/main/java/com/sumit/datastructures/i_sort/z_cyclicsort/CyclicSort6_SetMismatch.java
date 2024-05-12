package com.sumit.datastructures.i_sort.z_cyclicsort;

import java.util.Arrays;

public class CyclicSort6_SetMismatch {

    // LeetCode-645 : https://leetcode.com/problems/set-mismatch/description/

    public static void main(String[] args) {
        System.out.println(Arrays.toString(findErrorNums(new int[]{1,2,2,4})));
        System.out.println(Arrays.toString(findErrorNums(new int[]{1,1})));
    }

    private static int[] findErrorNums(int[] nums) {
        // STEP-1 : cyclic sort the list
        cyclicSort(nums);

        // STEP-2 : iterate the list to find the duplicate where nums[i] != i+1
        // and index on which element is duplicate +1 will be the missing number
        for (int index = 0; index <= nums.length; index++) {
            if(nums[index] != index+1) {
                return new int[]{nums[index], index+1};
            }
        }
        return new int[]{-1, -1};
    }

    private static void cyclicSort(int[] nums){
        int i=0;
        while(i <= nums.length-1){
            if(nums[i] == i+1)
                i++;
            else {
                // element is duplicate hence skip
                if(nums[i] == nums[nums[i]-1])
                    i++;
                else
                    swap(nums, i, nums[i]-1);
            }
        }
    }

    private static void swap(int[] nums, int position1, int position2){
        int temp = nums[position1];
        nums[position1] = nums[position2];
        nums[position2] = temp;
    }

}