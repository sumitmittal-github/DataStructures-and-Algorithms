package com.sumit.datastructures.i_sort.g_radixsort;

import java.util.Arrays;

public class RadixSort_Program {

    // Question : Sort the array
    public static void main(String[] args) {
        RadixSort_Program obj = new RadixSort_Program();

        int[] arr1 = {4,3,1,5,3,1,3,5};
        System.out.println(Arrays.toString(arr1));
        obj.radixSort(arr1);
        System.out.println(Arrays.toString(arr1));
        System.out.println();

        int[] arr2 = {170,45,75,90,0,802,2};
        System.out.println(Arrays.toString(arr2));
        obj.radixSort(arr2);
        System.out.println(Arrays.toString(arr2));
        System.out.println();
    }



    public void radixSort(int[] arr) {

        // Step-1 : find the largest element of the array
        int largestElement = arr[0];
        for(int i=1; i<arr.length; i++)
            if(largestElement < arr[i]) largestElement = arr[i];


        // Step-2 : run count sort for each digit of the element from the LSB
        int numberOfDigitsInLargestElement = (int) Math.log10(largestElement)+1;
        for(int digitIndexFromLast=0; digitIndexFromLast<numberOfDigitsInLargestElement; digitIndexFromLast++) {
            countSort(arr,digitIndexFromLast);
        }
    }


    // for last index     : place = 1
    // for 2nd last index : place = 10
    // for 3rd last index : place = 100
    public void countSort(int[] arr, int digitIndexFromLast){

        // Step-1 : each digit can be from 0 -> 9 hence take array of 10 length
        int[] prefixSumArrOfFrequency = new int[10];


        // Step-2 : prepare the prefix sum array of the frequencies
        int place = (int) Math.pow(10, digitIndexFromLast);
        for(int num : arr){
            int digitAtGivenPlace = (num/place)%10;
            prefixSumArrOfFrequency[digitAtGivenPlace] = prefixSumArrOfFrequency[digitAtGivenPlace] + 1;
        }
        for(int i=1; i<prefixSumArrOfFrequency.length; i++) {
            prefixSumArrOfFrequency[i] = prefixSumArrOfFrequency[i-1] + prefixSumArrOfFrequency[i];
        }
        // NOTE : we can see that prefixSumArrOfFrequency contains last position of each element


        // Step-3 : iterate through input array from last
        //          and keep putting every element at its correct last position
        int[] output = new int[arr.length];
        for(int i=arr.length-1; i>=0; i--) {
            int digitAtGivenPlace = (arr[i]/place)%10;
            int elementLastPosition = prefixSumArrOfFrequency[digitAtGivenPlace]-1;
            output[elementLastPosition] = arr[i];

            // decrease the value so that in the next iteration we get another element's correct position
            prefixSumArrOfFrequency[digitAtGivenPlace] = prefixSumArrOfFrequency[digitAtGivenPlace]-1;
        }

        // Step-4 : copy all the sorted values from output array to input array
        for(int i=0; i<output.length; i++)
            arr[i] = output[i];
    }

}