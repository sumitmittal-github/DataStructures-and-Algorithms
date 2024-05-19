package com.sumit.datastructures.h_search.b_binarysearch;

public class BinarySearch10_RotatedSortedArray_Target {

    // LeetCode-33 : https://leetcode.com/problems/search-in-rotated-sorted-array/description/

    // Note : It will only work if the array do not have the duplicate elements



    // Way-1 : binary search : College Wallah approach
    // BEST and easiest approach
    public int rotatedBinarySearch_1(int[] arr, int target){
        int start=0;
        int end = arr.length-1;

        while(start <= end) {
            int mid = start + (end-start)/2;

            if(arr[mid] == target)
                return mid;

            // array from mid to end is sorted
            if(arr[mid] < arr[end]) {
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





    // Way-2 : binary search : Kunal kushwaha approach
    public int rotatedBinarySearch_2(int[] arr, int target){
        int index = -1;

        // STEP-1 : find pivot element
        int pivot = findPivotIndex(arr);


        // STEP-2 : search in 2 sorted binary arrays
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
    private int findPivotIndex(int[] arr){
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

    private int binarySearch(int[] arr, int target, int start, int end) {
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





    // Way-3 : binary search with recursion
    private int rotatedBinarySearchWithRecursion(int[] arr, int target, int start, int end) {
        if(start > end)
            return -1;

        int mid = start + (end-start)/2;
        if(arr[mid] == target)
            return mid;
        if(mid < arr.length-1 && arr[mid+1] == target)
            return mid+1;
        if(mid > 0 && arr[mid-1] == target)
            return mid-1;

        if(arr[mid] > arr[start] ){
            if(target > arr[end])
                end = mid-1;
            else
                start = mid+1;
        } else {
            if(target > arr[mid])
                start = mid+1;
            else
                end = mid-1;
        }

        return rotatedBinarySearchWithRecursion(arr, target, start, end);
    }









    public static void main(String[] args) {
        BinarySearch10_RotatedSortedArray_Target obj = new BinarySearch10_RotatedSortedArray_Target();

        // Index :    0  1  2  3  4  5  6   7  8   9
        int[] arr0 = {4, 5, 6, 7, 8, 9, 10, 1, 2, 3};
        int target0 = 1;
        System.out.println("Target : "+target0+" => Index : "+obj.rotatedBinarySearch_1(arr0, target0));
        System.out.println("Target : "+target0+" => Index : "+obj.rotatedBinarySearch_2(arr0, target0));
        System.out.println("Target : "+target0+" => Index : "+obj.rotatedBinarySearchWithRecursion(arr0, target0, 0, arr0.length-1));
        System.out.println();

        // Index :    0  1  2  3  4  5  6   7  8   9
        int[] arr1 = {4, 5, 6, 7, 8, 9, 10, 1, 2, 3};
        int target1 = 4;
        System.out.println("Target : "+target1+" => Index : "+obj.rotatedBinarySearch_1(arr1, target1));
        System.out.println("Target : "+target1+" => Index : "+obj.rotatedBinarySearch_2(arr1, target1));
        System.out.println("Target : "+target1+" => Index : "+obj.rotatedBinarySearchWithRecursion(arr1, target1, 0, arr1.length-1));
        System.out.println();

        // Index :    0  1  2  3  4  5  6   7  8   9
        int[] arr2 = {4, 5, 6, 7, 8, 9, 10, 1, 2, 3};
        int target2 = 9;
        System.out.println("Target : "+target2+" => Index : "+obj.rotatedBinarySearch_1(arr2, target2));
        System.out.println("Target : "+target2+" => Index : "+obj.rotatedBinarySearch_2(arr2, target2));
        System.out.println("Target : "+target2+" => Index : "+obj.rotatedBinarySearchWithRecursion(arr2, target2, 0, arr2.length-1));
        System.out.println();

        // Index :    0  1  2  3  4  5  6   7   8   9
        int[] arr3 = {4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
        int target3 = 18;
        System.out.println("Target : "+target3+" => Index : "+obj.rotatedBinarySearch_1(arr3, target3));
        System.out.println("Target : "+target3+" => Index : "+obj.rotatedBinarySearch_2(arr3, target3));
        System.out.println("Target : "+target3+" => Index : "+obj.rotatedBinarySearchWithRecursion(arr3, target3, 0, arr3.length-1));
        System.out.println();

        // Index :    0   1  2  3  4  5  6   7   8   9
        int[] arr4 = {14, 5, 6, 7, 8, 9, 10, 11, 12, 13};
        int target4 = 18;
        System.out.println("Target : "+target4+" => Index : "+obj.rotatedBinarySearch_1(arr4, target4));
        System.out.println("Target : "+target4+" => Index : "+obj.rotatedBinarySearch_2(arr4, target4));
        System.out.println("Target : "+target4+" => Index : "+obj.rotatedBinarySearchWithRecursion(arr4, target4, 0, arr4.length-1));
        System.out.println();

        // Index :    0  1  2  3  4  5  6   7   8   9
        int[] arr5 = {4, 5, 6, 7, 8, 9, 10, 11, 12, 3};
        int target5 = 18;
        System.out.println("Target : "+target5+" => Index : "+obj.rotatedBinarySearch_1(arr5, target5));
        System.out.println("Target : "+target5+" => Index : "+obj.rotatedBinarySearch_2(arr5, target5));
        System.out.println("Target : "+target5+" => Index : "+obj.rotatedBinarySearchWithRecursion(arr5, target5, 0, arr5.length-1));
        System.out.println();
    }

}