package com.sumit.datastructures.a_basics.a_patterns;

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
        patternWithRecursion(4);
        patternWithRecursionWithoutForLoop(4);
    }


    // Approach-1 : basic approach
    public static void pattern(int n){
        for (int row = 1; row <= n ; row++) {
            for (int col = n; col >= row ; col--) {
                System.out.print("* ");
            }
            System.out.println("");
        }
    }



    // Approach-2 : not a good approach because we are using for loop, instead use recursion
    public static void patternWithRecursion(int n){
        if(n == 0)
            return;

        for(int i=0; i<n; i++)
            System.out.print("* ");
        System.out.println();

        pattern(n-1);
    }



    // Approach-3 : without for loop
    public static void patternWithRecursionWithoutForLoop(int n){
        int row = 0;
        int col = 0;
        helper(n, row, col);
    }

    private static void helper(int n, int row, int col){
        if(row == n)
            return;

        if(row+col < n){
            System.out.print("* ");
            helper(n, row, ++col);
        } else {
            System.out.println();
            helper(n, ++row, 0);
        }
    }

}