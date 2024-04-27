package com.sumit.datastructures.a_arrays.a_1DArray;

import java.util.Arrays;

public class Array1D_10_SortArrayConsisting_0_1 {

    //Program : Sort an array consisting of only 0 and 1
    //https://www.geeksforgeeks.org/segregate-0s-and-1s-in-an-array-by-traversing-array-once/

    public void sort(int[] arr){
        int start = 0;
        int end = arr.length-1;

        while(start < end){
            if(arr[start] != 1)  start++;
            if(arr[end] != 0)  end--;

            if(arr[start] == 1 && arr[end] == 0){
                swap(arr, start, end);
                start++;
                end--;
            }
        }
    }

    public void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        Array1D_10_SortArrayConsisting_0_1 obj = new Array1D_10_SortArrayConsisting_0_1();

        int[] arr = {};
        obj.sort(arr);
        System.out.println(Arrays.toString(arr));
    }


}