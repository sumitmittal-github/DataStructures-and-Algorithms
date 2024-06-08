package com.sumit.datastructures.z_mixprograms;

public class Q6_PalindromeLongest {

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
        Q6_PalindromeLongest obj = new Q6_PalindromeLongest();
        System.out.println(obj.longestPalindrome("abccccdd"));
        System.out.println(obj.longestPalindrome("a"));
    }


}
