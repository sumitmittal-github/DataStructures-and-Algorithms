package com.sumit.datastructures.j_recursion.e_questions;

import java.util.*;

public class Question1_LetterCombinationsPhoneNumber {

    //LeetCode-17 : https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/

    public static void main(String[] args) {
        System.out.println(new Question1_LetterCombinationsPhoneNumber().letterCombinations("846"));
        System.out.println(new Question1_LetterCombinationsPhoneNumber().countAllPermutations("846"));

        System.out.println(new Question1_LetterCombinationsPhoneNumber().letterCombinations("23"));
        System.out.println(new Question1_LetterCombinationsPhoneNumber().countAllPermutations("23"));

        System.out.println(new Question1_LetterCombinationsPhoneNumber().letterCombinations(""));
        System.out.println(new Question1_LetterCombinationsPhoneNumber().countAllPermutations(""));

        System.out.println(new Question1_LetterCombinationsPhoneNumber().letterCombinations("2"));
        System.out.println(new Question1_LetterCombinationsPhoneNumber().countAllPermutations("2"));

        System.out.println(new Question1_LetterCombinationsPhoneNumber().letterCombinations("2379"));
        System.out.println(new Question1_LetterCombinationsPhoneNumber().countAllPermutations("2379"));
    }

    // Returning all the permutations
    public List<String> letterCombinations(String digits) {
        if(digits == null || digits.trim().length()==0)
            return new ArrayList();
        return helper(digits, "");
    }

    String[] keypadArr = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    // indexes             0   1    2       3     4       5     6       7      8       9

    public List<String> helper(String digits, String answer) {
        List<String> list = new LinkedList<>();

        // base condition
        if(digits == null || digits.trim().length()==0) {
            list.add(answer);
            return list;
        }

        int firstDigit = Integer.parseInt(digits.substring(0,1));
        String possibleValues = keypadArr[firstDigit];

        // recursion calls. Ex - for 3 possible values, we need to make 3 recursion calls
        for(String str : possibleValues.split("")){
            List<String> answersFromBelowTree = helper(digits.substring(1), answer+str);
            list.addAll(answersFromBelowTree);
        }

        return list;
    }

    // Returning all the permutation counts
    public int countAllPermutations(String digits) {
        if(digits == null || digits.trim().length() == 0)
            return 0;

        return helperCount(digits, "");
    }

    public int helperCount(String digits, String answer){
        int count = 0;
        if(digits == null || digits.trim().length()==0) {
            System.out.println("1 possible permutation is : "+answer);
            return 1;
        }

        int firstDigit = Integer.parseInt(digits.substring(0, 1));
        String possibleValues = keypadArr[firstDigit];

        for(String str : possibleValues.split("")){
            Integer permutationCountsFromBelowTree = helperCount(digits.substring(1), answer+str);
            count = count + permutationCountsFromBelowTree;
        }

        return count;
    }

}