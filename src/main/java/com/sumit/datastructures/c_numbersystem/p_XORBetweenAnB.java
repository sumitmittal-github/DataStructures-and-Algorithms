package com.sumit.datastructures.c_numbersystem;

public class p_XORBetweenAnB {

    public static void main(String[] args) {
        System.out.println("XOR from 3 to 9 is : " + calculateXORBetweenNums(3, 9));
        System.out.println("XOR from 3 to 9 is : " + calculateXORBetweenNums2(3, 9));

        System.out.println("XOR from 100 to 136 is : " + calculateXORBetweenNums(100, 136));
        System.out.println("XOR from 100 to 136 is : " + calculateXORBetweenNums2(100, 136));

        System.out.println("XOR from 0 to 12 is : " + calculateXORBetweenNums(0, 12));
        System.out.println("XOR from 0 to 12 is : " + calculateXORBetweenNums2(0, 12));
    }

    // bad approach because it will give "time limit exceed" error for large numbers.
    private static int calculateXORBetweenNums(int a, int b) {
        int result=0;
        for( int i=a; i<=b; i++) {
            result = result ^ i;
        }
        return result;
    }


    // Best approach, because time complexity = O(1)
    private static int calculateXORBetweenNums2(int a, int b) {
        // XOR(a -> b) =  XOR(0 -> b) ^ XOR(0 -> a-1)
        return calculateXORFrom0toN(b) ^ calculateXORFrom0toN(a-1);
    }

    private static int calculateXORFrom0toN(int n) {
        int modulo = n%4;
        if(modulo == 0) return n;
        else if(modulo == 1) return 1;
        else if(modulo == 2) return n+1;
        else return 0;
    }

}