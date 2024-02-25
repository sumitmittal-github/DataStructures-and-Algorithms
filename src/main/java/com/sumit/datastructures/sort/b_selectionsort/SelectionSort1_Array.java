package com.sumit.datastructures.sort.b_selectionsort;

import java.util.Arrays;

public class SelectionSort1_Array {

    public static void main(String[] args) {
        int[] arr1 = {10, 30, 20, 50, 40};
        selectionSort(arr1);
        System.out.println(Arrays.toString(arr1));

        int[] arr2 = {10, 20, 30, 40, 50};
        selectionSort(arr2);
        System.out.println(Arrays.toString(arr2));

        int[] arr3 = {50, 40, 30, 20, 10};
        selectionSort(arr3);
        System.out.println(Arrays.toString(arr3));

        int[] arr4 = {};
        selectionSort(arr4);
        System.out.println(Arrays.toString(arr4));

        int[] arr5 = {10};
        selectionSort(arr5);
        System.out.println(Arrays.toString(arr5));

        int[] arr6 = {-50, -440, 332, -990, 0};
        selectionSort(arr6);
        System.out.println(Arrays.toString(arr6));

    }

    private static void selectionSort(int[] arr){

        for (int i = 0; i <= arr.length-1; i++) {

            // find the max element and it's position
            int max = arr[0];       //max element
            int maxPosition = 0;    //position of max element
            for (int j = 1; j <= arr.length-1-i ; j++) {
                if(max < arr[j]){
                    max = arr[j];
                    maxPosition = j;
                }
            }

            // swap
            int temp = arr[maxPosition];
            arr[maxPosition] = arr[arr.length-i-1];
            arr[arr.length-i-1] = temp;


        }


    }

}