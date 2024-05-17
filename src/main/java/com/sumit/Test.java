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



    public void quickSort(int[] arr){
        quickSort(arr, 0, arr.length-1);
    }
    public void quickSort(int[] arr, int start, int end){
        if(start >= end)
            return;

        int pivotIndex = partition(arr, start, end);
        quickSort(arr, start, pivotIndex-1);
        quickSort(arr, pivotIndex+1, end);
    }
    private int partition(int[] arr, int start, int end) {
        // Step-1 : take 1st element as pivot element and
        // count elements less than or equal to pivot element (keep all matching duplicate elements at the left)
        int pivotElement = arr[start];
        int count = 0;
        for(int i=start+1; i<arr.length; i++){
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


    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public int reverseBits(int n) {
        String binaryNum = String.valueOf(n);
        binaryNum = new StringBuffer(binaryNum).reverse().toString();
        return Integer.parseInt(binaryNum, 2);
    }



    public int squareRoot(int num){
        int start = 1, end = num/2;

        while(start <= end){
            int mid = start + (end-start)/2;

            if(mid*mid == num)
                return mid;
            else if(mid*mid < num)
                start = mid+1;
            else
                end = mid-1;
        }
        return end;
    }


    public static void main(String[] args) {
        double start2 = 4;
        double end2 = start2 + 1 - Math.pow(.1, 3);

        System.out.println(start2);
        System.out.println(end2);
    }






}