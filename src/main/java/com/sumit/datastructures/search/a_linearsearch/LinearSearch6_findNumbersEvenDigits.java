package com.sumit.datastructures.search.a_linearsearch;

import java.util.Arrays;

public class LinearSearch6_findNumbersEvenDigits {

    public static void main(String[] args) {
        int[] arr = {121, 345, 2, 31, 7196};
        System.out.println("Input array : " + Arrays.toString(arr));

        int evenDigitElementsCount =  findNumbersCountWithEvenDigits(arr);
        System.out.println("Even digit elements count : " + evenDigitElementsCount);
    }

    private static int findNumbersCountWithEvenDigits(int[] arr){
        int count=0;
        for(int num : arr){
            if(countNumberOfDigits_1(num) % 2 == 0)
                count++;
        }
        return count;
    }

    // Better approach because we are not using string manipulation
    // also not using any in-built method.
    private static int countNumberOfDigits_1(int num){
        int count = 0;
        while(num > 0) {
            num = num/10;
            count++;
        }
        return count;
    }

    private static int countNumberOfDigits_2(int num){
        return String.valueOf(num).length();
    }

}