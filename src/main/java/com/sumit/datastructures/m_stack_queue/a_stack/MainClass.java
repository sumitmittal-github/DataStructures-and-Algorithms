package com.sumit.datastructures.m_stack_queue.a_stack;

public class MainClass {

    public static void main(String[] args) throws StackException {

        CustomStack stack1 = new CustomStack(3);
        stack1.push(1);
        stack1.push(3);
        stack1.push(5);
        stack1.push(99);
        stack1.display();

        System.out.println(stack1.pop());
        System.out.println(stack1.pop());
        System.out.println(stack1.pop());
        //System.out.println(stack.pop());




        CustomStack stack2 = new DynamicStack(3);
        stack2.push(1);
        stack2.push(3);
        stack2.push(5);
        stack2.push(99);
        stack2.push(201);
        stack2.display();

        System.out.println(stack2.pop());
        System.out.println(stack2.pop());
        System.out.println(stack2.pop());
        System.out.println(stack2.pop());
        System.out.println(stack2.peek());
        System.out.println(stack2.peek());
        System.out.println(stack2.peek());
        System.out.println(stack2.peek());
        System.out.println(stack2.peek());

    }

}