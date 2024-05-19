package com.sumit.datastructures.j_recursion.d_permutations;

import java.util.*;

public class Permutations1_StringPermutations {

    // Input  = abc
    // Output = [cba, bca, bac, cab, acb, abc]

    public static void main(String[] args) {

        // Approach-1 : return all permutations
        System.out.println(allPermutations("abc", ""));

        // Approach-2 : print all permutations
        allPermutations2("abc", "");
    }

    // Approach-1 : return all permutations
    public static List<String> allPermutations(String inputStr, String answer){
        List<String> list = new ArrayList<>();

        // base condition
        if(inputStr == null || inputStr.length() == 0) {
            list.add(answer);
            return list;
        }

        // variable recursive calls count  = length(intermediate answer) + 1
        int recursiveCallsCount = answer.length()+1;
        for(int i = 0; i < recursiveCallsCount; i++) {
            String firstPart = answer.substring(0, i);                 // substring[a,b) : a inclusive, b exclusive
            String thirdPart = answer.substring(i, answer.length());

            String secondPart = inputStr.substring(0, 1);  // first character of input string

            String newPermutationAns = firstPart + secondPart + thirdPart;

            List<String> permutationsFromBelowTree = allPermutations(inputStr.substring(1), newPermutationAns);
            list.addAll(permutationsFromBelowTree);
        }
        return list;
    }


    // Approach-2 : print all permutations
    public static void allPermutations2(String inputStr, String answer){

        // base condition
        if(inputStr == null || inputStr.length() == 0) {
            System.out.println(answer);
            return;
        }

        // length(intermediate answer) + 1 recursive calls
        int recursiveCallsCount = answer.length()+1;
        for(int i = 0; i < recursiveCallsCount; i++) {
            String firstPart = answer.substring(0, i);
            String secondPart = inputStr.substring(0, 1);  // first character of input string
            String thirdPart = answer.substring(i, answer.length());

            String newPermutationAns = firstPart + secondPart + thirdPart;
            allPermutations2(inputStr.substring(1), newPermutationAns);
        }
    }

}