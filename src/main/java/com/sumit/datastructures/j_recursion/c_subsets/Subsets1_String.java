package com.sumit.datastructures.j_recursion.c_subsets;

import java.util.*;

public class Subsets1_String {

    public static void main(String[] args) {
        // Input           = "abc"
        // subsets will be = ["a", "b", "b", "ab", "ac", "bc", "abc"]

        // Approach-1 : print all subsets
        subsets("abc", "");

        // Approach-2 : return all subsets
        List<String> subsetList = new LinkedList<>();
        subsets2("abc", "", subsetList);
        System.out.println(subsetList);

        // Approach-3 : return all subsets, but do not take the array list in the argument
        List<String> subsetList2 = subsets3("abc", "");
        System.out.println(subsetList2);
    }


    // Approach-1 : print all subsets
    public static void subsets(String input, String answer){
        if(input == null || input.length()==0){
            if(answer.length() > 0)
                System.out.println(answer);
            return;
        }

        // take the 1st char
        subsets(input.substring(1), answer + input.charAt(0));

        // ignore the 1st char
        subsets(input.substring(1), answer);
    }



    // Approach-2 : return all subsets
    public static void subsets2(String input, String answer, List<String> list) {
        if(input == null || input.length()==0) {
            if(answer.length() > 0)
                list.add(answer);
            return;
        }

        // take the 1st char
        subsets2(input.substring(1), answer+input.charAt(0), list);

        // ignore the 1st char
        subsets2(input.substring(1), answer, list);
    }



    // Approach-3 : return all subsets, but do not take the array list in the argument
    public static List<String> subsets3(String input, String answer) {
        List<String> list = new LinkedList<>();
        if(input == null || input.length()==0) {
            if(answer.length() > 0)
                list.add(answer);
            return list;
        }

        // take the 1st char
        List<String> answersFromLeftTree = subsets3(input.substring(1), answer+input.charAt(0));

        // ignore the 1st char
        List<String> answersFromRightTree = subsets3(input.substring(1), answer);

        list.addAll(answersFromLeftTree);
        list.addAll(answersFromRightTree);
        return list;
    }
}