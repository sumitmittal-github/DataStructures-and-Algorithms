package com.sumit.datastructures.mixprograms;

import java.util.ArrayList;
import java.util.List;

public class PrimeNumber {

    public static void main(String[] args) {
        System.out.println("4 is prime : "+ isPrime(4));
        System.out.println("7 is prime : "+ isPrime(7));
        System.out.println("10 is prime : "+ isPrime(10));
        System.out.println("17 is prime : "+ isPrime(17));
        System.out.println("123 is prime : "+ isPrime(123));
        System.out.println("1117111111 is prime : "+ isPrime(1117111111));

        int n=36;
        System.out.println("All prime numbers till " + n + " are : " + findAllPrimeNumbersTillN(n));
    }


    // Complexity = sqrt(n)
    private static boolean isPrime(int inputNumber){
        if(inputNumber <= 1)
            return false;

        int num=2;
        while(num*num <= inputNumber) {
            if(inputNumber % num == 0)
                return false;
            ++num;
        }
        return true;
    }



    // bad approach because complexity will be n*sqrt(n)
    private static List<Integer> findAllPrimeNumbersTillN(int n){
        List<Integer> primeNums = new ArrayList<>();
        for(int i=1; i<=n ; i++) {
            if(isPrime(i))
                primeNums.add(i);
        }
        return primeNums;
    }


}