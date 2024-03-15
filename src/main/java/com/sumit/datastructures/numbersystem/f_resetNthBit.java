package com.sumit.datastructures.numbersystem;

public class f_resetNthBit {

    /**
     * problem : Reset nth bit of any number. If it is 0 then make it 1. If it is 1 then make it 0.
     * Ex: for 182 in binary =>   1   0   1   1   0   1   1   0
     *                           8th 7th 6th 5th 4th 3rd 2nd 1st
     * reset 4th bit => 1   0   1   1   1   1   1   0 => 190
     * reset 5th bit => 1   0   1   0   0   1   1   0 => 166
     *
     * Concept  : if nth bit is 0 ->     OR nth digit with 1, to make it 1
     *            if nth bit is 1 ->    AND nth digit with 0, to make it 0
     */

    public static void main(String[] args) {
        //decimal = 182       =>        binary : 10110110
        System.out.println("4th Bit : " + resetNthBit(182, 4));      //10111110 => 190
        System.out.println("5th Bit : " + resetNthBit(182, 5));      //10100110 => 166
    }

    public static int resetNthBit(int num, int n) {
        int nthBit = checkNthBit(num, n);
        if(nthBit == 0){
            // if nth bit is 0, and we want to make it 1 then & that digit with 1
            int mask = 1 << (n-1);
            return num | mask;
        } else {
            // if nth bit is 1, and we want to make it 0 then & that digit with 0
            int maskCompliment = ~(1 << (n-1));
            return num & maskCompliment;
        }
    }

    public static int checkNthBit(int num, int n) {
        // AND nth digit with 1, if result==0, then nth bit = 0, else nth bit = 1;
        int mask = 1 << (n-1);
        int nthBitVal = num & mask;
        if(nthBitVal == 0)
            return 0;
        else
            return 1;
    }

}