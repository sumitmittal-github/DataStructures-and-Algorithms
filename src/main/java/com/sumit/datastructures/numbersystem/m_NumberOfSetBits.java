package com.sumit.datastructures.numbersystem;

public class m_NumberOfSetBits {

    public static void main(String[] args) {
        System.out.println(numberOfSetBits(1));         // 0000 0001
        System.out.println(numberOfSetBits2(1));         // 0000 0001

        System.out.println(numberOfSetBits(4));         // 0000 0100
        System.out.println(numberOfSetBits2(4));         // 0000 0100

        System.out.println(numberOfSetBits(7));         // 0000 0111
        System.out.println(numberOfSetBits2(7));         // 0000 0111

        System.out.println(numberOfSetBits(10));        // 0000 1010
        System.out.println(numberOfSetBits2(10));        // 0000 1010
    }

    private static int numberOfSetBits(int num) {
        int count = 0;
        while(num>0) {
            // STEP-1 : Calculate the LSB
            int lsb = num & 1;
            // STEP-2 : if LSB ==1 then count++
            if(lsb == 1)
                count++;
            // STEP-3 : skip the LSB
            num = num >> 1;
        }
        return count;
    }

    private static int numberOfSetBits2(int num) {
        int count = 0;
        while(num > 0) {
            // STEP-1 : Calculate the Right most set bit =>   (n & -n)
            // if num = 0011 0000  =>  rightmostSetBinary = 0001 0000
            int rightmostSetBinary = num & (~num+1);
            count++;

            // STEP-2 : Remove the right most set bit from the number.
            // Now after 1st iteration the number will be = 0010 0000
            num = num - rightmostSetBinary;
        }
        return count;
    }



}