package com.sumit.datastructures.g_stack_queue.a_stack.collegewallah;

import java.util.Stack;

public class Q3_Print {

    /**     Print all elements of a Stack in correct order (from index 0 to index n)
    */

    public void display_with_temp_stack(Stack<Integer> inputStack){
        Stack<Integer> tempStack = new Stack<>();

        // move all elements in temp stack in reverse order
        while(inputStack.size() > 0){
            tempStack.push(inputStack.pop());
        }

        // move back all elements in inputStack in correct order and while print the element
        while(tempStack.size() > 0){
            int element = tempStack.pop();
            System.out.print(element + " ");
            inputStack.push(element);
        }
    }

    public void display_with_temp_array(Stack<Integer> inputStack){
        int[] tempArr = new int[inputStack.size()];

        // move all elements in array in reverse order
        for(int i=0; i<tempArr.length; i++){
            tempArr[i] = inputStack.pop();
        }
        // NOTE : we can not use here inputStack.size() because stack size will keep on reducing and we will miss few elements


        // move back all elements in inputStack in correct order and while moving print the element
        for(int i = tempArr.length-1; i >= 0; i--){
            System.out.print(tempArr[i] + " ");
            inputStack.push(tempArr[i]);
        }
    }

    public void display_with_recursion(Stack<Integer> inputStack){
        if(inputStack.size() == 0) return;

        int element = inputStack.pop();
        display_with_recursion(inputStack);

        System.out.print(element + " ");
        inputStack.push(element);
    }


    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);
        st.push(5);
        st.push(6);

        for(int i : st)
            System.out.println(i);

        /*Q3_Print obj = new Q3_Print();
        obj.display_with_temp_stack(st);
        System.out.println();

        obj.display_with_temp_array(st);
        System.out.println();

        obj.display_with_recursion(st);
        System.out.println();*/
    }

}