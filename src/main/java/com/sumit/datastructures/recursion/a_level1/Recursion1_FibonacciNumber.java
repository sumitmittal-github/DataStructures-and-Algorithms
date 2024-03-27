package com.sumit.datastructures.recursion.a_level1;

// find nth Fibonacci number
// Series : 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55 .....
// Index  : 0  1  2  3  4  5  6  7   8   9   10

public class Recursion1_FibonacciNumber {

    public static void main(String[] args) {
        System.out.println(getNthFibonacciNumber(0));
        System.out.println(getNthFibonacciNumber(1));
        System.out.println(getNthFibonacciNumber(4));
        System.out.println(getNthFibonacciNumber(8));
        System.out.println(getNthFibonacciNumber(10));
    }

    private static int getNthFibonacciNumber(int n){
        // base condition
        if(n < 2)
            return n;

        // recurrence relation
        return getNthFibonacciNumber(n-1) +getNthFibonacciNumber(n-2);
    }


}