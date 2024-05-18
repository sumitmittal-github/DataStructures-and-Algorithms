package com.sumit.datastructures.h_search.b_binarysearch;

public class BinarySearch9_RotatedSortedArrayPivotIndex {


    // Question : in a rotated sorted array find the pivot index (index of smallest element).
    public int rotatedSortedArray_pivotIndex(int[] arr){
        int start=0, end = arr.length-1;
        int possibleAns = -1;   //pivotIndex

        while(start <= end){
            int mid = start + (end-start)/2;

            if(arr[mid] <= arr[arr.length-1]){
                possibleAns = arr[mid];
                end = mid-1;
            }
            else
                start = mid+1;
        }
        return possibleAns;
    }





    public static void main(String[] args) {
        BinarySearch9_RotatedSortedArrayPivotIndex obj = new BinarySearch9_RotatedSortedArrayPivotIndex();

        System.out.println(obj.rotatedSortedArray_pivotIndex(new int[]{4, 5, 6, 7, 0, 1, 2}));
        System.out.println(obj.rotatedSortedArray_pivotIndex(new int[]{4, 5, 6, 7, 0, 1}));
        System.out.println(obj.rotatedSortedArray_pivotIndex(new int[]{4, 5, 6, 7, 0}));
        System.out.println(obj.rotatedSortedArray_pivotIndex(new int[]{4, 5, 6, 7}));
    }

}