package com.sumit.datastructures.search.a_linearsearch;

import java.util.Arrays;

public class LinearSearch6_findNumbersEvenDigits {

    // https://leetcode.com/problems/find-numbers-with-even-number-of-digits/

    public static void main(String[] args) {
        int[] arr = {121, 345, 0, 31, 7196};
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
        // num 0 has 1 digit.
        // if we will not handle this condition here then this method will return count as 0,
        // and 0%2 ==> 0. will be added in even category.
        if(num == 0)
            return 1;

        // making number positive if it is negative
        if(num < 0)
            num = num * -1;

        int count = 0;
        while(num > 0) {
            num = num/10;
            count++;
        }
        return count;
    }

    private static int countNumberOfDigits_2(int num){
        if(num == 0)
            return 1;

        if(num < 0)
            num = num * -1;

        return String.valueOf(num).length();
    }

    private static int countNumberOfDigits_3(int num) {
        if(num == 0)
            return 1;

        if(num < 0)
            num = num * -1;

        return (int)(Math.log10(num)) + 1;
    }

}