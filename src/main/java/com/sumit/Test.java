package com.sumit;

import java.util.Arrays;

public class Test {

    public static void main(String[] args) {
        Test t = new Test();
        int[] arr = {5,4,3,2,1};
        System.out.println(Arrays.toString(arr));
        t.bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }


    public void bubbleSort(int[] arr){

        for(int i=0; i<arr.length-1; i++){
            for(int j=0; j<arr.length-1-i; j++){
                if(arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }

        }

    }





}