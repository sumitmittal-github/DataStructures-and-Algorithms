package com.sumit.datastructures.h_search.b_binarysearch;

public class BinarySearch3_FloorNumber {

    /*Program :- find the floor number of a target from an array
     *       Ex- [1, 4, 7, 12, 45, 55, 90]
     *       if target = 6 => result = 4
     *       if target = 7 => result = 7
     *       if target = 8 => result = 7
     *       if target = -95 => result = -999
     * */

    public static void main(String[] args) {
        int[] arr = {-15, 0, 1, 4, 7, 12, 45, 55, 90};
        System.out.println("Target : -99 => Floor : "+findFloorNumber(arr, -99));
        System.out.println("Target : -15 => Floor : "+findFloorNumber(arr, -15));
        System.out.println("Target : -5  => Floor : "+findFloorNumber(arr, -5));
        System.out.println("Target : 0   => Floor : "+findFloorNumber(arr, 0));
        System.out.println("Target : 1   => Floor : "+findFloorNumber(arr, 1));
        System.out.println("Target : 2   => Floor : "+findFloorNumber(arr, 2));
        System.out.println("Target : 4   => Floor : "+findFloorNumber(arr, 4));
        System.out.println("Target : 6   => Floor : "+findFloorNumber(arr, 6));
        System.out.println("Target : 7   => Floor : "+findFloorNumber(arr, 7));
        System.out.println("Target : 10  => Floor : "+findFloorNumber(arr, 10));
        System.out.println("Target : 12  => Floor : "+findFloorNumber(arr, 12));
        System.out.println("Target : 40  => Floor : "+findFloorNumber(arr, 40));
        System.out.println("Target : 45  => Floor : "+findFloorNumber(arr, 45));
        System.out.println("Target : 50  => Floor : "+findFloorNumber(arr, 50));
        System.out.println("Target : 55  => Floor : "+findFloorNumber(arr, 55));
        System.out.println("Target : 70  => Floor : "+findFloorNumber(arr, 70));
        System.out.println("Target : 90  => Floor : "+findFloorNumber(arr, 90));
        System.out.println("Target : 99  => Floor : "+findFloorNumber(arr, 99));
    }

    public static int findFloorNumber(int[] arr, int target) {

        if(arr == null || arr.length == 0)
            return -999;

        if(arr.length == 1){
            if(arr[0] <= target) return arr[0];
            else return -999;
        }

        // check if the target is smaller than the smallest number of the input array
        if(arr[0] > target)
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
        // loop will break when endIndex < startIndex means endIndex will always point to nearest small number
        return arr[endIndex];
    }


}