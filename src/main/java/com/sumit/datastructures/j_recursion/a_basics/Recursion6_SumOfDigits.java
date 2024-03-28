package com.sumit.datastructures.j_recursion.a_basics;

public class Recursion6_SumOfDigits {

    public static void main(String[] args) {
        System.out.println(sumOfDigitsByGeneralApproach(3124));
        System.out.println(sumOfDigitsByRecursion(3124));

        System.out.println(sumOfDigitsByGeneralApproach(0));
        System.out.println(sumOfDigitsByRecursion(0));

        System.out.println(sumOfDigitsByGeneralApproach(1234567891));
        System.out.println(sumOfDigitsByRecursion(1234567891));
    }

    private static int sumOfDigitsByGeneralApproach(int n) {
        int sum = 0;

        while(n > 0){
            sum = sum + n%10;
            n = n/10;
        }
        return sum;
    }

    private static int sumOfDigitsByRecursion(int n) {
        if(n < 10)
            return n;

        return n%10 + sumOfDigitsByRecursion(n/10);
    }
}