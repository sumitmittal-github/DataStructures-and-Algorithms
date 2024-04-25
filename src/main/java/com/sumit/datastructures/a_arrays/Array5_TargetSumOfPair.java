package com.sumit.datastructures.a_arrays;

import java.util.HashMap;
import java.util.Map;

public class Array5_TargetSumOfPair {

    // Question : Find the total number of pairs in the array, whose sum is equal to the given value x

    public static void main(String[] args) {
        Array5_TargetSumOfPair obj = new Array5_TargetSumOfPair();

        int[] arr1 = {4, 6, 3, 5, 8, 2};
        int target1 = 7;

        int[] arr2 = {1, 1, 1, 1, 1, 1};
        int target2 = 2;

        System.out.println(obj.targetSum_approach1(arr2, target2));
        System.out.println(obj.targetSum_approach2(arr2, target2));


    }

    public int targetSum_approach1(int[] arr, int target){
        int count = 0;
        for(int i=0; i<arr.length; i++) {
            for(int j=i+1; j<arr.length; j++) {
                if(arr[i] + arr[j] == target){
                    System.out.println("Pair : "+ arr[i] + " + " + arr[j]);
                    count++;
                }
            }
        }
        return count;
    }


    // TODO : 2nd approach is not providing all the results
    public int targetSum_approach2(int[] arr, int target){
        int count = 0;
        Map<Integer, Integer> diffAndIndexMap = new HashMap<>();

        for(int i=0; i<arr.length; i++) {
            int diff = target - arr[i];
            if(!diffAndIndexMap.containsKey(arr[i])){
                diffAndIndexMap.put(diff, i);
            } else {
                System.out.println("Pair : "+ arr[i] + " + " + arr[diffAndIndexMap.get(arr[i])]);
                count++;
            }
        }
        return count;
    }
}