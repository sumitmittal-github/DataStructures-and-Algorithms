package com.sumit.datastructures.c_numbersystem;

public class e_setNthBitAs1 {

    /**
     * Program : Set nth bit of any number to 1. If it is already 1 then no change else change it to 1.
     * Ex: for 182 in binary =>   1   0   1   1   0   1   1   0
     *                           8th 7th 6th 5th 4th 3rd 2nd 1st
     * 4th bit to 1 => 1   0   1   1   0   1   1   0
     * 5th bit to 1 => No change
     *
     * Concept  : if we OR any digit (0/1) with 1 then it will always be 1
     *  mask = 1 << (n-1)
     */

    public static void main(String[] args) {
        //decimal = 182       =>        binary : 10110110
        System.out.println("4th Bit : " + changeNthDigit(182, 4));      //10111110 = 190
        System.out.println("5th Bit : " + changeNthDigit(182, 5));      //No change
        System.out.println("6th Bit : " + changeNthDigit(182, 6));      //No change
        System.out.println("7th Bit : " + changeNthDigit(182, 7));      //11110110 = 246
    }

    public static int changeNthDigit(int num, int n) {
        int mask = 1 << (n-1);
        return num | mask;
    }

}