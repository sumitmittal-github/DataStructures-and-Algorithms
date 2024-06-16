package com.sumit.datastructures.c_search.b_binarysearch.a_1d_array;

import java.util.Arrays;

public class BS_1D_10_FindInMountainArray {

    // LeetCode-1095 : https://leetcode.com/problems/find-in-mountain-array/

    public static void main(String[] args) {

                     // Index : 0  1   2  3  4   5   6   7   8    9   10  11
        int nums1[] = new int[]{0, 10, 3, 8, 14, 22, 26, 47, 110, 51, 26, 10};
        int target1 = 110;
        System.out.println("Target : " + target1 + ", Mountain : " + Arrays.toString(nums1) + " => index : " + findInMountainArray(nums1, target1));
    }

    private static int findInMountainArray(int[] mountainArr, int target) {
        // STEP-1 : find the peak of the mountain
        int peak = findPeakIndex(mountainArr);

        // STEP-2 : first search in left mountain
        int index = binarySearch(mountainArr, target, 0, peak, true);
        if(index == -1){
            // STEP-3 : if not found only then search in right mountain
            index = binarySearch(mountainArr, target, peak+1, mountainArr.length-1, false);
        }

        return index;
    }


    private static int findPeakIndex(int[] mountainArr) {
        int start = 0;
        int end = mountainArr.length-1;

        while(start < end){
            int mid = start + (end-start)/2;
            if(mountainArr[mid] > mountainArr[mid+1])
                end = mid;
            else
                start = mid+1;
        }
        return start;
    }

    private static int binarySearch(int[] arr, int target, int start, int end, boolean inAscending) {
        while(start <= end){
            int mid = start + (end-start)/2;
            if(arr[mid] == target)
                return mid;

            if(inAscending){
                if(arr[mid] > target)
                    end = mid-1;
                else
                    start = mid+1;
            } else {
                if(arr[mid] > target)
                    start = mid+1;
                else
                    end = mid-1;
            }
        }
        return -1;
    }

}