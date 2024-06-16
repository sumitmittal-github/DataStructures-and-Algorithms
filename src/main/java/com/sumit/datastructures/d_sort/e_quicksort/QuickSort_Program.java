package com.sumit.datastructures.d_sort.e_quicksort;

import java.util.Arrays;

public class QuickSort_Program {


    // Approach-1 : taught by College Wallah : easy to understand
    public void quickSort_1(int[] arr, int start, int end){
        if(start >= end)
            return;

        int pivotIndex = partition(arr, start, end);
        quickSort_1(arr, start, pivotIndex-1);
        quickSort_1(arr, pivotIndex+1, end);
    }
    public int partition(int[] arr, int start, int end) {
        // Step-1 : take 1st element as pivot element and
        // count elements less than or equal to pivot element (keep all matching duplicate elements at the left)
        int pivotElement = arr[start];
        int count = 0;
        for(int i=start+1; i<=end; i++){
            if(arr[i] <= pivotElement)    count++;
        }

        // Step-2 : Calculate pivotIndex and put pivotElement at its correct position
        int pivotIndex = start + count;
        swap(arr, start, pivotIndex);

        // Step-3 : all the elements before pivotIndex should be less than or equal to pivot element
        //          all the elements after pivotIndex should be greater than pivot element
        while(start <= pivotIndex && end > pivotIndex){
            while(arr[start] <= pivotElement) start++;
            while(arr[end] > pivotElement) end--;

            if(start <= pivotIndex && end > pivotIndex) {
                swap(arr, start, end);
                start++;
                end--;
            }
        }
        return pivotIndex;
    }



    // Approach-2 : taught by Kunal Kushwaha : a bit hard to understand
    public void quickSort_2(int[] arr, int arrFirstIndex, int arrLastIndex) {
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
        quickSort_2(arr, arrFirstIndex, end);
        quickSort_2(arr, start, arrLastIndex);
    }


    private void swap(int[] arr, int index1, int index2){
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    public static void main(String[] args) {
        QuickSort_Program obj = new QuickSort_Program();

        int[] arr1 = {5,4,3,2,1};
        System.out.println(Arrays.toString(arr1));
        obj.quickSort_1(arr1,0, arr1.length-1);
        System.out.println(Arrays.toString(arr1));
        System.out.println();

        int[] arr2 = {6,6,3,1,5,5, 6, 7, 9,9,9,9,1,6,6,6,6,6,6};
        System.out.println(Arrays.toString(arr2));
        obj.quickSort_1(arr2,0, arr2.length-1);
        System.out.println(Arrays.toString(arr2));
        System.out.println();

    }


}