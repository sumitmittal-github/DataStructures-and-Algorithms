package com.sumit.datastructures.arrays.others;

import java.util.Arrays;

public class ReverseArray_2 {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        System.out.println(Arrays.toString(arr));

        reverseArray(arr);

        System.out.println(Arrays.toString(arr));

    }

    private static void reverseArray(int[] inputArr) {
        int startIndex = 0;
        int endIndex = inputArr.length-1;

        while(startIndex < endIndex){
            swapElements(inputArr, startIndex, endIndex);
            startIndex++;
            endIndex--;
        }
    }

    private static void swapElements(int[] inputArr, int index1, int index2){
        int temp = inputArr[index1];
        inputArr[index1] = inputArr[index2];
        inputArr[index2] = temp;
    }
}