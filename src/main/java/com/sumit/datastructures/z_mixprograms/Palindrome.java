package com.sumit.datastructures.z_mixprograms;

public class Palindrome {

    public static void main(String[] args) {

        // Approach-1
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


        // Approach-2
        System.out.println(isPalindromeByRecursion(121));
        System.out.println(isPalindromeByRecursion(1221));
        System.out.println(isPalindromeByRecursion(123421));
        System.out.println(isPalindromeByRecursion(11));
        System.out.println(isPalindromeByRecursion(1));


        // Approach-3
        System.out.println(isPalindromeByRecursion2(121));
        System.out.println(isPalindromeByRecursion2(1221));
        System.out.println(isPalindromeByRecursion2(123421));
        System.out.println(isPalindromeByRecursion2(11));
        System.out.println(isPalindromeByRecursion2(1));
    }


    // Approach-1 : general indexes approach
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


    // Approach-2 : by using helper function and checking =>   num == rev(num)
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


    // Approach-3 : by using helper function and checking =>   indexes from start and end of the number in string
    private static boolean isPalindromeByRecursion2(int num) {
        String numStr = String.valueOf(num);
        int startIndex = 0;
        int endIndex = numStr.length()-1;
        return isPalindromeByRecursion2Helper(numStr, startIndex, endIndex);
    }

    private static boolean isPalindromeByRecursion2Helper(String numStr, int startIndex, int endIndex){
        if(startIndex >= endIndex)
            return true;
        if(numStr.charAt(startIndex) != numStr.charAt(endIndex))
            return false;

        return isPalindromeByRecursion2Helper(numStr, ++startIndex, --endIndex);
    }

}