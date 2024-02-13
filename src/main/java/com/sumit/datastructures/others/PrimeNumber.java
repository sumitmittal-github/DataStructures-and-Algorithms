package com.sumit.datastructures.others;

public class PrimeNumber {

    public static void main(String[] args) {
        System.out.println("4 is prime : "+ isPrime(4));
        System.out.println("7 is prime : "+ isPrime(7));
        System.out.println("10 is prime : "+ isPrime(10));
        System.out.println("17 is prime : "+ isPrime(17));
        System.out.println("123 is prime : "+ isPrime(123));
        System.out.println("1117111111 is prime : "+ isPrime(1117111111));
    }


    private static boolean isPrime(int inputNumber){
        boolean isPrime=true;
        int num=2;
        while(num*num <= inputNumber) {
            if(inputNumber % num == 0) {
                isPrime=false;
                break;
            } else {
                ++num;
            }
        }
        return isPrime;
    }


}