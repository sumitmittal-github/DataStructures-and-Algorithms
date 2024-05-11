package com.sumit.datastructures.i_sort.questions;

import java.util.Arrays;

public class Sort_Q2_LexicographicalSort {

    // Question : Given an array of fruit names, sort this array in lexicographical order using the selection sort.
    // input  = {"papaya", "lime", "watermelon", "apple", "mango", "kiwi"};
    // Output = {"apple", "kiwi", "lime", "mango", "papaya", "watermelon"};

    // Note : Lexicographical order means dictionary order
    // Ex - Cottage, College        => here College is smaller than Cottage because l < t

    public void lexicographicalSort(String[] arr) {

        for(int i=0; i<arr.length-1; i++) {

            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if(arr[minIndex].compareTo(arr[j]) > 0)
                    minIndex = j;
            }

            if(minIndex != i)
                swap(arr, minIndex, i);
        }
    }



    public void swap(String[] arr, int i, int j) {
        String temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public static void main(String[] args) {
        Sort_Q2_LexicographicalSort obj = new Sort_Q2_LexicographicalSort();

        String[] arr1 = {"papaya", "lime", "watermelon", "apple", "mango", "kiwi"};
        obj.lexicographicalSort(arr1);
        System.out.println(Arrays.toString(arr1));

        String[] arr2 = {"college", "cot", "cottage"};
        obj.lexicographicalSort(arr2);
        System.out.println(Arrays.toString(arr2));

        String[] arr3 = {"cottage", "cot", "college"};
        obj.lexicographicalSort(arr3);
        System.out.println(Arrays.toString(arr3));
    }

}