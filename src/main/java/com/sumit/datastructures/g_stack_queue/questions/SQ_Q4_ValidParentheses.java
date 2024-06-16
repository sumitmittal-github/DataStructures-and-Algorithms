package com.sumit.datastructures.g_stack_queue.questions;

import java.util.Stack;

public record SQ_Q4_ValidParentheses() {

    // LeetCode-20 : https://leetcode.com/problems/valid-parentheses/description/

    public boolean isValid(String s) {
        if(s == null || s.trim().isEmpty())
            return false;

        // if string contains odd number of characters then it is not valid
        // because as per program the input string only contains '()[]{}'
        if((s.length() & 1) == 1)
            return false;

        Stack<Character> stack = new Stack();
        for(char nextCharToPush : s.toCharArray()){

            if(nextCharToPush == '('   ||   nextCharToPush == '{'   ||   nextCharToPush == '[')
                stack.push(nextCharToPush);
            else {
                if(stack.isEmpty())
                    return false;
                else {
                    char topElement = stack.pop();
                    if( (topElement == '(' && nextCharToPush != ')')    ||   (topElement == '{' && nextCharToPush != '}')    ||   (topElement == '[' && nextCharToPush != ']')  )
                        return false;
                }
            }
        }
        return stack.isEmpty();
    }


    public static void main(String[] args) {
        SQ_Q4_ValidParentheses obj = new SQ_Q4_ValidParentheses();

        System.out.println(obj.isValid("()[]{}"));
        System.out.println(obj.isValid("(]"));
        System.out.println(obj.isValid("([{}])"));
        System.out.println(obj.isValid("([{})]"));
        System.out.println(obj.isValid("("));
    }

}