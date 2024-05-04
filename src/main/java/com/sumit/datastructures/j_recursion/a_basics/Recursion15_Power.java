package com.sumit.datastructures.j_recursion.a_basics;

public class Recursion15_Power {

    //LeetCode-50 : https://leetcode.com/problems/powx-n/description/

    //Approach-1 : using recursion, but it will fail if n is very large
    public double myPow_1(double x, int n) {
        if(n == 1)
            return x;

        if(n > 0)
            return x * myPow_1(x, n-1);
        else
            return (1/x) * myPow_1(x, n+1);
    }



    //Approach-2 : using binary of power
    public double myPow_2(double num, int pow) {
        // if power is negative then converting it into +ve
        // Ex- (3)^(-9)   ==>   (1/3)^9
        if(pow < 0){
            num = 1 / num;
            pow = -pow;
        }

        double ans = 1;
        double multiplier = num;
        while(pow != 0){
            //multiply only when the number is odd, means the last bit is 1
            if((pow & 1) == 1){
                ans = ans * multiplier;
            }

            multiplier = multiplier * multiplier;
            pow = pow >>> 1;
        }
        return ans;
    }





    public static void main(String[] args) {
        Recursion15_Power obj = new Recursion15_Power();

        System.out.println(obj.myPow_1(2.0, 3));
        System.out.println(obj.myPow_2(2.0, 3));

        System.out.println(obj.myPow_1(2.0, -3));
        System.out.println(obj.myPow_2(2.0, -3));

        System.out.println(obj.myPow_1(-2.1, 3));
        System.out.println(obj.myPow_2(-2.1, 3));

        System.out.println(obj.myPow_1(-2.1, -3));
        System.out.println(obj.myPow_2(-2.1, -3));

    }
}