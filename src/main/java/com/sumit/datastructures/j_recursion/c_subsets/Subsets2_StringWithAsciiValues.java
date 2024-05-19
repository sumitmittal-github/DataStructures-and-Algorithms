package com.sumit.datastructures.j_recursion.c_subsets;

import java.util.LinkedList;
import java.util.List;

public class Subsets2_StringWithAsciiValues {

    public static void main(String[] args) {
        // Input           = "ab"
        // subsets will be = [ab, a, a98, b, 98, 97b, 97, 9798]

        // Approach-1 : print all subsets
        subsets("ab", "");

        // Approach-2 : return all subsets
        List<String> subsetList = new LinkedList<>();
        subsets2("ab", "", subsetList);
        System.out.println(subsetList);

        // Approach-3 : return all subsets, but do not take the array list in the argument
        List<String> subsetList2 = subsets3("ab", "");
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

        // ASCII of 1st char
        subsets(input.substring(1), answer + (input.charAt(0)+0)  );  // input.charAt(0)+0 : for integer value
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

        // ASCII of 1st char
        subsets2(input.substring(1), answer+(input.charAt(0)+0), list); // input.charAt(0)+0 : for integer value
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

        // ASCII of 1st char
        int ascii = input.charAt(0);
        List<String> answersFromAsciiTree = subsets3(input.substring(1), answer + ascii);

        list.addAll(answersFromLeftTree);
        list.addAll(answersFromRightTree);
        list.addAll(answersFromAsciiTree);
        return list;
    }
}