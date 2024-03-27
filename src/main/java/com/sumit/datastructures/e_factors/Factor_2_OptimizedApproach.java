package com.sumit.datastructures.e_factors;

public class Factor_2_OptimizedApproach {

    public static void main(String[] args) {
        System.out.println("Factors of num 20 are : ");
        factors(20);

        System.out.println();
        System.out.println();

        System.out.println("Factors of num 36 are : ");
        factors(36);
    }

    // Space Complexity = O(1)
    // Time Complexity  = sqrt(n)
    private static void factors(int num) {
        //for (int i = 1; i*i <= num; i++) {
        //              OR
        for (int i = 1; i <= Math.sqrt(num); i++) {
            if(num % i == 0){
                // to prevent condition like factors of 36, where 1 set will be 6 * 6. so to reduce duplicate factors
                if(num/i == i)
                    System.out.print(i + " ");
                else
                    System.out.print(i + " " + num/i + " ");
            }
        }
    }

    // Comment : Factors of above algo will not be in sorted order,
    // but we can store n/i in another list and can print that list in last in reverse order.

}