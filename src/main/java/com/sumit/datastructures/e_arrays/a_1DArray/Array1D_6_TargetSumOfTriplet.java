package com.sumit.datastructures.e_arrays.a_1DArray;

public class Array1D_6_TargetSumOfTriplet {

    // Program : Find the total number of pairs in the array, whose sum is equal to the given value x

    public static void main(String[] args) {
        Array1D_6_TargetSumOfTriplet obj = new Array1D_6_TargetSumOfTriplet();

        int[] arr1 = {1, 4, 5, 6, 3};
        int target1 = 12;

        /*int[] arr2 = {1, 1, 1, 1, 1, 1};
        int target2 = 2;*/

        System.out.println(obj.targetSum_approach1(arr1, target1));
        //System.out.println(obj.targetSum_approach2(arr2, target2));


    }

    public int targetSum_approach1(int[] arr, int target){
        int count = 0;
        for(int i=0; i<arr.length; i++) {
            for(int j=i+1; j<arr.length; j++) {
                for(int k=j+1; k<arr.length; k++) {
                    if(arr[i] + arr[j] + arr[k] == target){
                        System.out.println("Triplet : "+ arr[i] + " + " + arr[j] + " + " + arr[k]);
                        count++;
                    }
                }
            }
        }
        return count;
    }


}