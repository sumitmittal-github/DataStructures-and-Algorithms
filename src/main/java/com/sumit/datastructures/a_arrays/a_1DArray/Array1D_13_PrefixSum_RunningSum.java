package com.sumit.datastructures.a_arrays.a_1DArray;

public class Array1D_13_PrefixSum_RunningSum {

    // LeetCode-1480 : https://leetcode.com/problems/running-sum-of-1d-array/description/

    public int[] runningSum(int[] arr) {
        if(arr.length <= 1)
            return arr;

        for(int i=1; i<arr.length; i++){
            arr[i] = arr[i] + arr[i-1];
        }
        return arr;
    }

}