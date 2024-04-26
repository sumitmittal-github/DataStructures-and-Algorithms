package com.sumit.datastructures.a_arrays;

import java.util.Arrays;

public class Array12_SortedSquares {

    //LeetCode-977 : https://leetcode.com/problems/squares-of-a-sorted-array/submissions/1242634624/

    public int[] sortedSquares(int[] arr) {
        int[] ans = new int[arr.length];
        int ansIndex = ans.length - 1;

        int start = 0;
        int end = arr.length-1;
        while(start <= end){
            if( arr[start]*arr[start] > arr[end]*arr[end]) {
                ans[ansIndex] = arr[start]*arr[start];
                start++;
            }
            else{
                ans[ansIndex] = arr[end]*arr[end];
                end--;
            }
            ansIndex--;
        }
        return ans;
    }

    public static void main(String[] args) {
        Array12_SortedSquares obj = new Array12_SortedSquares();

        System.out.println(Arrays.toString(obj.sortedSquares(new int[]{-4,-1,0,3,10})));
        System.out.println(Arrays.toString(obj.sortedSquares(new int[]{-1})));
        System.out.println(Arrays.toString(obj.sortedSquares(new int[]{1})));
        System.out.println(Arrays.toString(obj.sortedSquares(new int[]{-100, -50, -15, 0})));
        System.out.println(Arrays.toString(obj.sortedSquares(new int[]{-7,-3,2,3,11})));
    }

}