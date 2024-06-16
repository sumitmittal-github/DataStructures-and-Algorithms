package com.sumit.datastructures.b_recursion.b_strings;

public class String3_SkipAStringWithCondition {

    // Program : remove 'app' from the input string if the matching string is not apple
    // Input : baccappled       => Output : baccappled
    // Input : baccappld        => Output : baccld
    public static void main(String[] args) {


        // Approach-1 : keeping the result in return response
        System.out.println("baccappled => " + removeA("baccappled"));
        System.out.println("baccappld  => " + removeA("baccappld"));

        // Approach-2 : storing result in an argument
        removeA2("baccappled", "");
        removeA2("baccappld", "");
    }


    // Approach-1 : returning the result
    public static String removeA(String input) {
        if (input == null || input.length() == 0)
            return "";

        if (input.startsWith("app") && !input.startsWith("apple"))
            return removeA(input.substring(3));
        else
            return input.charAt(0) + removeA(input.substring(1));
    }


    // Approach-2 : storing result in an argument
    public static void removeA2(String input, String answer){
        if(input == null || input.length() == 0){
            System.out.println("Ans => " + answer);
            return;
        }

        if (input.startsWith("app") && !input.startsWith("apple"))
            removeA2(input.substring(3), answer);
        else
            removeA2(input.substring(1), answer + input.charAt(0));
    }

}
