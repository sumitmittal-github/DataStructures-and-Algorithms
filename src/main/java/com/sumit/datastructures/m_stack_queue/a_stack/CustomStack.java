package com.sumit.datastructures.m_stack_queue.a_stack;

public class CustomStack {

    protected int[] arr;
    private int ptr = -1;


    private static final int DEFAULT_SIZE = 10;
    CustomStack(){
        this(DEFAULT_SIZE);
    }

    CustomStack(int size){
        arr = new int[size];
    }

    public boolean push(int num){
        if(isFull()) {
            System.out.println("Stack is full... can't insert more.");
            return false;
        }
        arr[++ptr] = num;
        return true;
    }

    public int pop() throws StackException {
        if(isEmpty()) {
            throw new StackException("Stack is empty... can't pop.");
        }
        return arr[ptr--];
    }

    public int peek() throws StackException {
        if(isEmpty()) {
            throw new StackException("Stack is empty... can't peek.");
        }
        return arr[ptr];
    }


    public void display() {
        for(int i=0; i<=ptr; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public boolean isFull(){
        return ptr == arr.length-1;
    }

    public boolean isEmpty(){
        return ptr == -1;
    }

}