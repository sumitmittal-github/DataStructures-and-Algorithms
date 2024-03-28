package com.sumit.datastructures.j_recursion.a_basics;

public class Recursion5_ProductOfDigits {

    public static void main(String[] args) {
        System.out.println(productOfDigitsByGeneralApproach(3124));
        System.out.println(productOfDigitsByRecursion(3124));

        System.out.println(productOfDigitsByGeneralApproach(0));
        System.out.println(productOfDigitsByRecursion(0));

        System.out.println(productOfDigitsByGeneralApproach(12340));
        System.out.println(productOfDigitsByRecursion(12340));

        System.out.println(productOfDigitsByGeneralApproach(1234));
        System.out.println(productOfDigitsByRecursion(1234));
    }

    private static int productOfDigitsByGeneralApproach(int n) {
        if(n <= 0)
            return 0;

        int product = 1;
        while(n > 0){
            product = product * (n%10);
            n = n/10;
        }
        return product;
    }

    private static int productOfDigitsByRecursion(int n) {
        if(n < 10)
            return n;

        return (n%10) * productOfDigitsByRecursion(n/10);
    }
}