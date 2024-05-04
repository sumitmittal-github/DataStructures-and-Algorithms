package com.sumit.datastructures.j_recursion.a_basics;

// find nth Fibonacci number
// Series : 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55 .....
// Index  : 0  1  2  3  4  5  6  7   8   9   10

public class Recursion1_FibonacciNumber {

    // LeetCode-509 : https://leetcode.com/problems/fibonacci-number/description/

    public static void main(String[] args) {
        System.out.println(getNthFibonacciNumber_3(0));
        System.out.println(getNthFibonacciNumber_3(1));
        System.out.println(getNthFibonacciNumber_3(4));
        System.out.println(getNthFibonacciNumber_3(8));
        System.out.println(getNthFibonacciNumber_3(10));
    }


    // Approach-1 : by iteration
    private static int getNthFibonacciNumber_1(int n){
        if(n < 2)
            return n;

        int a=0, b=1, ans=0;
        for(int i=2; i<=n; i++){
            ans=a+b;
            a=b;
            b=ans;
        }
        return ans;
    }


    // Approach-2 : by recursion
    private static int getNthFibonacciNumber_2(int n){
        // base condition
        if(n < 2)
            return n;

        // recurrence relation
        return getNthFibonacciNumber_2(n-1) +getNthFibonacciNumber_2(n-2);
    }


    // Approach-3 : by formula
    private static long getNthFibonacciNumber_3(int n){
        double squareRoot5 = Math.sqrt(5);

        double p1 = 1 + squareRoot5;
        double p2 = 1 - squareRoot5;

        double part1 = Math.pow(  (p1/2),  n);
        double part2 = Math.pow(  (p2/2),  n);

        return (long)(   (part1-part2) / squareRoot5   );
    }


}