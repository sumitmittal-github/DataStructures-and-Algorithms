package com.sumit.datastructures.a_arrays;

public class Array15_RangeSumQuery_Mutable {

    //LeetCode-307 : https://leetcode.com/problems/range-sum-query-mutable/description/

    //TODO - giving time limit exceed for 1 of the test case.
    //As per comments :-    2 solutions: Binary Indexed Tree, Segment Tree

    int[] prefixArr;
    int[] arr;

    public Array15_RangeSumQuery_Mutable(int[] inputArr) {
        this.arr = inputArr;
        this.prefixArr = new int[inputArr.length];
        refillPefixArr();
        //System.out.println(Arrays.toString(prefixArr));
    }

    public void update(int index, int val) {
        arr[index] = val;
        refillPefixArr();
    }

    public int sumRange(int left, int right) {
        if(left == 0)
            return  prefixArr[right];
        else
            return prefixArr[right] - prefixArr[left-1];
    }


    public void refillPefixArr(){
        //System.out.println("arr : "  + Arrays.toString(arr));
        prefixArr[0] = arr[0];
        for(int i=1; i<arr.length; i++) {
            prefixArr[i] = arr[i] + prefixArr[i-1];
        }
        //System.out.println("Prefix : " + Arrays.toString(prefixArr));
    }



}