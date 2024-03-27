package com.sumit.datastructures.sort.a_bubblesort;

import java.util.Arrays;

public class BubbleSort1_Array {

/**
    NOTE : We also did bubble sort using recursion
           Please check recursion -> sorting -> bubble sort class
*/

    public static void main(String[] args) {
        int[] arr1 = {10, 30, 20, 50, 40};
        bubbleSort(arr1);
        System.out.println(Arrays.toString(arr1));

        int[] arr2 = {10, 20, 30, 40, 50};
        bubbleSort(arr2);
        System.out.println(Arrays.toString(arr2));

        int[] arr3 = {50, 40, 30, 20, 10};
        bubbleSort(arr3);
        System.out.println(Arrays.toString(arr3));

        int[] arr4 = {};
        bubbleSort(arr4);
        System.out.println(Arrays.toString(arr4));

        int[] arr5 = {10};
        bubbleSort(arr5);
        System.out.println(Arrays.toString(arr5));

        int[] arr6 = {-50, -440, 332, -990, 0};
        bubbleSort(arr6);
        System.out.println(Arrays.toString(arr6));

    }

    // we are not returning the existing array because we will sort the existing array
    // because bubble sort comes under inplace sorting technique.
    private static void bubbleSort(int[] arr) {

        // iterate the entire array n-1 times
        for(int i = 0; i < arr.length; i++) {
            boolean isSwapped = false;
            // after each iteration the max element will come at the last respective index
            for (int j = 1; j < arr.length-i; j++) {
                if(arr[j] < arr[j-1]){
                    int temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;
                    isSwapped = true;
                }
            }

            // if we did not swap for any particular value of i, then it means the array is already sorted now
            // therefore we can come out of the loop and finish the program.
            if(!isSwapped)
                break;
        }
    }

}