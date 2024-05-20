package com.sumit.datastructures.h_search.b_binarysearch.a_1d_array;

import java.util.Arrays;

public class BS_1D_9_PeakIndexMountainArray2 {

    // LeetCode-162 : https://leetcode.com/problems/find-peak-element/description/


    public int findPeakElement(int[] arr) {
        int start=0, end = arr.length-1;
        while(start <= end) {
            int mid = start + (end-start)/2;

            if(  (mid == 0 || arr[mid] > arr[mid-1]) && (mid == arr.length-1 || arr[mid] > arr[mid+1])  )
                return mid;

            if(arr[mid] < arr[mid+1])   start = mid+1;
            else                        end = mid-1;
        }
        return 0;
    }



    public static void main(String[] args) {
        BS_1D_9_PeakIndexMountainArray2 obj = new BS_1D_9_PeakIndexMountainArray2();

                     // Index : 0  1  2  3  4  5  6  7  8   9  10
        int nums1[] = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 10, 5, 2};
        System.out.println("Mountain : " + Arrays.toString(nums1) + " => Peak index : " + obj.findPeakElement(nums1));
        System.out.println();

                     // Index : 0  1  2  3  4
        int nums2[] = new int[]{3, 5, 3, 2, 0};
        System.out.println("Mountain : " + Arrays.toString(nums2) + " => Peak index : " + obj.findPeakElement(nums2));
        System.out.println();

                     // Index : 0  1  2  3  4  5  6
        int nums3[] = new int[]{0, 1, 2, 3, 4, 5, 4};
        System.out.println("Mountain : " + Arrays.toString(nums3) + " => Peak index : " + obj.findPeakElement(nums3));
        System.out.println();

                     // Index : 0  1  2  3
        int nums4[] = new int[]{1, 2, 3, 1};
        System.out.println("Mountain : " + Arrays.toString(nums4) + " => Peak index : " + obj.findPeakElement(nums4));
        System.out.println();

                     // Index : 0  1  2  3  4  5  6
        int nums5[] = new int[]{1, 2, 1, 3, 5, 6, 4};
        System.out.println("Mountain : " + Arrays.toString(nums5) + " => Peak index : " + obj.findPeakElement(nums5));
        System.out.println();
    }

}