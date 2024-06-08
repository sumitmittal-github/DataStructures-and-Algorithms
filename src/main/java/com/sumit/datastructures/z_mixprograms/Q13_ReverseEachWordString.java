package com.sumit.datastructures.z_mixprograms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Q13_ReverseEachWordString {

    // input  = My name is Sumit Mittal
    // output = yM eman si timuS lattiM


    // Way-1 : I found it better and optimized
    public String reverseEachWordString_1(String input){
        if(input == null || input.isEmpty()) return null;

        StringBuffer sb = new StringBuffer();
        // take 1-1 word from the input
        for(String str : input.split(" ")){
            // take 1-1 alphabet from the string in reverse order
            for(int i=str.length()-1; i>=0; i--){
                sb.append(str.charAt(i));
            }
            sb.append(" ");
        }
        return sb.toString();
    }


    // Way-2 : Not good, because calling inbuilt reverse method
    public String reverseEachWordString_2(String input){
        if(input == null || input.isEmpty()) return null;

        StringBuilder ans = new StringBuilder();
        StringBuilder tempSB = new StringBuilder();
        for(int i=0; i<input.length(); i++){
            char ch = input.charAt(i);

            if(ch != ' '){
                tempSB.append(ch);
            } else {
                tempSB.reverse();
                ans.append(tempSB + " ");
                tempSB = new StringBuilder();
            }
        }
        tempSB.reverse();
        ans.append(tempSB);
        return ans.toString();
    }


    public static void main(String[] args) {
        Q13_ReverseEachWordString obj = new Q13_ReverseEachWordString();
        System.out.println(obj.reverseEachWordString_1("My name is Sumit Mittal"));
        System.out.println(obj.reverseEachWordString_2("My name is Sumit Mittal"));
    }

}