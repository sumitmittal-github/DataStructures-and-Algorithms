package com.sumit.datastructures.h_search.b_binarysearch;

import java.util.Arrays;

public class BinarySearch7_PeakIndexMountainArray {

    // https://leetcode.com/problems/peak-index-in-a-mountain-array/description/

    public static void main(String[] args) {
                     // Index : 0  1  2  3  4  5  6  7  8   9  10
        int nums1[] = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 10, 5, 2};
        System.out.println("Mountain : " + Arrays.toString(nums1) + " => Peak index : " + peakIndexInMountainArray(nums1));

                     // Index : 0  1  2  3  4
        int nums2[] = new int[]{3, 5, 3, 2, 0};
        System.out.println("Mountain : " + Arrays.toString(nums2) + " => Peak index : " + peakIndexInMountainArray(nums2));

                     // Index : 0  1  2  3  4  5  6
        int nums3[] = new int[]{0, 1, 2, 3, 4, 5, 4};
        System.out.println("Mountain : " + Arrays.toString(nums3) + " => Peak index : " + peakIndexInMountainArray(nums3));
    }

    private static int peakIndexInMountainArray(int[] arr) {
        int start = 0, end = arr.length-1;

        while(start < end) {
            int mid = start + (end-start)/2;

            if(arr[mid] > arr[mid+1])
                end = mid;       // mid was bigger hence making end bigger
            else
                start = mid+1;   // mid+1 was bigger hence making start bigger
        }

        // in the end start == end because start and end both are trying to point to the maximum number in the array.
        return start;    // return end;    (both are valid)
    }

}