package com.sumit.datastructures.c_numbersystem;

public class b_missingCounterpart {

    /**
     * Program : Array contains +ve and -ve of the same numbers, except 1 number. Find that no.
     * Ex - [-2, 3, 2, 4, -5, 5, -4]
     * And : 3 because 2 has -2, 4 has -4, 5 has -5.
    */

    public static void main(String[] args) {
        int[] arr1 = {-2, 3, 2, 4, -5, 5, -4};
        System.out.println("Missing Counterpart : "+findMissingCounterPart(arr1));

        int[] arr2 = {-2, -3, 2, 4, -5, 5, -4};
        System.out.println("Missing Counterpart : "+findMissingCounterPart(arr2));

        int[] arr3 = null;
        System.out.println("Missing Counterpart : "+findMissingCounterPart(arr3));

        int[] arr4 = {};
        System.out.println("Missing Counterpart : "+findMissingCounterPart(arr4));

        int[] arr5 = new int[10];
        System.out.println("Missing Counterpart : "+findMissingCounterPart(arr5));

        int[] arr6 = {0};
        System.out.println("Missing Counterpart : "+findMissingCounterPart(arr6));

        int[] arr7 = {-0};
        System.out.println("Missing Counterpart : "+findMissingCounterPart(arr6));
    }


    // Solution: add all numbers and change the sign of sum
    private static int findMissingCounterPart(int[] arr){
        if(arr == null || arr.length == 0)
            return Integer.MIN_VALUE;

        int sum=0;
        for(int i : arr){
            sum += i;
        }
        return sum * -1;
    }
}
