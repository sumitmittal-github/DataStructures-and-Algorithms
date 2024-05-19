package com.sumit.datastructures.h_search.b_binarysearch.a_1d_array;

public class BS_1D_1_Array {

    public static void main(String[] args) {
        // indexes             0    1   2  3  4   5  6   7   8   9
        int[] ascendingArr = {-65, -12, 1, 3, 7, 13, 22, 90, 96, 101};
        System.out.println("Target : -99 => Index : "+binarySearch(ascendingArr, -99));
        System.out.println("Target : -65 => Index : "+binarySearch(ascendingArr, -65));
        System.out.println("Target : -55 => Index : "+binarySearch(ascendingArr, -55));
        System.out.println("Target : -12 => Index : "+binarySearch(ascendingArr, -12));
        System.out.println("Target : 0   => Index : "+binarySearch(ascendingArr, 0));
        System.out.println("Target : 1   => Index : "+binarySearch(ascendingArr, 1));
        System.out.println("Target : 2   => Index : "+binarySearch(ascendingArr, 2));
        System.out.println("Target : 3   => Index : "+binarySearch(ascendingArr, 3));
        System.out.println("Target : 5   => Index : "+binarySearch(ascendingArr, 5));
        System.out.println("Target : 7   => Index : "+binarySearch(ascendingArr, 7));
        System.out.println("Target : 9   => Index : "+binarySearch(ascendingArr, 9));
        System.out.println("Target : 13  => Index : "+binarySearch(ascendingArr, 13));
        System.out.println("Target : 14  => Index : "+binarySearch(ascendingArr, 14));
        System.out.println("Target : 22  => Index : "+binarySearch(ascendingArr, 22));
        System.out.println("Target : 50  => Index : "+binarySearch(ascendingArr, 50));
        System.out.println("Target : 90  => Index : "+binarySearch(ascendingArr, 90));
        System.out.println("Target : 95  => Index : "+binarySearch(ascendingArr, 95));
        System.out.println("Target : 96  => Index : "+binarySearch(ascendingArr, 96));
        System.out.println("Target : 100 => Index : "+binarySearch(ascendingArr, 100));
        System.out.println("Target : 101 => Index : "+binarySearch(ascendingArr, 101));
        System.out.println("Target : 200 => Index : "+binarySearch(ascendingArr, 200));
        System.out.println("--------------------------------------------------");

        // indexes             0    1   2   3   4   5  6  7   8    9
        int[] descendingArr = {101, 96, 90, 22, 13, 7, 3, 1, -12, -65};
        System.out.println("Target : 200 => Index : "+binarySearch(descendingArr, 200));
        System.out.println("Target : 101 => Index : "+binarySearch(descendingArr, 101));
        System.out.println("Target : 100 => Index : "+binarySearch(descendingArr, 100));
        System.out.println("Target : 96  => Index : "+binarySearch(descendingArr, 96));
        System.out.println("Target : 95  => Index : "+binarySearch(descendingArr, 95));
        System.out.println("Target : 90  => Index : "+binarySearch(descendingArr, 90));
        System.out.println("Target : 50  => Index : "+binarySearch(descendingArr, 50));
        System.out.println("Target : 22  => Index : "+binarySearch(descendingArr, 22));
        System.out.println("Target : 14  => Index : "+binarySearch(descendingArr, 14));
        System.out.println("Target : 13  => Index : "+binarySearch(descendingArr, 13));
        System.out.println("Target : 9   => Index : "+binarySearch(descendingArr, 9));
        System.out.println("Target : 7   => Index : "+binarySearch(descendingArr, 7));
        System.out.println("Target : 5   => Index : "+binarySearch(descendingArr, 5));
        System.out.println("Target : 3   => Index : "+binarySearch(descendingArr, 3));
        System.out.println("Target : 2   => Index : "+binarySearch(descendingArr, 2));
        System.out.println("Target : 1   => Index : "+binarySearch(descendingArr, 1));
        System.out.println("Target : 0   => Index : "+binarySearch(descendingArr, 0));
        System.out.println("Target : -12 => Index : "+binarySearch(descendingArr, -12));
        System.out.println("Target : -55 => Index : "+binarySearch(descendingArr, -55));
        System.out.println("Target : -65 => Index : "+binarySearch(descendingArr, -65));
        System.out.println("Target : -99 => Index : "+binarySearch(descendingArr, -99));
        System.out.println("--------------------------------------------------");
    }

    // get the index of the element from a sorted array
    private static int binarySearch(int[] arr, int targetElement){
        if(arr == null || arr.length == 0)
            return -1;

        if(arr.length == 1){
            if(arr[0] == targetElement)
                return 0;
            else
                return -1;
        }

        int startIndex = 0, midIndex = 0, endIndex = arr.length-1;

        // check if array is ascending array or descending array
        // 0th index and 1st index elements can be same and so on. Therefor we are comparing 1st and last element of the array
        boolean isAscendingArray = arr[startIndex] < arr[endIndex];

        while(startIndex <= endIndex){
            // midIndex = (startIndex + endIndex) / 2;
            // above code can give error after some iterations for very long array,
            // because after few iterations, both start and end will be big numbers, so addition of can be out of range
            // Therefore use below code -
            midIndex = startIndex + (endIndex - startIndex)/2;

            if(targetElement == arr[midIndex])
                return midIndex;

            if(isAscendingArray){
                if(targetElement < arr[midIndex])
                    endIndex = midIndex-1;
                else
                    startIndex = midIndex+1;
            } else {
                if(targetElement < arr[midIndex])
                    startIndex = midIndex+1;
                else
                    endIndex = midIndex-1;
            }
        }
        return -1;
    }

}