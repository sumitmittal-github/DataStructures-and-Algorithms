package com.sumit.datastructures.m_stack_queue.b_queue;

public class MainClass {

    public static void main(String[] args) throws QueueException {

        CustomQueue queue1 = new CustomQueue(3);
        queue1.insert(1);
        queue1.insert(3);
        queue1.insert(5);
        queue1.insert(99);
        queue1.display();

        System.out.println(queue1.remove());
        System.out.println(queue1.remove());
        System.out.println(queue1.remove());
        //System.out.println(queue1.remove());

        /*CustomStack stack2 = new DynamicStack(3);
        stack2.push(1);
        stack2.push(3);
        stack2.push(5);
        stack2.push(99);
        stack2.push(201);
        System.out.println(stack2.pop());
        System.out.println(stack2.pop());
        System.out.println(stack2.pop());
        System.out.println(stack2.pop());
        System.out.println(stack2.peek());
        System.out.println(stack2.peek());
        System.out.println(stack2.peek());
        System.out.println(stack2.peek());
        System.out.println(stack2.peek());*/

    }

}