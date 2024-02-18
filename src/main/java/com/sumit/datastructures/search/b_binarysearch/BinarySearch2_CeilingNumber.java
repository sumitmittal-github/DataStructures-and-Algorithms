package com.sumit.datastructures.search.b_binarysearch;

public class BinarySearch2_CeilingNumber {

    /*Problem :- find the ceiling number of a target from an array
    *       Ex- [1, 4, 7, 12, 45, 55, 90]
     *       if target = 6 => result = 7
     *       if target = 7 => result = 7
     *       if target = 8 => result = 12
     *       if target = 95 => result = -999
    * */

    public static void main(String[] args) {
        int[] arr = {-15, 0, 1, 4, 7, 12, 45, 55, 90};
        System.out.println("Target : -99 => Ceiling : "+findCeilingNumber(arr, -99));
        System.out.println("Target : -15 => Ceiling : "+findCeilingNumber(arr, -15));
        System.out.println("Target : -5  => Ceiling : "+findCeilingNumber(arr, -5));
        System.out.println("Target : 0   => Ceiling : "+findCeilingNumber(arr, 0));
        System.out.println("Target : 1   => Ceiling : "+findCeilingNumber(arr, 1));
        System.out.println("Target : 2   => Ceiling : "+findCeilingNumber(arr, 2));
        System.out.println("Target : 4   => Ceiling : "+findCeilingNumber(arr, 4));
        System.out.println("Target : 6   => Ceiling : "+findCeilingNumber(arr, 6));
        System.out.println("Target : 7   => Ceiling : "+findCeilingNumber(arr, 7));
        System.out.println("Target : 10  => Ceiling : "+findCeilingNumber(arr, 10));
        System.out.println("Target : 12  => Ceiling : "+findCeilingNumber(arr, 12));
        System.out.println("Target : 40  => Ceiling : "+findCeilingNumber(arr, 40));
        System.out.println("Target : 45  => Ceiling : "+findCeilingNumber(arr, 45));
        System.out.println("Target : 50  => Ceiling : "+findCeilingNumber(arr, 50));
        System.out.println("Target : 55  => Ceiling : "+findCeilingNumber(arr, 55));
        System.out.println("Target : 70  => Ceiling : "+findCeilingNumber(arr, 70));
        System.out.println("Target : 90  => Ceiling : "+findCeilingNumber(arr, 90));
        System.out.println("Target : 99  => Ceiling : "+findCeilingNumber(arr, 99));
    }

    public static int findCeilingNumber(int[] arr, int target) {

        if(arr == null || arr.length == 0)
            return -999;

        if(arr.length == 1){
            if(arr[0] >= target) return arr[0];
            else return -999;
        }

        // check if the target is larger than the largest of our input array
        if(arr[arr.length-1] < target)
            return -999;


        int startIndex = 0, midIndex = 0, endIndex = arr.length-1;

        while(startIndex <= endIndex){
            midIndex = startIndex + (endIndex-startIndex)/2;

            if(arr[midIndex] == target)
                return arr[midIndex];

            if(arr[midIndex] > target)
                endIndex = midIndex-1;
            else
                startIndex = midIndex+1;
        }

        // while loop completed but we are executing this line means element did not exist in the array
        // loop will break when endIndex < startIndex means startIndex will point to nearest big number
        return arr[startIndex];
    }


}