package com.sumit.datastructures.g_stack_queue.questions;

import java.util.Stack;

public class SQ_Q5_MinimumParentheses {

    // LeetCode-921 : https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/description/

    public int minAddToMakeValid(String s) {
        int count = 0;

        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()) {
            if(c == '(')
                stack.push(c);
            else {
                if(!stack.isEmpty())
                    stack.pop();
                else
                    count++;
            }
        }
        return count + stack.size();
    }


}