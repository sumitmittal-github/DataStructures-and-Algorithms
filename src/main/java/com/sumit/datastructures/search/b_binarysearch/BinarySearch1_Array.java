package com.sumit.datastructures.search.b_binarysearch;

public class BinarySearch1_Array {

    public static void main(String[] args) {
        // indexes   0  1  2  3   4   5   6   7
        int[] arr = {1, 3, 7, 13, 22, 90, 96, 101};
        int target = 96;
        System.out.println("Target : "+ target +" => Index : "+binarySearch(arr, 96));
    }

    // get the index of the element from a sorted (ascending) array
    private static int binarySearch(int[] arr, int targetElement){
        int startIndex = 0, midIndex = 0, endIndex = arr.length-1;

        while(startIndex <= endIndex){
            midIndex = (startIndex + endIndex) / 2;
            if(targetElement == arr[midIndex])
                return midIndex;
            else {
                if(targetElement < arr[midIndex])
                    endIndex = midIndex-1;
                else
                    startIndex = midIndex+1;
            }
        }
        return -1;
    }

}