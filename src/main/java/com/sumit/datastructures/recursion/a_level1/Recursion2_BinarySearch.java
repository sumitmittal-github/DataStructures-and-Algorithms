package com.sumit.datastructures.recursion.a_level1;



public class Recursion2_BinarySearch {

    public static void main(String[] args) {

        // indexes             0    1   2  3  4   5  6   7   8   9
        int[] ascendingArr = {-65, -12, 1, 3, 7, 13, 22, 90, 96, 101};

        System.out.println("Target : -99 => Index : "+binarySearch(ascendingArr, -99, 0, ascendingArr.length-1));
        System.out.println("Target : -65 => Index : "+binarySearch(ascendingArr, -65, 0, ascendingArr.length-1));
        System.out.println("Target : -55 => Index : "+binarySearch(ascendingArr, -55, 0, ascendingArr.length-1));
        System.out.println("Target : -12 => Index : "+binarySearch(ascendingArr, -12, 0, ascendingArr.length-1));
        System.out.println("Target : 0   => Index : "+binarySearch(ascendingArr, 0, 0, ascendingArr.length-1));
        System.out.println("Target : 1   => Index : "+binarySearch(ascendingArr, 1, 0, ascendingArr.length-1));
        System.out.println("Target : 2   => Index : "+binarySearch(ascendingArr, 2, 0, ascendingArr.length-1));
        System.out.println("Target : 3   => Index : "+binarySearch(ascendingArr, 3, 0, ascendingArr.length-1));
        System.out.println("Target : 5   => Index : "+binarySearch(ascendingArr, 5, 0, ascendingArr.length-1));
        System.out.println("Target : 7   => Index : "+binarySearch(ascendingArr, 7, 0, ascendingArr.length-1));
        System.out.println("Target : 9   => Index : "+binarySearch(ascendingArr, 9, 0, ascendingArr.length-1));
        System.out.println("Target : 13  => Index : "+binarySearch(ascendingArr, 13, 0, ascendingArr.length-1));
        System.out.println("Target : 14  => Index : "+binarySearch(ascendingArr, 14, 0, ascendingArr.length-1));
        System.out.println("Target : 22  => Index : "+binarySearch(ascendingArr, 22, 0, ascendingArr.length-1));
        System.out.println("Target : 50  => Index : "+binarySearch(ascendingArr, 50, 0, ascendingArr.length-1));
        System.out.println("Target : 90  => Index : "+binarySearch(ascendingArr, 90, 0, ascendingArr.length-1));
        System.out.println("Target : 95  => Index : "+binarySearch(ascendingArr, 95, 0, ascendingArr.length-1));
        System.out.println("Target : 96  => Index : "+binarySearch(ascendingArr, 96, 0, ascendingArr.length-1));
        System.out.println("Target : 100 => Index : "+binarySearch(ascendingArr, 100, 0, ascendingArr.length-1));
        System.out.println("Target : 101 => Index : "+binarySearch(ascendingArr, 101, 0, ascendingArr.length-1));
        System.out.println("Target : 200 => Index : "+binarySearch(ascendingArr, 200, 0, ascendingArr.length-1));    }

    private static int binarySearch(int[] arr, int targetElement, int start, int end){
        // base condition
        if (end < start)
            return -1;

        int mid = start + (end-start) / 2;
        if(targetElement == arr[mid])
            return mid;
        else if(targetElement < arr[mid])
            return binarySearch(arr, targetElement, start, mid-1);
        else
            return binarySearch(arr, targetElement, mid+1, end);
    }


}