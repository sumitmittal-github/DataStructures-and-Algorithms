package com.sumit.datastructures.search.b_binarysearch;

import java.util.Arrays;

public class BinarySearch11_RotatedSortedArrayRotationCount {

    // Logic : Rotation count = pivot index +1
    // Ex :     Index    :   0   1   2   3  4  5   6
    //          int[] arr = {14, 20, 26, 1, 6, 11, 14};
    // Here rotation count is = 3 and pivot index = 2

    public static void main(String[] args) {
        int[] arr1 = {4, 5, 6, 7, 8, 9, 10, 12, 23, 3};
        System.out.println("Arr : "+ Arrays.toString(arr1)+" => Rotation Count : "+rotationCount(arr1));

        int[] arr2 = {1, 3, 4};
        System.out.println("Arr : "+ Arrays.toString(arr2)+" => Rotation Count : "+rotationCount(arr2));

        int[] arr3 = {11, 3, 4};
        System.out.println("Arr : "+ Arrays.toString(arr3)+" => Rotation Count : "+rotationCount(arr3));

        int[] arr4 = {11, 33, 44, 55, 6, 7, 10};
        System.out.println("Arr : "+ Arrays.toString(arr4)+" => Rotation Count : "+rotationCount(arr4));

    }

    public static int rotationCount(int[] arr){
        int pivotIndex = pivotIndex(arr);
        int rotationCount = pivotIndex+1;
        return rotationCount;
    }

    private static int pivotIndex(int[] arr){
        int start=0;
        int end = arr.length-1;

        while(start <= end) {
            int mid = start + (end-start)/2;

            // we added (mid < end) condition to handle exception when mid is pointing to last element and mid+1 will be ArrayIndexOutOfBound exception
            if (mid < end && arr[mid] > arr[mid + 1])
                return mid;

            // we added (mid > start) condition to handle exception when mid is 0th index and mid-1 will be ArrayIndexOutOfBound exception
            if (mid > start && arr[mid-1] > arr[mid])
                return mid-1;

            if(arr[mid] <= arr[start])
                end = mid-1;
            else
                start = mid+1;
        }
        return -1;
    }



}