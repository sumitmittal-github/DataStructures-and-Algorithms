package com.sumit.datastructures.factors;

public class Factor_1_GeneralApproach {

    public static void main(String[] args) {
        System.out.println("Factors of num 20 are : ");
        factors(20);
    }

    // Space Complexity - O(1)
    // Time Complexity  - O(n)
    private static void factors(int num) {
        for (int i = 1; i <= num; i++) {
            if(num % i == 0)
                System.out.print(i + " ");
        }
    }

}