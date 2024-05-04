package com.sumit.datastructures.j_recursion.a_basics;

public class Recursion15_Power {

    //LeetCode-50 : https://leetcode.com/problems/powx-n/description/


    //Approach-1 : BEST approach : using binary of power
    public double myPow_1(double num, int pow) {
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


    //Approach-2 : using recursion, but it will fail if pow is very large
    //   p^q   =  p * p^(q-1)
    // TC : O(pow)
    public double myPow_2(double num, int pow) {
        if(pow == 1)
            return num;

        if(pow > 0)
            return num * myPow_2(num, pow-1);
        else
            return (1/num) * myPow_2(num, pow+1);
    }


    //Approach-3 : using recursion, but it will fail if pow is very large
    //   p^q   =      p^(q/2) * p^(q/2)     if q is even
    //         =  p * p^(q/2) * p^(q/2)     if q is odd
    // TC : O(log(pow))
    public double myPow_3(double num, int pow) {
        if(pow == 1)
            return num;
        if(pow == -1)
            return 1/num;

        if((pow&1) == 0)
            return myPow_3(num, pow/2) * myPow_3(num, pow/2);
        else {
            if(pow > 0)
                return num * myPow_3(num, pow/2) * myPow_3(num, pow/2);
            else
                return (1/num) * myPow_3(num, pow/2) * myPow_3(num, pow/2);
        }
    }





    public static void main(String[] args) {
        Recursion15_Power obj = new Recursion15_Power();

        System.out.println(obj.myPow_1(2.0, 3));
        System.out.println(obj.myPow_2(2.0, 3));
        System.out.println(obj.myPow_3(2.0, 3));

        System.out.println(obj.myPow_1(2.0, -3));
        System.out.println(obj.myPow_2(2.0, -3));
        System.out.println(obj.myPow_3(2.0, -3));

        System.out.println(obj.myPow_1(-2.1, 3));
        System.out.println(obj.myPow_2(-2.1, 3));
        System.out.println(obj.myPow_3(-2.1, 3));

        System.out.println(obj.myPow_1(-2.1, -3));
        System.out.println(obj.myPow_2(-2.1, -3));
        System.out.println(obj.myPow_3(-2.1, -3));

    }
}