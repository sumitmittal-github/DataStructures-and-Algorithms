package com.sumit.datastructures.numbersystem;

import java.util.Arrays;

public class g_NumbersAppearedNTimes {

    /** Problem : In an array, every number is appearing n times, except 1 number. find that number.
     * Ex: [2,2,5,2,7,7,8,7,8,8]
     * In above array all numbers are appearing 3 times, except 5. => Answer = 5
    */
    public static void main(String[] args) {
        int[] arr = {2,2,5,2,7,7,8,7,8,8};
        int repetitionCount = 3;

        System.out.println("Input Array : " + Arrays.toString(arr));
        int uniqueNumber = findUniqueNumberFromNTimesRepeatedArray(arr, repetitionCount);
        System.out.println("Unique Number : " + uniqueNumber);
    }

    public static int findUniqueNumberFromNTimesRepeatedArray(int[] arr, int repetitionCount) {

        // STEP-1 : add total set bits for each number in its all 8 bits
        int[] totalSetBitsArr = new int[8];
        for(int num : arr) {
            if(isNthIndexDigitIsOne(num, 1))
                totalSetBitsArr[7] = totalSetBitsArr[7]+1;
            if(isNthIndexDigitIsOne(num, 2))
                totalSetBitsArr[6] = totalSetBitsArr[6]+1;
            if(isNthIndexDigitIsOne(num, 3))
                totalSetBitsArr[5] = totalSetBitsArr[5]+1;
            if(isNthIndexDigitIsOne(num, 4))
                totalSetBitsArr[4] = totalSetBitsArr[4]+1;
            if(isNthIndexDigitIsOne(num, 5))
                totalSetBitsArr[3] = totalSetBitsArr[3]+1;
            if(isNthIndexDigitIsOne(num, 6))
                totalSetBitsArr[2] = totalSetBitsArr[2]+1;
            if(isNthIndexDigitIsOne(num, 7))
                totalSetBitsArr[1] = totalSetBitsArr[1]+1;
            if(isNthIndexDigitIsOne(num, 8))
                totalSetBitsArr[0] = totalSetBitsArr[0]+1;
        }
        //System.out.println("Total Set Bits Array : " + Arrays.toString(totalSetBitsArr));
        //O/p=> Total Set Bits Array : [0, 0, 0, 0, 3, 4, 6, 4]


        // STEP-2 : Modulo each set bits count with 3 (the number of repetition)
        for(int i=0; i<8; i++) {
            totalSetBitsArr[i] = totalSetBitsArr[i] % repetitionCount;
        }
        //System.out.println("Total Set Bits Array Reminder : " + Arrays.toString(totalSetBitsArr));
        //O/p=> Total Set Bits Array Reminder : [0, 0, 0, 0, 0, 1, 0, 1]


        // STEP-3 : Convert above array number to Decimal number
        int num = 0;
        for(int i=7; i>=0; i--) {
            int setBitCountReminder = totalSetBitsArr[i];
            int powerOf2 = 8-i-1;
            num =  num + (int)(setBitCountReminder * Math.pow(2, powerOf2));
        }
        return num;
    }

    private static boolean isNthIndexDigitIsOne(int num, int n) {
        // AND nth digit with 1, if result==0, then nth bit = 0, else nth bit = 1;
        int mask = 1 << (n-1);
        int nthBitVal = num & mask;
        return (nthBitVal != 0);
    }

}