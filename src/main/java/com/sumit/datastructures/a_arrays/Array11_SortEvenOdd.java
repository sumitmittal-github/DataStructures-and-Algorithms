package com.sumit.datastructures.a_arrays;

import java.util.Arrays;

public class Array11_SortEvenOdd {

    //Problem : Sort an array. All evens followed by odds.
    //https://www.geeksforgeeks.org/segregate-even-and-odd-numbers/


    public void sort(int[] arr){
        int even = 0;
        int odd = arr.length-1;

        while(even < odd){
            if(isEven(arr[even]))  even++;
            if(isOdd(arr[odd]))  odd--;

            if(isOdd(arr[even]) && isEven(arr[odd])){
                swap(arr, even, odd);
                even++;
                odd--;
            }
        }
    }

    public boolean isOdd(int num){
        return ((num & 1) == 1);
    }
    public boolean isEven(int num){
        return ((num & 1) != 1);
    }

    public void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        Array11_SortEvenOdd obj = new Array11_SortEvenOdd();

        int[] arr1 = {1, 2, 3, 5, 4, 7, 10};
        obj.sort(arr1);
        System.out.println(Arrays.toString(arr1));

        int[] arr2 = {0, 4, 5, 3, 7, 2, 1};
        obj.sort(arr2);
        System.out.println(Arrays.toString(arr2));

        int[] arr3 = {0, 0, 0, 0, 0, 0, 0, 0, 0};
        obj.sort(arr3);
        System.out.println(Arrays.toString(arr3));

        int[] arr4 = {1, 1, 1, 1, 1, 1, 1, 1};
        obj.sort(arr4);
        System.out.println(Arrays.toString(arr4));
    }
}