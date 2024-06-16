package com.sumit.datastructures.b_recursion.a_basics;


public class Recursion17_SumAlternateSignNums {

    // Program : return the sum of natural numbers till n but with alternate signs.
    // Constraints :  n >= 0
    // Ex: n = 5        =>  1-2+3-4+5 = 3

    public Integer sumAlternateSign(int n){
        if(n == 0)
            return 0;

        if((n&1) == 1)
            return sumAlternateSign(n-1) + n;
        else
            return sumAlternateSign(n-1) - n;
    }


    public static void main(String[] args) {
        Recursion17_SumAlternateSignNums obj = new Recursion17_SumAlternateSignNums();
        System.out.println(obj.sumAlternateSign(0));
        System.out.println(obj.sumAlternateSign(1));
        System.out.println(obj.sumAlternateSign(2));
        System.out.println(obj.sumAlternateSign(3));
        System.out.println(obj.sumAlternateSign(4));
        System.out.println(obj.sumAlternateSign(5));
        System.out.println(obj.sumAlternateSign(10));
        System.out.println(obj.sumAlternateSign(11));
    }

}