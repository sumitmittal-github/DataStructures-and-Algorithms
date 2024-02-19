package com.sumit.datastructures.search.b_binarysearch;

public class BinarySearch9_RotatedSortedArray {

    // https://leetcode.com/problems/search-in-rotated-sorted-array/description/

    public static void main(String[] args) {
        // Index :   0  1  2  3  4  5  6   7  8   9
        int[] arr = {4, 5, 6, 7, 8, 9, 10, 1, 2, 3};
        int target = 1;
        System.out.println("Target : "+target+" => Index : "+rotatedBinarySearch(arr, target));

    }

    private static int rotatedBinarySearch(int[] arr, int target){
        int index = -1;
        int pivot = findPivotIndex(arr);
        if(pivot == -1) {
            // if we did not find pivot element then it means the array was not rotated
            // then do plain binary search
            index = binarySearch(arr, target, 0, arr.length-1);
        }
        else {
            // if we found pivot means we have not 2 sorted arrays
            if(arr[pivot] == target)
                index = pivot;
            else if(target >= arr[0])
                index = binarySearch(arr, target, 0, pivot-1);
            else
                index = binarySearch(arr, target, pivot+1, arr.length-1);
        }
        return index;
    }



    // pivot we are referring the location where we rotated the array
    private static int findPivotIndex(int[] arr){
        int start=0;
        int end = arr.length-1;

        while(start <= end) {
            int mid = start + (end - start) / 2;

            // we added (mid < end) condition to handle exception when mid is pointing to last element and mid+1 will be ArrayIndexOutOfBound exception
            if (mid < end && arr[mid] > arr[mid + 1])
                return mid;

            // we added (mid > start) condition to handle exception when mid is 0th index and mid-1 will be ArrayIndexOutOfBound exception
            if (mid > start && arr[mid-1] > arr[mid])
                return mid-1;

            if (arr[mid] <= arr[start])
                end = mid-1;
            else
                start = mid+1;
        }
        return -1;
    }

    private static int binarySearch(int[] arr, int target, int start, int end) {
        while(start <= end){
            int mid = start + (end-start)/2;

            if(arr[mid] == target)
                return mid;
            else if(arr[mid] > target)
                end = mid-1;
            else
                start = mid+1;
        }
        return -1;
    }

}