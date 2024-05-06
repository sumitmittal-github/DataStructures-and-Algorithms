package com.sumit.datastructures.j_recursion.b_strings;

public class String5_Reverse {

    // Question : reverse a string

    public String reverse_1(String str){
        if(str == null)
            return null;

        StringBuilder sb = new StringBuilder();
        for(int i=str.length()-1; i>=0; i--){
            sb.append(str.charAt(i));
        }
        return sb.toString();
    }


    public String reverse_2(String str){
        if(str == null)             return null;
        if(str.length() == 0)       return "";

        return reverse_2(str.substring(1)) + str.charAt(0);
    }


    public String reverse_3(String str){
        if(str == null)
            return null;

        return reverse_3_helper(str, 0);
    }
    private String reverse_3_helper(String str, int index){
        if(index == str.length())
            return "";

        return reverse_3_helper(str, index+1) + str.charAt(index);
    }



    public static void main(String[] args) {
        String5_Reverse obj = new String5_Reverse();

        System.out.println(obj.reverse_1("abcde"));
        System.out.println(obj.reverse_2("abcde"));
        System.out.println(obj.reverse_3("abcde"));
    }

}