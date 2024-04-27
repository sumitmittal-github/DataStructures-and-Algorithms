package com.sumit.datastructures.a_arrays.c_arraylist;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArrayList_3_Sort_String {

    //Program : Write a program to sort the given ArrayList of String

    public void sort_1(List<String> list){
        if(list == null || list.size() <= 1)
            return;

        Collections.sort(list);
    }

    public void sortDescending_1(List<String> list){
        if(list == null || list.size() <= 1)
            return;

        Collections.sort(list, Collections.reverseOrder());
    }

    public void reverseList_2(List<String> list) {
        Collections.reverse(list);
    }

        public static void main(String[] args) {
        ArrayList_3_Sort_String obj = new ArrayList_3_Sort_String();

        List<String> list = Arrays.asList("aa", "zz", "gg", "ii", "cc");
        System.out.println("Original List : " + list);

        obj.sort_1(list);
        System.out.println("Ascending List : " + list);

        obj.sortDescending_1(list);
        System.out.println("Descending List : " + list);
    }


}