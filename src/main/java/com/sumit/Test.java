package com.sumit;

import java.util.*;

public class Test {

    public static void main(String[] args) {
        Test t = new Test();
        System.out.println(t.getSSQHelper("abc", ""));
    }





    public ArrayList<String> getSSQHelper(String str, String ans){
        ArrayList<String> list = new ArrayList<>();
        if(str == null || str.length() == 0){
            list.add(ans);
            return list;
        }

        list.addAll(getSSQHelper(str.substring(1), ans+str.charAt(0)));
        list.addAll(getSSQHelper(str.substring(1), ans));

        return list;
    }
}