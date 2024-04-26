package com.sumit.datastructures.a_arrays.a_1DArray;

public class Array1D_14_RangeSumQuery_Immutable {

    //LeetCode-303 : https://leetcode.com/problems/range-sum-query-immutable/description/

    int[] arr;

    public Array1D_14_RangeSumQuery_Immutable(int[] arr) {
        this.arr = arr;
        convertIntoPrefixArr(arr);             // convert the array only once. Therefor we kept it in the constructor.
        //System.out.println(Arrays.toString(arr));
    }

    public int sumRange(int left, int right) {
        if(left == 0)
            return  arr[right];
        else
            return arr[right] - arr[left-1];
    }

    public void convertIntoPrefixArr(int[] arr){
        if(arr.length == 1)
            return;

        for(int i=1; i<arr.length; i++) {
            arr[i] = arr[i] + arr[i-1];
        }
    }

}