package com.sumit.datastructures.j_recursion.a_basics;

public class Recursion4_SumOfNto1 {

    public static void main(String[] args) {
        System.out.println(sum(5));
        System.out.println(sum(10));
    }

    private static int sum(int n){
        if (n <= 1)
          return 1;

        return n + sum(n-1);
    }


}