package com.sumit.datastructures.g_stack_queue.a_stack.collegewallah;

import java.util.Stack;

public class Q8_RemoveAdjacentDuplicates {

    // LeetCode-1047 : https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/description/.


    // Approach-1 : with stack, but performance wise it beats only 60% users
    public String removeDuplicates_1(String s) {
        Stack<Character> stack = new Stack();
        for(char nextCharToPush : s.toCharArray()) {
            if(stack.size() == 0)
                stack.push(nextCharToPush);
            else {
                if(nextCharToPush == stack.peek())
                    stack.pop();
                else
                    stack.push(nextCharToPush);
            }
        }

        StringBuilder sb = new StringBuilder();
        for(char c : stack)
            sb.append(c);

        return sb.toString();
    }


    // Approach-2 : with array, but performance wise it beats 99% users
    public String removeDuplicates_2(String s) {
        char[] arr = new char[s.length()];
        int lastElementIndex=-1;

        for(char c : s.toCharArray()) {
            if(lastElementIndex == -1 || arr[lastElementIndex] != c){
                arr[lastElementIndex+1] = c;
                lastElementIndex++;
            } else
                lastElementIndex--;
        }
        return new String(arr, 0, lastElementIndex+1);
    }

}