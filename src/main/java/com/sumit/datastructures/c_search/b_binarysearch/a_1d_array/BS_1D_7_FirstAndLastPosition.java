package com.sumit.datastructures.c_search.b_binarysearch.a_1d_array;

import java.util.Arrays;

public class BS_1D_7_FirstAndLastPosition {

    // LeetCode-34 : https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/

    public static void main(String[] args) {

        int[] nums1 = {5,7,7,8,8,10};
        int target1 = 8;
        System.out.println("Target : " + target1 + ", Array : " + Arrays.toString(nums1) + " => " + Arrays.toString(searchRange(nums1, target1)));

        int[] nums2 = {5,7,7,8,8,10};
        int target2 = 6;
        System.out.println("Target : " + target2 + ", Array : " + Arrays.toString(nums2) + " => " + Arrays.toString(searchRange(nums2, target2)));

        int[] nums3 = {5,7,7,7,7,10};
        int target3 = 7;
        System.out.println("Target : " + target3 + ", Array : " + Arrays.toString(nums3) + " => " + Arrays.toString(searchRange(nums3, target3)));
    }

    private static int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};

        if(nums == null || nums.length == 0)
            return result;

        result[0] = searchPositionIndex(nums, target, true);
        // if array do not have the first occurrence then it means the target does not exist.
        // Therefor we do not need to search for last occurrence in the array again.
        if(result[0] != -1){
            result[1] = searchPositionIndex(nums, target, false);
        }
        return result;
    }

    private static int searchPositionIndex(int[] nums, int target, boolean findFirstOccurrence) {
        int start = 0;
        int end = nums.length - 1;
        int answer = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == target) {
                answer = mid;          // this is the possible answer
                // when we find the element in the array
                // then traverse on the left to find the first occurrence
                // and traverse on the right to find the last occurrence
                if (findFirstOccurrence)
                    end = mid - 1;
                else
                    start = mid + 1;
            } else if (nums[mid] < target)
                start = mid + 1;
            else
                end = mid - 1;
        }
        return answer;
    }

}