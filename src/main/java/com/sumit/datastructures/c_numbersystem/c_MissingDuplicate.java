package com.sumit.datastructures.c_numbersystem;

public class c_MissingDuplicate {

    /**
     * problem : Array contains duplicate numbers, except 1 number. Find that no.
     * Ex - [2, 3, 3, 4, 2, 6, 4]
     * And : 6 because 6 duplicate does not exist in the array.
     */

    public static void main(String[] args) {
        int[] arr1 = {2, 3, 3, 4, 2, 6, 4};
        System.out.println("Missing duplicate : " + findMissingDuplicate(arr1));

        int[] arr2 = {2, 6, -3, -4, 2, 6, -4};
        System.out.println("Missing duplicate : " + findMissingDuplicate(arr2));
    }


    // Solution: add all numbers and change the sign of sum
    private static int findMissingDuplicate(int[] arr) {
        int unique = 0;
        for (int num : arr) {
            unique = unique ^ num;
        }
        return unique;
    }

}