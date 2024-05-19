package com.sumit.datastructures.h_search.b_binarysearch.a_1d_array;

public class BS_1D_11_RotatedSortedArray_PivotIndex {


    // LeetCode-153 : https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/description/

    // Question : in a rotated sorted array find the pivot index (index of smallest element).
    public int rotatedSortedArray_pivotIndex(int[] arr){
        int start=0, end = arr.length-1;
        int possibleAns = -1;   //pivotIndex

        while(start <= end){
            int mid = start + (end-start)/2;

            if(arr[mid] <= arr[arr.length-1]){
                possibleAns = mid;
                end = mid-1;
            } else
                start = mid+1;
        }
        return possibleAns;
    }

    // Question : in a rotated sorted array find the smallest element.
    public int rotatedSortedArray_minElement(int[] arr){
        int start = 0, end = arr.length - 1;
        int possibleAns = Integer.MAX_VALUE;

        while(start <= end){
            int mid = start + (end-start)/2;
            if(arr[mid] <= arr[end]){
                if(arr[mid] < possibleAns)   possibleAns = arr[mid];
                end = mid-1;
            } else
                start = mid+1;
        }
        return possibleAns;
    }



    public static void main(String[] args) {
        BS_1D_11_RotatedSortedArray_PivotIndex obj = new BS_1D_11_RotatedSortedArray_PivotIndex();

        System.out.println(obj.rotatedSortedArray_pivotIndex(new int[]{4, 5, 6, 7, 0, 1, 2}));
        System.out.println(obj.rotatedSortedArray_pivotIndex(new int[]{4, 5, 6, 7, 0, 1}));
        System.out.println(obj.rotatedSortedArray_pivotIndex(new int[]{4, 5, 6, 7, 0}));
        System.out.println(obj.rotatedSortedArray_pivotIndex(new int[]{4, 5, 6, 7}));
    }

}