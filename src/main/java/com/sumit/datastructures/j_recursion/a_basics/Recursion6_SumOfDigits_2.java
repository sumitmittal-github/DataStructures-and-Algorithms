package com.sumit.datastructures.j_recursion.a_basics;

public class Recursion6_SumOfDigits_2 {

    //LeetCode-258 : https://leetcode.com/problems/add-digits/description/

    public static void main(String[] args) {
        Recursion6_SumOfDigits_2 obj = new Recursion6_SumOfDigits_2();

        System.out.println(obj.sumOfDigits_1(3124));
        System.out.println(obj.sumOfDigits_2(3124));

        System.out.println(obj.sumOfDigits_1(0));
        System.out.println(obj.sumOfDigits_2(0));

        System.out.println(obj.sumOfDigits_1(1234567891));
        System.out.println(obj.sumOfDigits_2(1234567891));
    }



    // Approach-1 : iteration
    public int sumOfDigits_1(int n) {
        while(n >= 10){
            int temp = n;
            n=0;    // using n as sum of all the digits and after calculating sum, again checking in while loop if >= 10
            while(temp > 0){
                n = n + temp%10;
                temp = temp / 10;
            }
        }
        return n;
    }



    // Approach-2 : recursion
    public int sumOfDigits_2(int num) {
        while(num >= 10){
            num = sumOfDigits_2_helper(num);
        }
        return num;
    }
    private int sumOfDigits_2_helper(int n){
        if(n < 10)
            return n;

        return (n%10) + sumOfDigits_2_helper(n/10);
    }




}