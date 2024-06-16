package com.sumit.datastructures.d_sort.questions;

import java.util.Arrays;

public class Sort_Q3_SortedExcept2Elements {

    // Question : Given an array where all elements are sorted in increasing order, except 2 swapped elements.
    //            Sort this array in linear time.
    // input  = {3,8,6,7,5,9,10}
    // Output = {3,5,6,7,8,9,10}

    public void sort(int[] arr) {
        if(arr.length <= 1)
            return;

        int firstIndex = -1, secondIndex = -1;

        for(int i=1; i<arr.length; i++){
            if(arr[i-1] > arr[i]){
                // when 1st conflict
                if(firstIndex == -1) {
                    firstIndex = i-1;
                    secondIndex = i;            // we added this line to handle the case where we have array like {5, 2}
                }
                // when 2nd conflict
                else {
                    secondIndex = i;
                }
            }
        }
        swap(arr, firstIndex, secondIndex);
    }



    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public static void main(String[] args) {
        Sort_Q3_SortedExcept2Elements obj = new Sort_Q3_SortedExcept2Elements();

        int[] arr1 = {3,8,6,7,5,9,10};
        obj.sort(arr1);
        System.out.println(Arrays.toString(arr1));

        int[] arr2 = {5, 2};
        obj.sort(arr2);
        System.out.println(Arrays.toString(arr2));
    }

}