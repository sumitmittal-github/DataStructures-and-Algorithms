package com.sumit.datastructures.z_mixprograms;

import java.util.ArrayList;
import java.util.List;

public class Q10_AllSubStrings {

    // Question : print all subscrings of any string
    // Ex  : input = abcd
    //       O/P   = a, ab, abc, abcd,
    //               b, bc, bcd,
    //               c, cd,
    //               d

    public List<String> allSubstrings(String str){
        List<String> list = new ArrayList<>();
        for(int i=0; i<str.length(); i++){
            for(int j=i+1; j<=str.length(); j++){
                list.add(str.substring(i, j));
            }
        }
        return list;
    }


    public static void main(String[] args) {
        Q10_AllSubStrings obj = new Q10_AllSubStrings();
        obj.allSubstrings("abcd").stream().forEach(System.out::println);
    }

}