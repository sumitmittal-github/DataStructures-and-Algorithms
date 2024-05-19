package com.sumit.datastructures.h_search.b_binarysearch.a_1d_array;

public class BS_1D_13_RotatedSortedArray_PivotIndexWithDuplicates {

    // LeetCode-154 : https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/description/

    public int findPivot_Min(int[] arr) {
        int start = 0, end = arr.length - 1;
        int possibleAns = Integer.MAX_VALUE;

        while(start <= end){
            int mid = start + (end-start)/2;

            // skip the duplicate elements
            // before skipping check if is the minimum element till now
            if(arr[start] == arr[mid] && arr[mid] == arr[end]){
                if(arr[mid] < possibleAns)
                    possibleAns = arr[mid];
                start++;
                end--;
            }

            // it means array from mid to end is sorted
            // min element is mid so now search in other part
            else if(arr[mid] <= arr[end]) {
                if(arr[mid] < possibleAns)
                    possibleAns = arr[mid];
                end = mid-1;
            }
            else
                start = mid+1;
        }
        return possibleAns;
    }



    public static void main(String[] args) {
        BS_1D_13_RotatedSortedArray_PivotIndexWithDuplicates obj = new BS_1D_13_RotatedSortedArray_PivotIndexWithDuplicates();

        System.out.println(obj.findPivot_Min(new int[]{2,2,2,0,1}));
        System.out.println(obj.findPivot_Min(new int[]{4, 5, 6, 7, 0, 1}));
        System.out.println(obj.findPivot_Min(new int[]{3,3,1,3}));
        System.out.println(obj.findPivot_Min(new int[]{4, 5, 6, 7}));
    }

}