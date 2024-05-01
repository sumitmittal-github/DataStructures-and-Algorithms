package com.sumit.datastructures.j_recursion.questions;

public class Recur_Q4_PrintN {

    // print from  1 to n
    public void print_1_to_N(int n){
        if(n == 0)
            return;

        print_1_to_N(n-1);
        System.out.print(n + " ");
    }


    // print from  n to 1
    public void print_N_to_1(int n){
        if(n == 0)
            return;

        System.out.print(n + " ");
        print_N_to_1(n-1);
    }


    public static void main(String[] args) {
        Recur_Q4_PrintN obj = new Recur_Q4_PrintN();

        obj.print_1_to_N(5);
        System.out.println();

        obj.print_N_to_1(5);
    }
}