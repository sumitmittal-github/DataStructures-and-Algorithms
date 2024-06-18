package com.sumit.datastructures.g_stack_queue.a_stack.collegewallah;

import java.util.Stack;

public class Q6_ValidParentheses {

    // LeetCode-20 : https://leetcode.com/problems/valid-parentheses/description/

    public boolean isValid(String inputStr) {
        if ((inputStr.length() & 1) == 1)
            return false;

        Stack<Character> stack = new Stack<>();
        for (char inputStrChar : inputStr.toCharArray()) {
            if (inputStrChar == '(' || inputStrChar == '{' || inputStrChar == '[')
                stack.push(inputStrChar);
            else {
                if (stack.isEmpty())
                    return false;
                char stackChar = stack.pop();
                if (stackChar == '(' && inputStrChar != ')')
                    return false;
                else if (stackChar == '{' && inputStrChar != '}')
                    return false;
                else if (stackChar == '[' && inputStrChar != ']')
                    return false;
            }
        }
        return stack.isEmpty();
    }

}