package com.sumit.datastructures.m_stack_queue.questions;

import java.util.Stack;

public class Q1_QueueUsingStacks {

    //LeetCode-232 : https://leetcode.com/problems/implement-queue-using-stacks/description/

    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        queue.push(1);
        queue.push(2);
        queue.push(3);
        queue.push(4);
        queue.push(5);

        System.out.println(queue.empty());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.peek());
        System.out.println(queue.peek());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.empty());
    }


    private static class MyQueue {

        private Stack<Integer> stack1;
        private Stack<Integer> stack2;

        public MyQueue() {
            stack1 = new Stack<>();
            stack2 = new Stack<>();
        }

        public void push(int x) {
            stack1.push(x);
        }

        // pop of stack1 will return the top element, but we want the last element (behaviour of queue).
        public int pop() {
            if(stack1.empty()) {
                throw new RuntimeException("Stack is empty. We can't pop the element.");
            }

            // STEP-1 : move all the elements from stack1 to stack2
            while(!stack1.empty()){
                stack2.push(stack1.pop());
            }

            // STEP-2 : take 1st element of the stack2 (last element of stack1)
            int element = stack2.pop();

            // STEP-3 : move all the remaining elements from stack2 to stack1
            while(!stack2.empty()){
                stack1.push(stack2.pop());
            }
            return element;
        }

        // peek of stack1 will return the top element, but we want the last element (behaviour of queue).
        public int peek() {
            if(stack1.empty()) {
                throw new RuntimeException("Stack is empty. We can't peek the element.");
            }

            // STEP-1 : move all the elements from stack1 to stack2
            while(!stack1.empty()){
                stack2.push(stack1.pop());
            }

            // STEP-2 : take 1st element of the stack2 (last element of stack1)
            int element = stack2.peek();

            // STEP-3 : move all the elements from stack2 to stack1
            while(!stack2.empty()){
                stack1.push(stack2.pop());
            }
            return element;
        }

        public boolean empty() {
            return stack1.empty();
        }
    }

}


