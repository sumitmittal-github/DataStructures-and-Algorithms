package com.sumit.datastructures.g_stack_queue.a_stack.collegewallah;

import java.util.Stack;

public class Q5_Remove {

    /**     Remove the last element of a given stack
                Stack-1             Expectations
                 | 4 |
                 | 3 |                | 4 |
                 | 2 |                | 3 |
                 | 1 |                | 2 |
                 -----                -----
    */

    public int removeFromBottom(Stack<Integer> inputStack){
        Stack<Integer> tempStack = new Stack<>();
        while(inputStack.size() > 1){
            tempStack.push(inputStack.pop());
        }
        int bottom = inputStack.pop();

        while(tempStack.size() > 0){
            inputStack.push(tempStack.pop());
        }
        return bottom;
    }

    public int removeFromIndex(Stack<Integer> inputStack, int index){
        Stack<Integer> tempStack = new Stack<>();
        while(inputStack.size() >= index){
            tempStack.push(inputStack.pop());
        }

        int bottom = tempStack.pop();
        while(tempStack.size() > 0){
            inputStack.push(tempStack.pop());
        }
        return bottom;
    }



    public static void main(String[] args) {
        Q5_Remove obj = new Q5_Remove();

        Stack<Integer> st = new Stack<>();
        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);

        System.out.println("Before : "+ st);
        System.out.println(obj.removeFromBottom(st));
        System.out.println("After : "+ st);

        System.out.println("Before : "+ st);
        System.out.println(obj.removeFromIndex(st, 1));
        System.out.println("After : "+ st);
    }

}