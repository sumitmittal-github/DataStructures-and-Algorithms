package com.sumit.datastructures.j_recursion.b_strings;

public class String1_SkipAChar {

    // Program : remove all 'a' from the input string
    public static void main(String[] args) {

        // Approach-1 : keeping the result in return response
        String output = removeA("baccad");
        System.out.println("Ans = " + output);

        // Approach-2 : storing result in an argument
        removeA2("baccad", "");
    }


    // Approach-1 : returning the result
    public static String removeA(String input){
        if(input == null || input.length() == 0)
            return "";

        char firstChar = input.charAt(0);
        if(firstChar == 'a')
            return removeA(input.substring(1));
        else
            return firstChar + removeA(input.substring(1));
    }


    // Approach-2 : storing result in an argument
    public static void removeA2(String input, String answer){
        if(input == null || input.length() == 0){
            System.out.println("Ans = " + answer);
            return;
        }

        char firstChar = input.charAt(0);
        if(firstChar == 'a')
            removeA2(input.substring(1), answer);
        else
            removeA2(input.substring(1), answer+firstChar);
    }

}
