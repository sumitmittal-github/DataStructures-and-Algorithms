package com.sumit.datastructures.j_recursion.a_basics;

import java.util.*;
public class Recursion16_KMultiplesOfNum {

    // Program : print first k multiples of num. where k>0
    // Ex - num = 12, k = 5        =>  first 5 multiples of 12     =>      12, 24, 36, 48, 60
    // Ex - num = 3, k = 8         =>  first 8 multiples of 3      =>      3, 6, 9, 12, 15, 18, 21, 24

    public List<Integer> multiples(int num, int k){
        List<Integer> list = new ArrayList<>();
        if(k == 1) {
            list.add(num);
            return list;
        }

        list.addAll(multiples(num, k-1) );              // remaining k-1 multiples
        list.add(num*k);

        return list;
    }


    public static void main(String[] args) {
        Recursion16_KMultiplesOfNum obj = new Recursion16_KMultiplesOfNum();
        System.out.println(obj.multiples(12, 5));
    }

}