package com.sumit.datastructures.j_recursion.d_permutations;

public class Permutations2_CountPermutations {

    // Input        = abc
    // Permutations = [cba, bca, bac, cab, acb, abc]      => Count = 6

    public static void main(String[] args) {

        System.out.println(countAllPermutations("abc", ""));    // factorial(3) = 6
        System.out.println(countAllPermutations("abcd", ""));   // factorial(4) = 24
        System.out.println(countAllPermutations("abcde", ""));  // factorial(5) = 120

    }

    // Way-1 : return all permutations
    public static Integer countAllPermutations(String inputStr, String answer){
        Integer count = 0;

        // base condition
        if(inputStr == null || inputStr.length() == 0) {
            count++;
            return count;
        }

        // variable recursive calls count  = length(intermediate answer) + 1
        int recursiveCallsCount = answer.length()+1;
        for(int i = 0; i < recursiveCallsCount; i++) {
            String firstPart = answer.substring(0, i);                 // substring[a,b) : a inclusive, b exclusive
            String thirdPart = answer.substring(i, answer.length());

            String secondPart = inputStr.substring(0, 1);  // first character of input string

            String newPermutationAns = firstPart + secondPart + thirdPart;

            Integer permutationsCountFromBelowTree = countAllPermutations(inputStr.substring(1), newPermutationAns);
            count = count + permutationsCountFromBelowTree;
        }
        return count;
    }

}