package com.sumit.datastructures.arrays.others;

import java.util.Arrays;

public class ReverseArray {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        System.out.println("Original Array : " + Arrays.toString(arr));

        reverseArrayGeneralApproach(arr);
        System.out.println("Reversed Array : " + Arrays.toString(arr));

        reverseArrayBy2PointerApproach(arr);
        System.out.println("Reversed Again : " + Arrays.toString(arr));
    }

    /*
    * Approach-1 : general approach
    * by iterating half elements and keep swapping
    * */
    private static void reverseArrayGeneralApproach(int[] inputArr) {
        for(int i = 0; i < inputArr.length/2; i++){
            swapElements(inputArr, i, inputArr.length-i-1);
        }
    }

    /*
     * Approach-2 : 2 pointer approach
     * by taking 2 pointers and keep swapping till startPointerIndex >= endPointerIndex
     * */
    private static void reverseArrayBy2PointerApproach(int[] inputArr) {
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