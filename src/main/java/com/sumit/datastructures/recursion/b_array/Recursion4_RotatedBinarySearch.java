package com.sumit.datastructures.recursion.b_array;

public class Recursion4_RotatedBinarySearch {

    public static void main(String[] args) {
        // Index :    0  1  2  3  4  5  6   7  8   9
        int[] arr0 = {4, 5, 6, 7, 8, 9, 10, 1, 2, 3};
        int target0 = 1;
        System.out.println("Target : "+target0+" => Index : "+rotatedBinarySearch(arr0, target0));
        System.out.println("Target : "+target0+" => Index : "+rotatedBinarySearchWithRecursion(arr0, target0, 0, arr0.length-1));

        // Index :    0  1  2  3  4  5  6   7  8   9
        int[] arr1 = {4, 5, 6, 7, 8, 9, 10, 1, 2, 3};
        int target1 = 4;
        System.out.println("Target : "+target1+" => Index : "+rotatedBinarySearch(arr1, target1));
        System.out.println("Target : "+target1+" => Index : "+rotatedBinarySearchWithRecursion(arr1, target1, 0, arr1.length-1));

        // Index :    0  1  2  3  4  5  6   7  8   9
        int[] arr2 = {4, 5, 6, 7, 8, 9, 10, 1, 2, 3};
        int target2 = 9;
        System.out.println("Target : "+target2+" => Index : "+rotatedBinarySearch(arr2, target2));
        System.out.println("Target : "+target2+" => Index : "+rotatedBinarySearchWithRecursion(arr2, target2, 0, arr2.length-1));

        // Index :    0  1  2  3  4  5  6   7   8   9
        int[] arr3 = {4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
        int target3 = 18;
        System.out.println("Target : "+target3+" => Index : "+rotatedBinarySearch(arr3, target3));
        System.out.println("Target : "+target3+" => Index : "+rotatedBinarySearchWithRecursion(arr3, target3, 0, arr3.length-1));

        // Index :    0   1  2  3  4  5  6   7   8   9
        int[] arr4 = {14, 5, 6, 7, 8, 9, 10, 11, 12, 13};
        int target4 = 18;
        System.out.println("Target : "+target4+" => Index : "+rotatedBinarySearch(arr4, target4));
        System.out.println("Target : "+target4+" => Index : "+rotatedBinarySearchWithRecursion(arr4, target4, 0, arr4.length-1));

        // Index :    0  1  2  3  4  5  6   7   8   9
        int[] arr5 = {4, 5, 6, 7, 8, 9, 10, 11, 12, 3};
        int target5 = 18;
        System.out.println("Target : "+target5+" => Index : "+rotatedBinarySearch(arr5, target5));
        System.out.println("Target : "+target5+" => Index : "+rotatedBinarySearchWithRecursion(arr5, target5, 0, arr5.length-1));

    }


    // Way-1 : binary search
    private static int rotatedBinarySearch(int[] arr, int target){

        // STEP-1 : find pivot element
        int pivotIndex = findPivotIndex(arr);

        // search in 2 sorted binary arrays
        if(pivotIndex == -1) // means array was sorted => search in entire array
            return binarySearch(arr, target, 0, arr.length-1);

        if(arr[pivotIndex] == target)
            return pivotIndex;

        int index = binarySearch(arr, target, 0, pivotIndex-1);
        if(index == -1)
            index = binarySearch(arr, target, pivotIndex+1, arr.length-1);
        return index;
    }

    private static int findPivotIndex(int[] arr) {
        int start = 0;
        int end = arr.length-1;

        while(start <= end) {
            int mid = start + (end-start)/2;

            if(mid < end &&     arr[mid] > arr[mid+1])
                return mid;
            if(arr[mid-1] > arr[mid])
                return mid-1;

            if(arr[mid] > arr[start])
                start = mid+1;
            else
                end = mid-1;

        }
        return -1;
    }

    private static int binarySearch(int[] arr, int target, int start, int end){
        while(start <= end) {
            int mid = start + (end-start)/2;

            if(arr[mid] == target)
                return mid;
            if(arr[mid] < target)
                start = mid+1;
            else
                end = mid-1;
        }
        return -1;
    }


    // Way-2 : binary search with recursion
    private static int rotatedBinarySearchWithRecursion(int[] arr, int target, int start, int end) {
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
}