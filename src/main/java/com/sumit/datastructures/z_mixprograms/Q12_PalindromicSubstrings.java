package com.sumit.datastructures.z_mixprograms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Q12_PalindromicSubstrings {

    // Question : Given a string, return all the palindromic substrings.
    // Ex  : input = hello
    // all substrings = [h, he, hel, hell, hello
    //                   e, el, ell, ello
    //                   l, ll, llo
    //                   l, lo
    //                   o]
    // Palindromic Substrings = h, e, l, ll, o

    public Set<String> palindromicSubstrings(String input){
        if(input == null || input.isEmpty()) return null;

        Set<String> outputList = new HashSet<>();
        for(String str : getAllSubstrings(input)){
            if(isPalindrome(str))
                outputList.add(str);
        }
        return outputList;
    }

    public List<String> getAllSubstrings(String str){
        List<String> list = new ArrayList<>();
        for(int i=0; i<str.length(); i++){
            for(int j=i+1; j<=str.length(); j++){
                list.add(str.substring(i, j));
            }
        }
        return list;
    }


    // 2 pointer approach
    public boolean isPalindrome(String str){
        int i=0;
        int j=str.length()-1;

        while(i < j) {
            if(str.charAt(i) != str.charAt(j))
                return false;
            i++;
            j--;
        }
        return  true;
    }


    public static void main(String[] args) {
        Q12_PalindromicSubstrings obj = new Q12_PalindromicSubstrings();
        obj.palindromicSubstrings("hello").stream().forEach(System.out::println);
        System.out.println();

        obj.palindromicSubstrings("abcba").stream().forEach(System.out::println);
    }

}