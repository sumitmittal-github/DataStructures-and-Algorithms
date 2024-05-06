package com.sumit.datastructures.j_recursion.b_strings;

public class String6_LongestPalindrome {

    // LeetCode-409 : https://leetcode.com/problems/longest-palindrome/description/

    public int longestPalindrome(String s) {
        int[] chars = new int[128];
        for(char c : s.toCharArray()){
            chars[c]++;
        }
        int single = 0;
        for(int n:chars){
            if((n&1) == 1){
                single++;
            }
        }
        return single>1 ? s.length()-single+1 : s.length();
    }

    public static void main(String[] args) {
        String6_LongestPalindrome obj = new String6_LongestPalindrome();
        System.out.println(obj.longestPalindrome("abccccdd"));
        System.out.println(obj.longestPalindrome("a"));
    }


}
