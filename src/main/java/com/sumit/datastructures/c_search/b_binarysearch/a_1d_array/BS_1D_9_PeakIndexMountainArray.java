package com.sumit.datastructures.c_search.b_binarysearch.a_1d_array;

import java.util.Arrays;

public class BS_1D_9_PeakIndexMountainArray {

    // LeetCode-852 : https://leetcode.com/problems/peak-index-in-a-mountain-array/description/


    // Approach-1 : taught by College Wallah : BEST and easiest approach
    public int peakIndexInMountainArray_1(int[] arr) {
        int start = 0, end = arr.length - 1;
        int possibleAns = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] < arr[mid + 1]) {
                possibleAns = mid + 1;
                start = mid + 1;
            } else
                end = mid - 1;
        }
        return possibleAns;
    }


    // Approach-2 : taught by Kunal Kushwaha : a bit hard to understand
    public int peakIndexInMountainArray_2(int[] arr) {
        int start = 0, end = arr.length-1;

        while(start < end) {
            int mid = start + (end-start)/2;

            if(arr[mid] < arr[mid+1])
                start = mid+1;   // mid+1 was bigger hence making start bigger
            else
                end = mid;       // mid was bigger hence making end bigger
        }

        // in the end start == end because start and end both are trying to point to the maximum number in the array.
        return start;    // return end;    (both are valid)
    }


    public static void main(String[] args) {
        BS_1D_9_PeakIndexMountainArray obj = new BS_1D_9_PeakIndexMountainArray();


                     // Index : 0  1  2  3  4  5  6  7  8   9  10
        int nums1[] = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 10, 5, 2};
        System.out.println("Mountain : " + Arrays.toString(nums1) + " => Peak index : " + obj.peakIndexInMountainArray_1(nums1));
        System.out.println("Mountain : " + Arrays.toString(nums1) + " => Peak index : " + obj.peakIndexInMountainArray_2(nums1));
        System.out.println();

                     // Index : 0  1  2  3  4
        int nums2[] = new int[]{3, 5, 3, 2, 0};
        System.out.println("Mountain : " + Arrays.toString(nums2) + " => Peak index : " + obj.peakIndexInMountainArray_1(nums2));
        System.out.println("Mountain : " + Arrays.toString(nums2) + " => Peak index : " + obj.peakIndexInMountainArray_2(nums2));
        System.out.println();

                     // Index : 0  1  2  3  4  5  6
        int nums3[] = new int[]{0, 1, 2, 3, 4, 5, 4};
        System.out.println("Mountain : " + Arrays.toString(nums3) + " => Peak index : " + obj.peakIndexInMountainArray_1(nums3));
        System.out.println("Mountain : " + Arrays.toString(nums3) + " => Peak index : " + obj.peakIndexInMountainArray_2(nums3));
        System.out.println();
    }



}