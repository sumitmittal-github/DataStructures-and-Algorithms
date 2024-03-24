package com.sumit.datastructures.primenumber;

import java.util.ArrayList;
import java.util.List;

public class PrimeNumber_2_AllPrimesTillN {

    public static void main(String[] args) {
        int n=36;
        System.out.println("All prime numbers till " + n + " are : " + findAllPrimeNumbersTillN(n));
    }

    // bad approach because complexity will be          = n * sqrt(n)
    // Better approach is SOE - Sieve of Eratosthenes   = n * log(log n)
    private static List<Integer> findAllPrimeNumbersTillN(int n){
        List<Integer> primeNums = new ArrayList<>();
        for(int i=1; i<=n ; i++) {
            if(isPrime(i))
                primeNums.add(i);
        }
        return primeNums;
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


}