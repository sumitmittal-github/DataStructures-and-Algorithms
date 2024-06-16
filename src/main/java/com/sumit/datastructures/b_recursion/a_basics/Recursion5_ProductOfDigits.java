package com.sumit.datastructures.b_recursion.a_basics;

public class Recursion5_ProductOfDigits {

    public static void main(String[] args) {
        System.out.println(productOfDigits_1(3124));
        System.out.println(productOfDigits_2(3124));

        System.out.println(productOfDigits_1(0));
        System.out.println(productOfDigits_2(0));

        System.out.println(productOfDigits_1(12340));
        System.out.println(productOfDigits_2(12340));

        System.out.println(productOfDigits_1(1234));
        System.out.println(productOfDigits_2(1234));
    }



    // Approach-1 : iteration
    private static int productOfDigits_1(int n) {
        if(n <= 0)
            return 0;

        int product = 1;
        while(n > 0){
            product = product * (n%10);
            n = n/10;
        }
        return product;
    }



    // Approach-2 : recursion
    private static int productOfDigits_2(int n) {
        if(n < 10)
            return n;

        return (n%10) * productOfDigits_2(n/10);
    }



}