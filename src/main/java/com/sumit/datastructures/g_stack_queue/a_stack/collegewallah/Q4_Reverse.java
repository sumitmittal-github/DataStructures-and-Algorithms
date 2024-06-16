package com.sumit.datastructures.g_stack_queue.a_stack.collegewallah;

import java.util.Stack;

public class Q4_Reverse {

    /**     Reverse all the elements of a given stack
                      Input Stack         Expectations
                       | 4 |                | 1 |
                       | 3 |                | 2 |
                       | 2 |                | 3 |
                       | 1 |                | 4 |
                       -----                -----
    */


    // Approach-1 : Best approach
    public void reverse(Stack<Integer> inputStack){

        // move all elements in temp stack 1 in reverse order
        Stack<Integer> tempStack1 = new Stack<>();
        while(inputStack.size() > 0){
            tempStack1.push(inputStack.pop());
        }

        // move all elements in temp stack 2 in reverse order
        Stack<Integer> tempStack2 = new Stack<>();
        while(tempStack1.size() > 0){
            tempStack2.push(tempStack1.pop());
        }

        // move back all elements in inputStack in reverse order
        while(tempStack2.size() > 0){
            inputStack.push(tempStack2.pop());
        }
    }



    // Approach-2 : Best approach with recursion
    // better than reverse_with_recursion_2
    public void reverse_with_recursion_1(Stack<Integer> inputStack){
        if(inputStack.size() == 0) return;

        int temp = inputStack.pop();
        reverse_with_recursion_1(inputStack);
        insertAtBottom(inputStack, temp);
    }
    private void insertAtBottom(Stack<Integer> inputStack, int element){
        if(inputStack.size() == 0){
            inputStack.push(element);
            return;
        }

        int temp = inputStack.pop();
        insertAtBottom(inputStack, element);
        inputStack.push(temp);
    }



    // Approach-3 : Not a good approach, because it is not completely recursion
    //              also we need to paas 1 temp stack as a argument
    public void reverse_with_recursion_2(Stack<Integer> inputStack, Stack<Integer> tempStack1){
        if(inputStack.size() == 0) {
            Stack<Integer> tempStack2 = new Stack<>();
            while(tempStack1.size() > 0){
                tempStack2.push(tempStack1.pop());
            }
            while(tempStack2.size() > 0){
                inputStack.push(tempStack2.pop());
            }
            return;
        }
        tempStack1.push(inputStack.pop());
        reverse_with_recursion_2(inputStack, tempStack1);
    }




    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);
        st.push(5);
        st.push(6);

        Q4_Reverse obj = new Q4_Reverse();
        System.out.println("Before-1 : " + st);
        obj.reverse(st);
        System.out.println("After-1  : " + st);

        System.out.println("Before-2 : " + st);
        obj.reverse_with_recursion_1(st);
        System.out.println("After-2  : " + st);

        System.out.println("Before-3 : " + st);
        obj.reverse_with_recursion_2(st, new Stack<>());
        System.out.println("After-3  : " + st);
    }

}