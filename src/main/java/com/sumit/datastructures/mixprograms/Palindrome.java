package com.sumit.datastructures.mixprograms;

public class Palindrome {

    public static void main(String[] args) {
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

}