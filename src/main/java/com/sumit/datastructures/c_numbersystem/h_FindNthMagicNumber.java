package com.sumit.datastructures.c_numbersystem;

public class h_FindNthMagicNumber {

    /** Problem : Ex: 6th Magic No ->
     *             STEP-1 :    write 6 in binary =>    1 1 0
     *             STEP-2 :    multiply with power of 5     1       1      0
     *                                                      5*5*5   5*5    5
     *  =>    0*(5)  +  1*(5*5)  +  1*(5*5*5)
     *  =>    150
     */

    public static void main(String[] args) {
        System.out.println("1st Magic Number : " + findNthMagicNumber(1));
        System.out.println("2nd Magic Number : " + findNthMagicNumber(2));
        System.out.println("3rd Magic Number : " + findNthMagicNumber(3));
        System.out.println("4th Magic Number : " + findNthMagicNumber(4));
        System.out.println("5th Magic Number : " + findNthMagicNumber(5));
        System.out.println("6th Magic Number : " + findNthMagicNumber(6));
    }

    /** Concept-1 : To know the LSB (Least Significant Bit) =>       & the number with 1
     *  Concept-2 : To skip the LSB (Least Significant Bit) =>       >> the number with 1 time
     */

    private static int findNthMagicNumber(int n){
        int magicNum = 0;
        int count=1;

        while(n > 0) {
            // STEP-1 : get the LSB
            int lsb = n & 1;

            // STEP-2 : calculate the magic number for this LSB
            if(lsb == 1) {
                magicNum = magicNum + (lsb * (int) Math.pow(5, count));
            }
            count++;

            // STEP-3 : skip the LSB
            n = n >> 1;
        }
        return magicNum;
    }



}