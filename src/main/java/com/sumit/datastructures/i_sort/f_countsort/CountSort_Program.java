package com.sumit.datastructures.i_sort.f_countsort;

import java.util.Arrays;

public class CountSort_Program {

    // Question : Sort the array
    public static void main(String[] args) {
        CountSort_Program obj = new CountSort_Program();

        int[] arr1 = {4,3,1,5,3,1,3,5};
        System.out.println(Arrays.toString(arr1));
        obj.countSort_basic(arr1);
        System.out.println(Arrays.toString(arr1));
        System.out.println();

        int[] arr2 = {4,3,1,5,3,1,3,5};
        System.out.println(Arrays.toString(arr2));
        obj.countSort_stable(arr2);
        System.out.println(Arrays.toString(arr2));
        System.out.println();

    }

    public void countSort_basic(int[] arr){

        // Step-1 : find the maximum number in the array
        int maxElement = Integer.MIN_VALUE;
        for(int num : arr)
            if(maxElement < num) maxElement = num;

        // Step-2 : prepare the frequency array (count array)
        int[] frequencyArr = new int[maxElement+1];
        for(int num : arr)
            frequencyArr[num] = frequencyArr[num] + 1;

        // Step-3 : iterate through frequency array and refill the input array
        int index=0;
        for(int i=0; i<frequencyArr.length; i++) {
            int frequency = frequencyArr[i];
            while(frequency-- > 0){
                arr[index++] = i;
            }
        }
    }


    public void countSort_stable(int[] arr){

        // Step-1 : find the maximum number in the array
        int maxElement = arr[0];
        for(int i=1; i<arr.length; i++)
            if(maxElement < arr[i]) maxElement = arr[i];

        // Step-2 : prepare the prefix sum array of the frequencies
        int[] prefixSumArrOfFrequency = new int[maxElement+1];
        for(int num : arr)
            prefixSumArrOfFrequency[num] = prefixSumArrOfFrequency[num] + 1;
        for(int i=1; i<prefixSumArrOfFrequency.length; i++) {
            prefixSumArrOfFrequency[i] = prefixSumArrOfFrequency[i-1] + prefixSumArrOfFrequency[i];
        }
        // NOTE : we can see that prefixSumArrOfFrequency contains last position of each element

        // Step-3 : iterate through input array from last
        //          and keep putting every element at its correct last position
        int[] output = new int[arr.length];
        for(int i=arr.length-1; i>=0; i--) {
            int element = arr[i];
            int elementLastPosition = prefixSumArrOfFrequency[element]-1;
            output[elementLastPosition] = element;

            // decrease the value so that in the next iteration we get another element's correct position
            prefixSumArrOfFrequency[element] = prefixSumArrOfFrequency[element]-1;
        }

        // Step-4 : copy all the sorted values from output array to input array
        for(int i=0; i<output.length; i++)
            arr[i] = output[i];
    }



}