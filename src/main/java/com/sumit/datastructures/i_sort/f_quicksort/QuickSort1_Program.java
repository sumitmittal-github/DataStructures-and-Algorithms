package com.sumit.datastructures.i_sort.f_quicksort;

import java.util.Arrays;

public class QuickSort1_Program {

    public static void main(String[] args) {
        int[] arr = {5,4,3,2,1};
        quickSort(arr,0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr, int arrFirstIndex, int arrLastIndex) {
        if(arrFirstIndex >= arrLastIndex)
            return;

        int start = arrFirstIndex;
        int end = arrLastIndex;
        int pivot = arr[start + (end-start)/2];

        while(start <= end){

            // also a reason why if it is already sorted, then it will not swap
            while(arr[start] < pivot)
                start++;
            while(pivot < arr[end])
                end--;


            // if both while look break => means both expected condition break => then we will swap both the elements
            // because start was greater than pivot and end was less than pivot
            if(start <= end) {
                swap(arr, start, end);
                start++;
                end--;
            }
        }

        // after above while loop => my pivot is at its correct place => now sort 2 half arrays
        quickSort(arr, arrFirstIndex, end);
        quickSort(arr, start, arrLastIndex);
    }


    private static void swap(int[] arr, int index1, int index2){
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

}