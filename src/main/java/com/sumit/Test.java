package com.sumit;

import java.util.Arrays;

public class Test {

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



    public void mergeSort(int[] arr) {
        mergeSort(arr, 0, arr.length-1);
    }
    public void mergeSort(int[] arr, int start, int end) {
        if(end-start == 0)
            return;

        int mid = start + (end-start)/2;

        mergeSort(arr, start, mid);
        mergeSort(arr, mid+1, end);

        // merge the arrays
        merge(arr, start, mid, end);
    }
    public void merge(int[] arr, int start, int mid, int end){
        int[] arr1 = Arrays.copyOfRange(arr, start, mid+1);
        int[] arr2 = Arrays.copyOfRange(arr, mid+1, end+1);
        int index1 = 0, index2 = 0, indexMainArr = start;

        while(index1 < arr1.length && index2 < arr2.length) {
            if(arr1[index1] <= arr2[index2])        arr[indexMainArr++] = arr1[index1++];
            else                                    arr[indexMainArr++] = arr2[index2++];
        }

        while(index1 < arr1.length) {
            arr[indexMainArr++] = arr1[index1++];
        }
        while(index2 < arr2.length) {
            arr[indexMainArr++] = arr2[index2++];
        }
    }



    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public static void main(String[] args) {
        Test t = new Test();
        int[] arr = {5,4,3,2,1};
        System.out.println(Arrays.toString(arr));
        t.mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }

}