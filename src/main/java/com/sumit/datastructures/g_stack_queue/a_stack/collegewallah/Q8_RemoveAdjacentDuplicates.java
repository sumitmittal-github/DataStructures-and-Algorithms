package com.sumit.datastructures.g_stack_queue.a_stack.collegewallah;

import java.util.*;

public class Q8_RemoveAdjacentDuplicates{

    // LeetCode-1047 : https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/description/


    // Approach-1 : Using char array, beats 99%
    public String removeDuplicates_1(String s) {

        char[] charArr = new char[s.length()];
        int lastElementIndex = -1;

        for (int i = 0; i < s.length(); i++) {
            char inputChar = s.charAt(i);

            if(lastElementIndex == -1){
                charArr[0] = inputChar;
                lastElementIndex++;
            } else {
                char lastElement = charArr[lastElementIndex];
                if(inputChar != lastElement){
                    lastElementIndex++;
                    charArr[lastElementIndex] = inputChar;
                } else {
                    lastElementIndex--;
                }
            }
        }
        return new String(charArr, 0, lastElementIndex+1);
    }


    // Approach-2 : Using stack, but beats only 28%
    public String removeDuplicates_2(String s) {

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char inputChar = s.charAt(i);
            if (stack.size() == 0)          stack.push(inputChar);
            else {
                char top = stack.peek();
                if (top == inputChar)       stack.pop();
                else                        stack.push(inputChar);
            }
        }

        Stack<Character> stack2 = new Stack<>();
        while(stack.size() != 0){
            stack2.push(stack.pop());
        }

        StringBuilder ans = new StringBuilder();
        while(stack2.size() != 0){
            ans.append(stack2.pop());
        }
        return ans.toString();
    }

}