package com.sumit.datastructures.b_recursion.b_strings;

public class String5_Palindrome {

    // Question : check if the given string is palindrome or not.

    public boolean isPalindrome_1(String str){
        if(str == null)
            return false;

        int start = 0;
        int end = str.length()-1;
        while(start < end){
            if(str.charAt(start) != str.charAt(end))
                return false;
            start++;
            end--;
        }

       return true;
    }


    public boolean isPalindrome_2(String str){
        if(str == null || str.length() <= 1)       return true;

        char firstChar = str.charAt(0);
        char lastChar = str.charAt(str.length()-1);
        if(firstChar == lastChar)
            return isPalindrome_2(str.substring(1, str.length()-1));
        else
            return false;
    }


    public boolean isPalindrome_3(String str){
        if(str == null)
            return true;

        return isPalindrome_3_helper_2(str, 0);
    }
    private boolean isPalindrome_3_helper(String str, int index){
        if(index >= str.length()/2)
            return true;

        char firstChar = str.charAt(index);
        char lastChar = str.charAt(str.length()-1-index);
        if(firstChar == lastChar)
            return isPalindrome_3_helper(str, index+1);
        else
            return false;
    }

    private boolean isPalindrome_3_helper_2(String str, int index){
        if(index >= str.length()/2)
            return true;

        return (str.charAt(index) == str.charAt(str.length()-1-index)) && isPalindrome_3_helper_2(str, index+1);
    }

    public static void main(String[] args) {
        String5_Palindrome obj = new String5_Palindrome();

        System.out.println(obj.isPalindrome_1("aba"));
        System.out.println(obj.isPalindrome_2("aba"));
        System.out.println(obj.isPalindrome_3("aba"));

        System.out.println(obj.isPalindrome_1("abba"));
        System.out.println(obj.isPalindrome_2("abba"));
        System.out.println(obj.isPalindrome_3("abba"));

        System.out.println(obj.isPalindrome_1("abaa"));
        System.out.println(obj.isPalindrome_2("abaa"));
        System.out.println(obj.isPalindrome_3("abaa"));

        System.out.println(obj.isPalindrome_1("abcaa"));
        System.out.println(obj.isPalindrome_2("abcaa"));
        System.out.println(obj.isPalindrome_3("abcaa"));
    }

}