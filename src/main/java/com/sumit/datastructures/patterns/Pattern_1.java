package com.sumit.datastructures.patterns;

public class Pattern_1 {

/*
            *
            * *
            * * *
            * * * *
            * * * * *
            * * * * * *
*/
    public static void main(String[] args) {
        pattern(6);
    }

    private static void pattern(int n){
        for (int row = 1; row <= n ; row++) {
            for (int col = 1; col <=row ; col++) {
                System.out.print("* ");
            }
            System.out.println("");
        }
    }

}