package com.sumit.datastructures.recursion.a_level1;

public class Recursion3_Factorial {

    public static void main(String[] args) {
        System.out.println(factorialByGeneralApproach(5));
        System.out.println(factorialByRecursion(5));
    }

    private static int factorialByGeneralApproach(int num) {
        int fact=1;
        while(num > 1){
            fact = fact * num;
            num--;
        }
        return fact;
    }

    private static int factorialByRecursion(int num) {
        if(num <= 1)
            return 1;
        return num * factorialByRecursion(num-1);
    }


}