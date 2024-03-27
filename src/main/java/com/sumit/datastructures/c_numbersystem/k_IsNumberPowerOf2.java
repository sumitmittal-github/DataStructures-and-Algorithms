package com.sumit.datastructures.c_numbersystem;

public class k_IsNumberPowerOf2 {

    public static void main(String[] args) {
        System.out.println("Is 0 power of 2 : " + isPowerOf2ByRightShift(0));
        System.out.println("Is 0 power of 2 : " + isPowerOf2ByAnd(0));

        System.out.println("Is 1 power of 2 : " + isPowerOf2ByRightShift(1));
        System.out.println("Is 1 power of 2 : " + isPowerOf2ByAnd(1));

        System.out.println("Is 2 power of 2 : " + isPowerOf2ByRightShift(2));
        System.out.println("Is 2 power of 2 : " + isPowerOf2ByAnd(2));

        System.out.println("Is 35 power of 2 : " + isPowerOf2ByRightShift(35));
        System.out.println("Is 35 power of 2 : " + isPowerOf2ByAnd(35));

        System.out.println("Is 88 power of 2 : " + isPowerOf2ByRightShift(88));
        System.out.println("Is 88 power of 2 : " + isPowerOf2ByAnd(88));

        System.out.println("Is 128 power of 2 : " + isPowerOf2ByRightShift(128));
        System.out.println("Is 128 power of 2 : " + isPowerOf2ByAnd(128));

        System.out.println("Is 130 power of 2 : " + isPowerOf2ByRightShift(130));
        System.out.println("Is 130 power of 2 : " + isPowerOf2ByAnd(130));
    }


    private static boolean isPowerOf2ByRightShift(int num) {
        // Logic : if count of 1 is == 1 then power of 2, else no.
        int countof1s = 0;
        int lsb = 0;

        while(num > 0){
            lsb = num & 1;
            if(lsb == 1) countof1s++;
            num = num>>1;
        }

        return (countof1s == 1);
    }

    private static boolean isPowerOf2ByAnd(int num) {
        if (num == 0)
            return false;

        // Logic : if n & (n-1) == 0  => power of 2
        return (num & (num-1)) == 0;
    }

}