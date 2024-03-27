package com.sumit.datastructures.recursion.c_pattern;

public class Pattern_2 {

/**  n=4
     *
     * *
     * * *
     * * * *
 */
    public static void main(String[] args) {
        pattern(4);
    }


    private static void pattern(int n){
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