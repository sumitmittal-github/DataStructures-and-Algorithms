package com.sumit.datastructures.a_basics.d_squareroot;

public class SquareRoot_1_Basic {

    // basic approach : checking from 2 till i*i if it matches n

    public static void main(String[] args) {
        System.out.println("Square root of 81 is : " + findSquareRoot(81));
        System.out.println("Square root of 82 is : " + findSquareRoot(82));
        System.out.println("Square root of 4 is : " + findSquareRoot(4));
    }

    private static int findSquareRoot(int n) {
        for(int i = 2; i*i <= n; i++){
            if(n == i*i)
                return i;
        }
        return Integer.MIN_VALUE;
    }

}