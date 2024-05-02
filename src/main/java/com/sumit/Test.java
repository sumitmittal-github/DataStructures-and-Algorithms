package com.sumit;

public class Test {

    public static void main(String[] args) {

        double part1 = (1+Math.sqrt(5))/2;      // 1.618
        double part2 = (1-Math.sqrt(5))/2;      //-0.618
        double part3 = Math.sqrt(5);      //-0.618
        System.out.println(part1);
        System.out.println(part2);
        System.out.println(part3);





    }


    public static int factorial(int n){
        if(n == 1)
            return 1;

        return n * factorial(n-1);
    }



    public static int fibonacciNthTerm(int n){
        if(n == 0) return 0;
        if(n == 1) return 1;

        return fibonacciNthTerm(n-1) + fibonacciNthTerm(n-2);
    }

}