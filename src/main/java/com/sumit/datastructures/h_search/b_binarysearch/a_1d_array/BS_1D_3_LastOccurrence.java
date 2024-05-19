package com.sumit.datastructures.h_search.b_binarysearch.a_1d_array;

public class BS_1D_3_LastOccurrence {

    // Question : find the last occurrence of a given target in a sorted array.

    int lastOccurrence(int[] arr, int target){
        int start = 0;
        int end = arr.length-1;

        int lastOccurrence = -1;
        while(start <= end) {
            int mid = start + (end-start)/2;

            if(arr[mid] == target){
                lastOccurrence = mid;
                start = mid+1;
            }
            else if(arr[mid]  < target)
                start = mid+1;
            else
                end = mid-1;
        }
        return lastOccurrence;
    }



    public static void main(String[] args) {
        BS_1D_3_LastOccurrence obj = new BS_1D_3_LastOccurrence();

        // indexes   0  1  2  3  4  5  6  7  8  9
        int[] arr = {2, 5, 5, 5, 6, 6, 8, 9, 9, 9};
        System.out.println("Target : 1  => Index : "+obj.lastOccurrence(arr, 1));
        System.out.println("Target : 2  => Index : "+obj.lastOccurrence(arr, 2));
        System.out.println("Target : 3  => Index : "+obj.lastOccurrence(arr, 3));
        System.out.println("Target : 4  => Index : "+obj.lastOccurrence(arr, 4));
        System.out.println("Target : 5  => Index : "+obj.lastOccurrence(arr, 5));
        System.out.println("Target : 6  => Index : "+obj.lastOccurrence(arr, 6));
        System.out.println("Target : 7  => Index : "+obj.lastOccurrence(arr, 7));
        System.out.println("Target : 8  => Index : "+obj.lastOccurrence(arr, 8));
        System.out.println("Target : 9  => Index : "+obj.lastOccurrence(arr, 9));
        System.out.println("Target : 10 => Index : "+obj.lastOccurrence(arr, 10));
    }

}