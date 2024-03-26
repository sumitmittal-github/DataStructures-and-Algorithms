package com.sumit.datastructures.mixprograms;

public class Palindrome {

    public static void main(String[] args) {
/*
        System.out.println("null : " + isPalindrome(null));
        System.out.println(" : " + isPalindrome(""));
        System.out.println("a : " + isPalindrome("a"));
        System.out.println("aa : " + isPalindrome("aa"));
        System.out.println("ab : " + isPalindrome("ab"));
        System.out.println("aba : " + isPalindrome("aba"));
        System.out.println("abc : " + isPalindrome("abc"));
        System.out.println("abba : " + isPalindrome("abba"));
        System.out.println("abca : " + isPalindrome("abca"));
        System.out.println("abcBA : " + isPalindrome("abcBA"));
        System.out.println("abcab : " + isPalindrome("abcab"));
*/


        System.out.println(isPalindromeByRecursion(121));
        System.out.println(isPalindromeByRecursion(1221));
        System.out.println(isPalindromeByRecursion(123421));
        System.out.println(isPalindromeByRecursion(11));
        System.out.println(isPalindromeByRecursion(1));
    }

    private static boolean isPalindrome(String str) {
        if(str == null || str.length() == 0)
            return false;

        if(str.length() == 1)
            return true;

        // to handle the case sensitivity
        str = str.toLowerCase();

        int start = 0;
        int end = str.length()-1;

        while(start <= end) {
            if(str.charAt(start) == str.charAt(end)){
                start++;
                end--;
            } else
                return false;
        }
        return true;
    }

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