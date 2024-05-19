package com.sumit.datastructures.h_search.b_binarysearch.a_1d_array;

import java.util.Arrays;

public class BS_1D_14_RotatedSortedArray_TargetWithDuplicates {

    // LeetCode-81 : https://leetcode.com/problems/search-in-rotated-sorted-array-ii/description/


    // Approach-1 : binary search : College Wallah approach
    // BEST and easiest approach
    public int rotatedBinarySearch_1(int[] arr, int target){
        int start=0;
        int end = arr.length-1;

        while(start <= end) {
            int mid = start + (end-start)/2;

            if(arr[mid] == target)
                return mid;

            // if mid != target and all 3 are equal then those elements are not required
            // hence skip these duplicates to reduce search space so that we can come to a place where
            // either mid <= end or start <= end so that we can identify which part is sorted
            if(  (arr[start] == arr[mid]) && (arr[mid] == arr[end])  ){
                start++;
                end--;
            }

            // array from mid to end is sorted
            else if(arr[mid] <= arr[end]) {
                if(arr[mid] < target && target <= arr[end])     start = mid+1;
                else                                            end = mid-1;
            }

            // array from start to mid is sorted
            else{
                if(arr[start] <= target && target < arr[mid])   end = mid-1;
                else                                            start = mid+1;
            }
        }
        return -1;
    }




    // Approach-2 : binary search : Kunal kushwaha approach
    public int rotatedBinarySearch_2(int[] arr, int target){
        int index = -1;
        int pivot = findPivotIndexWithDuplicates(arr);
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
    // Ex -    int[] arr = {4, 5, 6, 7, 8, 9, 10, 1, 2, 3};
    // here 10 is the pivot element, and it's index will be pivot index
    int findPivotIndexWithDuplicates(int[] arr){
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



            // if elements at start, middle and end are equal then just skip the duplicates
            if(arr[start] == arr[mid] && arr[mid] == arr[end]){
                // NOTE : what if these elements at start and end are pivots
                // check if start is pivot
                if(arr[start] > arr[start+1])
                    return start;
                // check if end is pivot
                if(arr[end-1] > arr[end])
                    return end-1;

                // skip the duplicates
                start++;
                end--;
            }
            // left side is sorted, so pivot should be in the right
            else if( (arr[start] < arr[mid])   ||   (arr[start] == arr[mid] && arr[mid] > arr[end])){
                start = mid+1;
            } else {
                end = mid-1;
            }
        }
        return -1;
    }

    int binarySearch(int[] arr, int target, int start, int end) {
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


    public static void main(String[] args) {
        BS_1D_14_RotatedSortedArray_TargetWithDuplicates obj = new BS_1D_14_RotatedSortedArray_TargetWithDuplicates();

        int[] arr1 = {0,0,0,1,1,1,2,0,0,0};
        int target1 = 2;
        System.out.println("Array : " + Arrays.toString(arr1) + ", Target : "+target1+" => Index : " + obj.rotatedBinarySearch_1(arr1, target1));
        System.out.println("Array : " + Arrays.toString(arr1) + ", Target : "+target1+" => Index : " + obj.rotatedBinarySearch_2(arr1, target1));


        int target2 = 1;
        System.out.println("Array : " + Arrays.toString(arr1) + ", Target : "+target2+" => Index : " + obj.rotatedBinarySearch_1(arr1, target2));
        System.out.println("Array : " + Arrays.toString(arr1) + ", Target : "+target2+" => Index : " + obj.rotatedBinarySearch_2(arr1, target2));


        int target3 = 3;
        System.out.println("Array : " + Arrays.toString(arr1) + ", Target : "+target3+" => Index : " + obj.rotatedBinarySearch_1(arr1, target3));
        System.out.println("Array : " + Arrays.toString(arr1) + ", Target : "+target3+" => Index : " + obj.rotatedBinarySearch_2(arr1, target3));


        int[] arr2 = {1,1,1,2,2,3,1};
        int target4 = 1;
        System.out.println("Array : " + Arrays.toString(arr2) + ", Target : "+target4+" => Index : " + obj.rotatedBinarySearch_1(arr2, target4));
        System.out.println("Array : " + Arrays.toString(arr2) + ", Target : "+target4+" => Index : " + obj.rotatedBinarySearch_2(arr2, target4));


        int target5 = 2;
        System.out.println("Array : " + Arrays.toString(arr2) + ", Target : "+target4+" => Index : " + obj.rotatedBinarySearch_1(arr2, target5));
        System.out.println("Array : " + Arrays.toString(arr2) + ", Target : "+target4+" => Index : " + obj.rotatedBinarySearch_2(arr2, target5));


        int target6 = 3;
        System.out.println("Array : " + Arrays.toString(arr2) + ", Target : "+target4+" => Index : " + obj.rotatedBinarySearch_1(arr2, target6));
        System.out.println("Array : " + Arrays.toString(arr2) + ", Target : "+target4+" => Index : " + obj.rotatedBinarySearch_2(arr2, target6));


        int target7 = 0;
        System.out.println("Array : " + Arrays.toString(arr2) + ", Target : "+target4+" => Index : " + obj.rotatedBinarySearch_1(arr2, target7));
        System.out.println("Array : " + Arrays.toString(arr2) + ", Target : "+target4+" => Index : " + obj.rotatedBinarySearch_2(arr2, target7));

    }

}