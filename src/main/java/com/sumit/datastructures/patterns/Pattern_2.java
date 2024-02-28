package com.sumit.datastructures.patterns;

public class Pattern_2 {

/**
     * * * * * *
     * * * * *
     * * * *
     * * *
     * *
     *
 */
    public static void main(String[] args) {
        pattern(4);
    }

    private static void pattern(int n){
        for (int row = 1; row <= n ; row++) {
            for (int col = n; col >= row ; col--) {
                System.out.print("* ");
            }
            System.out.println("");
        }
    }

}