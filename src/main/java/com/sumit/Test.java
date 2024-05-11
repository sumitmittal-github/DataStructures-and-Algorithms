package com.sumit;

import java.util.Arrays;

public class Test {

    public static void main(String[] args) {
        Test t = new Test();
        int[] arr = {5,4,3,2,1};
        System.out.println(Arrays.toString(arr));
        t.insertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }


    public void bubbleSort(int[] arr){

        for(int i=0; i<arr.length-1; i++){
            for(int j=0; j<arr.length-1-i; j++){
                if(arr[j]>arr[j+1]){
                    swap(arr, j, j+1);
                }
            }

        }

    }

    public void selectionSort(int[] arr){
        for(int i=0; i<arr.length-1; i++){
            int minIndex = i;
            for(int j=i+1; j<arr.length; j++){
                if(arr[minIndex]>arr[j]) minIndex=j;
            }
            swap(arr, i, minIndex);
        }
    }


    public void insertionSort(int[] arr){
        for(int i=1; i<arr.length; i++){
            for(int j=i; j>0; j--){
                if(arr[j]<arr[j-1]) swap(arr, j, j-1);
                else break;
            }
        }
    }


    public void moveZerosAtTheEnd(int[] arr){
        for(int i=1; i<arr.length; i++){
            for(int j=i; j>0; j--){
                if(arr[j]<arr[j-1]) swap(arr, j, j-1);
                else break;
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}