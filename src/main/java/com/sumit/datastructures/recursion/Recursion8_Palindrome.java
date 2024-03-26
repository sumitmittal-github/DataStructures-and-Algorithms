package com.sumit.datastructures.recursion;

public class Recursion8_Palindrome {

    public static void main(String[] args) {
        System.out.println(isPalindromeByRecursion(121));
        System.out.println(isPalindromeByRecursion(1221));
        System.out.println(isPalindromeByRecursion(123421));
        System.out.println(isPalindromeByRecursion(11));
        System.out.println(isPalindromeByRecursion(1));
    }


    // Way-1 : by using helper function
    private static boolean isPalindromeByRecursion(int num) {
        int revNum = reverseNumByRecursion(num);
        return revNum == num;
    }

    private static int reverseNumByRecursion(int num){
        if(num < 10)
            return num;

        int numOfDigitsInNum = (int)Math.log10(num)+1;
        return ((num%10) * (int)Math.pow(10, numOfDigitsInNum-1)) + reverseNumByRecursion(num/10);
    }




}