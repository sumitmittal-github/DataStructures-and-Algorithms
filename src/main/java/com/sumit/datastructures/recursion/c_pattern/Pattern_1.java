package com.sumit.datastructures.recursion.c_pattern;

public class Pattern_1 {

/**  n=4
     * * * *
     * * *
     * *
     *
 */
    public static void main(String[] args) {
        pattern(4);
        patternWithoutForLoop(4);
    }


    // Way-1 : not a good approach because we are using for loop, instead use recursion
    private static void pattern(int n){
        if(n == 0)
            return;

        for(int i=0; i<n; i++)
            System.out.print("* ");
        System.out.println();

        pattern(n-1);
    }


    // Way-2 : without for loop
    private static void patternWithoutForLoop(int n){
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