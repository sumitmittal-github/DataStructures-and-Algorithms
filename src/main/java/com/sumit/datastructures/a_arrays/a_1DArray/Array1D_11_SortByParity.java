package com.sumit.datastructures.a_arrays.a_1DArray;

import java.util.Arrays;

public class Array1D_11_SortByParity {

    // LeetCode-905 : https://leetcode.com/problems/sort-array-by-parity/description/

    public int[] sortArrayByParity(int[] arr){
        int even = 0;
        int odd = arr.length-1;

        while(even < odd){
            if(isOdd(arr[even]) && isEven(arr[odd])){
                swap(arr, even, odd);
                even++;
                odd--;
            }
            if(isEven(arr[even]))  even++;
            if(isOdd(arr[odd]))  odd--;
        }
        return arr;
    }

    public boolean isOdd(int num){
        return ((num & 1) == 1);
    }
    public boolean isEven(int num){
        return ((num & 1) != 1);
    }

    public void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        Array1D_11_SortByParity obj = new Array1D_11_SortByParity();

        System.out.println(Arrays.toString(obj.sortArrayByParity(new int[]{1, 2, 3, 5, 4, 7, 10})));
        System.out.println(Arrays.toString(obj.sortArrayByParity(new int[]{0, 4, 5, 3, 7, 2, 1})));
        System.out.println(Arrays.toString(obj.sortArrayByParity(new int[]{0, 1})));
        System.out.println(Arrays.toString(obj.sortArrayByParity(new int[]{1, 0})));
    }
}