package com.sumit.datastructures.b_recursion.a_basics;

public class Recursion6_SumOfDigits {

    public static void main(String[] args) {
        System.out.println(sumOfDigits_1(3124));
        System.out.println(sumOfDigits_2(3124));

        System.out.println(sumOfDigits_1(0));
        System.out.println(sumOfDigits_2(0));

        System.out.println(sumOfDigits_1(1234567891));
        System.out.println(sumOfDigits_2(1234567891));
    }


    // Approach-1 : iteration
    private static int sumOfDigits_1(int n) {
        int sum = 0;

        while(n > 0){
            sum = sum + n%10;
            n = n/10;
        }
        return sum;
    }



    // Approach-2 : recursion
    private static int sumOfDigits_2(int n) {
        if(n < 10)
            return n;

        return n%10 + sumOfDigits_2(n/10);
    }
}