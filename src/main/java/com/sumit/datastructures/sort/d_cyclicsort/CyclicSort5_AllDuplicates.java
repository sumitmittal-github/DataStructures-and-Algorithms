package com.sumit.datastructures.sort.d_cyclicsort;

import java.util.ArrayList;
import java.util.List;

public class CyclicSort5_AllDuplicates {

    // Leet code : https://leetcode.com/problems/find-all-duplicates-in-an-array/description/

    public static void main(String[] args) {
        System.out.println(findDuplicates(new int[]{4,3,2,2,3,1}));
        System.out.println(findDuplicates(new int[]{1,1,2}));
        System.out.println(findDuplicates(new int[]{1}));
    }

    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> list = new ArrayList<>();

        // STEP-1 : sort the array
        cyclicSort(nums);

        // STEP-2 : all the elements on wrong index are the duplicates
        for(int i = 0; i <= nums.length-1; i++ ){
            if(nums[i] != i+1)
                list.add(nums[i]);
        }

        return list;
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

    private static void swap(int[] arr, int position1, int position2) {
        int temp = arr[position1];
        arr[position1] = arr[position2];
        arr[position2] = temp;
    }

}