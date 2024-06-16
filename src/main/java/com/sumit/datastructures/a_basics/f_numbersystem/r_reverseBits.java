package com.sumit.datastructures.a_basics.f_numbersystem;

public class r_reverseBits {

    // LeetCode-190 : https://leetcode.com/problems/reverse-bits/description/

    public int reverseBits(int n) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            // Step-1 : get lsb of input number and remove lsb from input
            int lsb = n & 1;
            n = n >> 1;

            // Step-2 : if input number lsb was 1 then add 0 at the end of answer
            // Step-3 : if input number lsb was 0 then add 0 at the end of answer and change lsb to 1
            ans = ans << 1;
            if(lsb == 1){
                ans = ans ^ 1;
            }
        }
        return ans;
    }

}