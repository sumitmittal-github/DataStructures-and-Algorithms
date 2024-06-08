package com.sumit.datastructures.z_mixprograms;

import java.util.ArrayList;
import java.util.List;

public class Q11_StringToggle {

    // Question : Given a string, toggle all the characters of the String. Upper to Lover and vice versa.
    // Ex  : input = SumiT MITTal
    //       O/P   = sUMITt mittAL

    public String toggleString(String str){
        if(str == null || str.isEmpty()) return str;

        StringBuilder sb = new StringBuilder(str);
        for(int i=0; i<str.length(); i++){
            int charAscii = sb.charAt(i);
            if(65 <= charAscii && charAscii <= 90)  sb.setCharAt(i, (char)(charAscii+32));
            else if(97 <= charAscii && charAscii <= 122)  sb.setCharAt(i, (char)(charAscii-32));
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        Q11_StringToggle obj = new Q11_StringToggle();

        String input = "SumiT MITTal";
        System.out.println(input);
        System.out.println(obj.toggleString(input));
    }

}