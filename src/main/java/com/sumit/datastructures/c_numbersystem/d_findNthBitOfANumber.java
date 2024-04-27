package com.sumit.datastructures.c_numbersystem;

public class d_findNthBitOfANumber {

    /**
     * Program : Find nth bit of any number.
     * Ex  - for digit 182 find 4th, 5th, 6th, 7th bit
     * Sol - 182 in binary =>   1   0   1   1   0   1   1   0
     *                         8th 7th 6th 5th 4th 3rd 2nd 1st
     * 4th bit = 0
     * 5th bit = 1
     * 6th bit = 1
     * 7th bit = 0
     *
     * Concept : if we AND digit with 1 then we get the same digit
     *  therefor to get 4th digit & the input number with 00001000 now if we get 0 then it means 4th digit was 0, else 1.
     *
     *  to add 3 zeros on right hand side use left shift operator
     *  mask = 1 << (n-1)
     *
     */

    public static void main(String[] args) {
        //decimal = 177       =>        binary : 10110001
        System.out.println("4th Bit : " + findNthBit(177, 4));
        System.out.println("5th Bit : " + findNthBit(177, 5));
        System.out.println("6th Bit : " + findNthBit(177, 6));
        System.out.println("7th Bit : " + findNthBit(177, 7));
    }

    private static int findNthBit(int num, int n) {
        int mask = 1 << (n-1);
        int nthBitVal = num & mask;

        if (nthBitVal > 0)
            return 1;
        else
            return 0;
    }


}