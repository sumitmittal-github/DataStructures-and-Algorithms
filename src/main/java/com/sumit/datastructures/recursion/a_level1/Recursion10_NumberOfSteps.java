package com.sumit.datastructures.recursion.a_level1;

// https://leetcode.com/problems/number-of-steps-to-reduce-a-number-to-zero/description/

public class Recursion10_NumberOfSteps {

    public static void main(String[] args) {
        System.out.println(numberOfSteps(14));
        System.out.println(numberOfStepsWithRecursion(14));
        System.out.println(numberOfStepsWithRecursion2(14));

        System.out.println(numberOfSteps(8));
        System.out.println(numberOfStepsWithRecursion(8));
        System.out.println(numberOfStepsWithRecursion2(8));

        System.out.println(numberOfSteps(123));
        System.out.println(numberOfStepsWithRecursion(123));
        System.out.println(numberOfStepsWithRecursion2(123));
    }


    // Way-1 : Basic approach
    public static int numberOfSteps(int num) {
        int count = 0;
        while(num > 0){
            ++count;
            // if number is odd
            if((num & 1) == 1)
                --num;
            else
                num = num/2;
        }
        return count;
    }


    // Way-2 : with recursion
    public static int numberOfStepsWithRecursion(int num) {
        if(num == 0)
            return 0;

        return 1 + numberOfStepsWithRecursion( (num&1)==1 ? --num : num/2);
    }


    // Way-3 : with recursion & helper method
    public static int numberOfStepsWithRecursion2(int num) {
        return helper(num, 0);
    }

    // Way-3 : with recursion & helper method
    public static int helper(int num, int steps) {
        if(num == 0)
            return steps;

        if((num&1) == 1)
            return helper(--num, ++steps);
        else
            return helper(num/2, ++steps);
    }


}