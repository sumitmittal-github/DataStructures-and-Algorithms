package com.sumit.datastructures.a_arrays.c_arraylist;

import java.util.*;

public class ArrayList_1_Reverse {

    // Program : Write a program to Reverse the given ArrayList

    public void reverseList_1(List<Integer> list){
        if(list == null || list.size() <= 1)
            return;

        int start = 0;
        int end = list.size()-1;

        while(start < end){
            int temp = list.get(start);
            list.set(start, list.get(end));
            list.set(end, temp);
            start++;
            end--;
        }
    }

    public void reverseList_2(List<Integer> list) {
        Collections.reverse(list);
    }

        public static void main(String[] args) {
        ArrayList_1_Reverse obj = new ArrayList_1_Reverse();

        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,100);
        System.out.println("Original List : " + list);

        obj.reverseList_1(list);
        System.out.println("Reverse List : " + list);

        obj.reverseList_2(list);
        System.out.println("Original (R -> R) : " + list);
    }


}