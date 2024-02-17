package com.sumit.datastructures.arrays.others;

import java.util.Arrays;

public class ReverseArray_1 {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6};
        System.out.println(Arrays.toString(arr));

        reverseArray(arr);

        System.out.println(Arrays.toString(arr));

    }

    private static void reverseArray(int[] inputArr) {
        for(int i = 0; i < inputArr.length/2; i++){
            swapElements(inputArr, i, inputArr.length-i-1);
        }
    }

    private static void swapElements(int[] inputArr, int index1, int index2){
        int temp = inputArr[index1];
        inputArr[index1] = inputArr[index2];
        inputArr[index2] = temp;
    }
}