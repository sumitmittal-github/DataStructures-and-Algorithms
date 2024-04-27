package com.sumit.datastructures.a_arrays.c_arraylist;

import java.util.*;

public class ArrayList_2_Sort {

    //Program : Write a program to sort the given ArrayList

    public void sort_1(List<Integer> list){
        if(list == null || list.size() <= 1)
            return;

        Collections.sort(list);
    }

    public void sortDescending_1(List<Integer> list){
        if(list == null || list.size() <= 1)
            return;

        Collections.sort(list, Collections.reverseOrder());
    }

    public void reverseList_2(List<Integer> list) {
        Collections.reverse(list);
    }

        public static void main(String[] args) {
        ArrayList_2_Sort obj = new ArrayList_2_Sort();

        List<Integer> list = Arrays.asList(1,12,3,45,5,6,7,18,99,-100);
        System.out.println("Original List : " + list);

        obj.sort_1(list);
        System.out.println("Ascending List : " + list);

        obj.sortDescending_1(list);
        System.out.println("Descending List : " + list);
    }


}