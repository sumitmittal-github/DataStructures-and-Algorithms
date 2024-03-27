package com.sumit.datastructures.g_primenumber;

public class PrimeNumber_1_CheckIsPrime {

    public static void main(String[] args) {
        System.out.println("4 is prime : "+ isPrime(4));
        System.out.println("7 is prime : "+ isPrime(7));
        System.out.println("10 is prime : "+ isPrime(10));
        System.out.println("17 is prime : "+ isPrime(17));
        System.out.println("123 is prime : "+ isPrime(123));
        System.out.println("1117111111 is prime : "+ isPrime(1117111111));
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