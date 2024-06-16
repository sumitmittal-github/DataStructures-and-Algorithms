package com.sumit.datastructures.g_stack_queue.a_stack.collegewallah;

import java.util.*;

public class Q1_CopyStack {

    /**     Copy stack elements from 1 stack to another stack in same order
                Stack-1             Expected Stack-2
                 | 4 |                | 4 |
                 | 3 |                | 3 |
                 | 2 |                | 2 |
                 | 1 |                | 1 |
                 -----                -----
    */


    // Approach-1 : input -> reverse order -> same order
    // Problem : input stack will be empty
    public Stack copyStack_1(Stack<Integer> inputStack){
        System.out.println("Input Stack  : " + inputStack);

        // enter elements in reverse order
        Stack<Integer> tempStack = new Stack<>();
        while(inputStack.size() > 0){
            tempStack.push(inputStack.pop());
        }
        System.out.println("Temp Stack   : " + tempStack);

        // enter elements in reverse order again to make it in same order
        Stack<Integer> outputStack = new Stack<>();
        while(tempStack.size() > 0){
            outputStack.push(tempStack.pop());
        }
        System.out.println("Output Stack : " + outputStack);

        return outputStack;
    }


    // Approach-2 : using foreach loop
    public Stack copyStack_2(Stack<Integer> inputStack){
        Stack<Integer> outputStack = new Stack<>();
        for(Integer element : inputStack){
            outputStack.push(element);
        }
        return outputStack;
    }


    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);

        Q1_CopyStack obj = new Q1_CopyStack();
        //System.out.println("New Stack : "+ obj.copyStack_1(st));
        System.out.println("New Stack : "+ obj.copyStack_2(st));
    }

}