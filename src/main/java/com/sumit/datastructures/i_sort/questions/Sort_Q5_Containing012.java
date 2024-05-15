package com.sumit.datastructures.i_sort.questions;

import java.util.Arrays;

public class Sort_Q5_Containing012 {

    // Question : https://www.geeksforgeeks.org/sort-an-array-of-0s-1s-and-2s/
    // Dutch National Flag problem

    // Given an array A[] consisting of only 0s, 1s, and 2s.
    // The task is to write a function that sorts the given array.
    // The functions should put all 0s first, then all 1s and all 2s in last.
    // Input: {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1}
    // Output: {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2}

    public void dutchNationalFlagProblem_1(int[] arr) {
        int[] prefixSumArr = new int[3];

        // prepare frequency array
        for(int num : arr){
            prefixSumArr[num] = prefixSumArr[num] + 1;
        }

        // converting into prefix sum array
        for(int i=1; i<prefixSumArr.length; i++){
            prefixSumArr[i] = prefixSumArr[i-1] + prefixSumArr[i];
        }

        // iterate input array from last and keep putting last
        int[] output = new int[arr.length];
        for(int i=arr.length-1; i>=0; i--){
            int element = arr[i];
            int elementLastIndex = prefixSumArr[element]-1;
            output[elementLastIndex] = element;
            prefixSumArr[element] = prefixSumArr[element]-1;
        }

        //copy all the sorted values from output array to input array
        for(int i=0; i<output.length; i++)
            arr[i] = output[i];
    }

    public void dutchNationalFlagProblem_2(int[] arr) {
        int next0Index = 0;
        int next2Index = arr.length-1;

        int i=0;
        while(i <= next2Index) {
            if(arr[i] == 0){
                swap(arr, next0Index, i);
                next0Index++;
                i++;
            }
            else if(arr[i] == 1) {
                i++;
            }
            else {
                swap(arr, next2Index, i);
                next2Index--;
            }
        }
    }



    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public static void main(String[] args) {
        Sort_Q5_Containing012 obj = new Sort_Q5_Containing012();

        int[] arr1 = {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1};
        obj.dutchNationalFlagProblem_1(arr1);
        System.out.println(Arrays.toString(arr1));

        int[] arr2 = {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1};
        obj.dutchNationalFlagProblem_2(arr2);
        System.out.println(Arrays.toString(arr2));
    }

}