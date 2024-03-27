package com.sumit.datastructures.b_patterns;

public class Pattern_1 {

/**
    n=4
    *
    * *
    * * *
    * * * *
*/
    public static void main(String[] args) {
        pattern(6);
        patternWithRecursion(6);
    }


    // Way-1 : basic approach
    public static void pattern(int n){
        for (int row = 1; row <= n ; row++) {
            for (int col = 1; col <=row ; col++) {
                System.out.print("* ");
            }
            System.out.println("");
        }
    }


    // Way-2 : with recursion
    public static void patternWithRecursion(int n){
        int row=0;
        int col=0;
        helper(n, row, col);
    }

    private static void helper(int n, int row, int col){
        if(row == n)
            return;

        if(row >= col) {
            System.out.print("* ");
            helper(n, row, col+1);
        } else {
            System.out.println();
            helper(n, row+1, 0);
        }
    }

}