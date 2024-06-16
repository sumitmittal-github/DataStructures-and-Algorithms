package com.sumit.datastructures.b_recursion.a_basics;

public class Recursion8_Palindrome {

    public static void main(String[] args) {
        System.out.println(isPalindromeByRecursion(121));
        System.out.println(isPalindromeByRecursion2(121));

        System.out.println(isPalindromeByRecursion(1221));
        System.out.println(isPalindromeByRecursion2(1221));

        System.out.println(isPalindromeByRecursion(123421));
        System.out.println(isPalindromeByRecursion2(123421));

        System.out.println(isPalindromeByRecursion(11));
        System.out.println(isPalindromeByRecursion2(11));

        System.out.println(isPalindromeByRecursion(1));
        System.out.println(isPalindromeByRecursion2(1));
    }


    // Approach-1 : by using helper function and checking =>   num == rev(num)
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


    // Approach-2 : by using helper function and checking =>   indexes from start and end of the number in string
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