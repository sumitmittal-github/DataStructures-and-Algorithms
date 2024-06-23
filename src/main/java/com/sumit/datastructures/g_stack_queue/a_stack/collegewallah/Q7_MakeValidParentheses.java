package com.sumit.datastructures.g_stack_queue.a_stack.collegewallah;

public class Q7_MakeValidParentheses {

    // LeetCode-1249 : https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/description/

    public String minRemoveToMakeValid(String s) {

        // Step-1 : Remove invalid closing parentheses
        StringBuilder sb = new StringBuilder();
        int openCount = 0;
        for (char inputChar : s.toCharArray()) {
            if (inputChar == '(') {
                openCount++;
                sb.append(inputChar);
            } else if (inputChar == ')') {
                if (openCount > 0) {
                    openCount--;
                    sb.append(inputChar);
                }
            } else {
                sb.append(inputChar);
            }
        }

        // Step-2 : Remove invalid opening parentheses
        int closeCount = 0;
        StringBuilder ans = new StringBuilder();
        for (int i = sb.length() - 1; i >= 0; i--) {
            char c = sb.charAt(i);
            if (c == ')') {
                closeCount++;
                ans.append(c);
            } else if (c == '(') {
                if (closeCount > 0) {
                    closeCount--;
                    ans.append(c);
                }
            } else {
                ans.append(c);
            }
        }

        return ans.reverse().toString();
    }

}