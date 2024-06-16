package com.sumit.datastructures.g_stack_queue.a_stack.collegewallah;

import java.util.Stack;

public class Q2_Insert {

    /**     Insert a new element at the end of existing stack
                Stack-1             Expectations
                                      | 4 |
                 | 4 |                | 3 |
                 | 3 |                | 2 |
                 | 2 |                | 1 |
                 | 1 |                | 9 |
                 -----                -----
    */

    public void insertAtBottom(Stack<Integer> inputStack, int element){
        Stack<Integer> tempStack = new Stack<>();
        while(inputStack.size() > 0){
            tempStack.push(inputStack.pop());
        }

        inputStack.push(element);
        while(tempStack.size() > 0){
            inputStack.push(tempStack.pop());
        }
    }

    public void insertAtIndex(Stack<Integer> inputStack, int index, int element){
        Stack<Integer> tempStack = new Stack<>();
        while(inputStack.size() > index){
            tempStack.push(inputStack.pop());
        }

        inputStack.push(element);
        while(tempStack.size() > 0){
            inputStack.push(tempStack.pop());
        }
    }


    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);

        Q2_Insert obj = new Q2_Insert();

        System.out.println("Before : "+ st);
        obj.insertAtBottom(st, 44);
        obj.insertAtIndex(st, 2, 55);
        obj.insertAtIndex(st, 0, 66);
        obj.insertAtBottom(st, 77);
        obj.insertAtIndex(st, 7, 88);
        obj.insertAtIndex(st, st.size(), 99);
        System.out.println("After : "+ st);
    }

}