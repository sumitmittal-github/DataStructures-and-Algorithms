package com.sumit.datastructures.b_patterns;

public class Pattern_4 {

/**
         *
         * *
         * * *
         * * * *
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
        for (int row = 1; row <= 2*n+1 ; row++) {

            int totalColumnsInRow = -1;
            if(row <= n+1)
                totalColumnsInRow = row;
            else
                totalColumnsInRow = 2*n - row +2;

            for (int col = 1; col <= totalColumnsInRow ; col++) {
                System.out.print("* ");
            }
            System.out.println("");
        }
    }

}