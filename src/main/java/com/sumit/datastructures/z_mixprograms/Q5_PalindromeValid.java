package com.sumit.datastructures.z_mixprograms;

public class Q5_PalindromeValid {

    // LeetCode-680 : https://leetcode.com/problems/valid-palindrome-ii/description/

    public boolean validPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;

        while(start <= end){
            if(s.charAt(start) == s.charAt(end)){
                start++;
                end--;
            }
            else
                return isPalindrome(s, start + 1, end) || isPalindrome(s, start, end - 1);
        }
        return true;
    }
    private boolean isPalindrome(String s, int i, int j){
        while(i <= j){
            if(s.charAt(i) == s.charAt(j)){
                i++;
                j--;
            }
            else
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Q5_PalindromeValid obj = new Q5_PalindromeValid();
        System.out.println(obj.validPalindrome("aba"));     // true
        System.out.println(obj.validPalindrome("abc"));     // false
        System.out.println(obj.validPalindrome("abca"));    // true
    }


}