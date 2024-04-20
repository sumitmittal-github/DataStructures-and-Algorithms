package com.sumit.datastructures.i_sort.d_cyclicsort;

public class CyclicSort7_FirstMissingPositive {

    //LeetCode-41 : https://leetcode.com/problems/first-missing-positive/description/

    /**  We need to get the smallest positive, so we can skip the negative numbers
     */

    public static void main(String[] args) {
        CyclicSort7_FirstMissingPositive cs = new CyclicSort7_FirstMissingPositive();
/*
        System.out.println(cs.firstMissingPositive(new int[]{1,2,0}));
        System.out.println(cs.firstMissingPositive(new int[]{3,4,-1,1}));
        System.out.println(cs.firstMissingPositive(new int[]{7,8,9,11,12}));
        System.out.println(cs.firstMissingPositive(new int[]{3,4,2,1}));
*/
        System.out.println(cs.firstMissingPositive(new int[]{1,1}));
    }

    public int firstMissingPositive(int[] nums) {
        // STEP-1 : cyclic sort
        cyclicSort(nums);

        // STEP-2 : iterate through array and where nums[index] != index+1 is the answer
        for (int index = 0; index <= nums.length-1; index++) {
            if(nums[index] != index+1)
                return index+1;
        }

        // if there is no missing element in the array then last element + 1 will be the missing number
        return nums.length+1;
    }

    public static void cyclicSort(int[] nums){
        int i=0;
        while(i <= nums.length-1){
            if(nums[i] == i+1){
                i++;
            } else {
                // if value is <= 0 then we can skip them
                // if value is > N then we can skip them
                // if value is duplicate then we can skip them
                if(nums[i] <= 0 || nums[i] > nums.length || nums[i] == nums[nums[i]-1])
                    i++;
                else
                    swap(nums, i, nums[i]-1);
            }
        }
    }

    public static void swap(int[] nums, int position1, int position2){
        int temp = nums[position1];
        nums[position1] = nums[position2];
        nums[position2] = temp;
    }

}