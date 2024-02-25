package com.sumit.datastructures.sort.d_cyclicsort;

import java.util.Arrays;

public class CyclicSort1_Array {

    public static void main(String[] args) {

        int[] arr = {3, 5, 2, 1, 4};
        cyclicSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void cyclicSort(int[] arr){
        int i = 0;
        while(i <= arr.length-1) {
            if(arr[i] == i+1)
                i++;
            else
                swap(arr, i, arr[i]-1);
        }
    }

    private static void swap(int[] arr, int position1, int position2){
        int temp = arr[position1];
        arr[position1] = arr[position2];
        arr[position2] = temp;
    }

    // not a good approach : because we can skip the nested loop as shown in above method.
    private static void cyclicSort2(int[] arr){
        for(int i = 0; i <= arr.length-1; i++) {
            boolean isElementAtCorrectPosition = false;
            while(!isElementAtCorrectPosition){
                if(i == arr[i]-1)
                    isElementAtCorrectPosition = true;
                else
                    swap(arr, i, arr[i]-1);
            }
        }
    }

}