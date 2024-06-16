package com.sumit.datastructures.f_linkedlist.a_singly.kunal;

public class LL_Q7_HappyNumber {

    // LeetCode-202 : https://leetcode.com/problems/happy-number/description/

    public static void main(String[] args) {
        System.out.println(new LL_Q7_HappyNumber().isHappy(19));
    }





    public boolean isHappy(int inputNum) {
        if(inputNum == 1 || getSumOfAllDigitsSquare(inputNum) == 1)
            return true;

        int fast = inputNum;
        int slow = inputNum;

        fast = getSumOfAllDigitsSquare(getSumOfAllDigitsSquare(fast));
        slow = getSumOfAllDigitsSquare(slow);
        while(fast != slow) {
            if(slow == 1 || fast == 1)
                return true;
            fast = getSumOfAllDigitsSquare(getSumOfAllDigitsSquare(fast));
            slow = getSumOfAllDigitsSquare(slow);
        }
        return false;
    }



    // Ex : for 25  =  2*2 + 5*5  =  4 + 25 = 29
    public int getSumOfAllDigitsSquare(int inputNum){
        int sum = 0;
        while(inputNum > 0) {
            int digit = inputNum % 10;
            sum = sum + (digit * digit);
            inputNum = inputNum/10;
        }
        return sum;
    }

}