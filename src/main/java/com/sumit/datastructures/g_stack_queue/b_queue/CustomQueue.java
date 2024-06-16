package com.sumit.datastructures.g_stack_queue.b_queue;

public class CustomQueue {

    protected int[] arr;
    private int end = -1;

    private static final int DEFAULT_SIZE = 10;
    CustomQueue(){
        this(DEFAULT_SIZE);
    }

    CustomQueue(int size){
        arr = new int[size];
    }

    public boolean insert(int num){
        if(isFull()) {
            System.out.println("Queue is full... can't insert.");
            return false;
        }
        arr[++end] = num;
        return true;
    }

    public int remove() throws QueueException {
        if(isEmpty()) {
            throw new QueueException("Queue is empty... can't remove.");
        }

        int elementToRemove = arr[0];
        for(int i=1; i <= end; i++){
            arr[i-1] = arr[i];
        }
        end--;
        return elementToRemove;
    }

    public void display() {
        for(int i=0; i<=end; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public int displayFirst() throws QueueException {
        if(isEmpty()) {
            throw new QueueException("Queue is empty... can't display.");
        }

        return arr[0];
    }

    public boolean isFull(){
        return end == arr.length-1;
    }

    public boolean isEmpty(){
        return end == -1;
    }
}