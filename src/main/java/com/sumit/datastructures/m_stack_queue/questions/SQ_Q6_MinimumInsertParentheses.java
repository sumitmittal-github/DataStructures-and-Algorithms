package com.sumit.datastructures.m_stack_queue.questions;

import java.util.Stack;

public class SQ_Q6_MinimumInsertParentheses {

    //LeetCode-1541 : https://leetcode.com/problems/minimum-insertions-to-balance-a-parentheses-string/description/

    public int minInsertions(String s) {
        int count = 0;
        String input = s.replaceAll("\\)\\)", "#");
        System.out.println(input);

        Stack<Character> stack = new Stack<>();
        for(char nextChar : input.toCharArray()){
            if(nextChar == '(')
                stack.push(nextChar);
            else{
                if(stack.isEmpty()){
                    if(nextChar == '#')      count = count+1;   // because nextChar was )) and we need ( to cancel this
                    else                     count = count+2;   // because nextChar was ) and we need ( and ) to cancel this
                } else{
                    if(nextChar == '#')     stack.pop();
                    else if(nextChar == ')') {
                        stack.pop();
                        count++;    // because we needed )) but we got only )
                    }
                }
            }
        }
        return count + stack.size()*2;
    }


}