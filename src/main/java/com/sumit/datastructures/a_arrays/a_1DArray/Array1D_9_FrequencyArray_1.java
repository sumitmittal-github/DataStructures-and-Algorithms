package com.sumit.datastructures.a_arrays.a_1DArray;

public class Array1D_9_FrequencyArray_1 {

    // Program : check if the given elements is present in the input array
    //Note : value of all the elements in the array is less than 10 to the power of 5.

    public static void main(String[] args) {
        Array1D_9_FrequencyArray_1 obj = new Array1D_9_FrequencyArray_1();
        int[] inputArr = {1,4,6,8,44,56,345,901};
        int[] targetNums = {43,56,344,901, 999};
        obj.isPresent(inputArr, targetNums);
    }

    public void isPresent(int[] inputArr, int[] targetNums) {

        int[] frequencyArray = new int[10 * 10 * 10 * 10 * 10];

        // STEP-1 : prepare frequency array
        for(int i=0; i<inputArr.length; i++){
            int val = inputArr[i];
            int indexOfFrequencyArr = frequencyArray[val];
            frequencyArray[val] = indexOfFrequencyArr+1;
        }

        // STEP-2 : get results from frequency array
        for (int i = 0; i < targetNums.length; i++) {
            int elementToCheck = targetNums[i];
            if (frequencyArray[elementToCheck] > 0)
                System.out.println("Number : " + elementToCheck + " is present in the input array");
            else
                System.out.println("Number : " + elementToCheck + " is not present in the input array");
        }
    }


}