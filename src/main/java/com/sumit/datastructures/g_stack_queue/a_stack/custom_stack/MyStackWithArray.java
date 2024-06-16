package com.sumit.datastructures.g_stack_queue.a_stack.custom_stack;

public class MyStackWithArray {

    private int[] arr;
    private int current_size;

    public MyStackWithArray(int max_size){
        this.arr = new int[max_size];
    }

    public void push(int element){
        if(current_size == arr.length)
            throw new CustomException("Stack is already full. Insertion is not possible");

        arr[current_size] = element;
        current_size++;
    }

    public void pushAtBottom(int element){
        if(current_size == arr.length)
            throw new CustomException("Stack is already full. Insertion is not possible");

        for(int i=current_size-1; i>=0; i--) {
            arr[i+1] = arr[i];
        }
        arr[0] = element;
        current_size++;
    }

    public void pushAtIndex(int index, int element){
        if(current_size == arr.length)
            throw new CustomException("Stack is already full. Insertion is not possible");
        if(index < 0 || index >= arr.length || index > current_size)
            throw new CustomException("Not a valid index");

        for(int i=current_size-1; i>=index; i--) {
            arr[i+1] = arr[i];
        }
        arr[index] = element;
        current_size++;
    }

    public int peek(){
        if(current_size == 0)
            throw new CustomException("Stack is empty. Peek is not possible");

        return arr[current_size-1];
    }

    public int pop(){
        if(current_size == 0)
            throw new CustomException("Stack is empty. Pop is not possible");

        int element = arr[current_size-1];
        arr[current_size-1] = 0;
        current_size--;
        return element;
    }

    public int popFromBottom(){
        if(current_size == 0)
            throw new CustomException("Stack is empty. Pop is not possible");

        int element = arr[0];
        for(int i=1; i<current_size; i++){
            arr[i-1] = arr[i];
        }
        arr[current_size-1] = 0;
        current_size--;
        return element;
    }

    public int popFromIndex(int index){
        if(current_size == 0)
            throw new CustomException("Stack is empty. Pop is not possible");
        if(index >= current_size)
            throw new CustomException("Pop is not possible, as no element at index "+index);

        int element = arr[index];
        for(int i=index+1; i<current_size; i++){
            arr[i-1] = arr[i];
        }
        arr[current_size-1] = 0;
        current_size--;
        return element;
    }

    public int size(){
        return current_size;
    }

    public void display(){
        for(int i=0; i<current_size; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }





    public static void main(String[] args) {
        MyStackWithArray stack = new MyStackWithArray(10);
        stack.pushAtBottom(9);
        stack.push(10);
        System.out.println(stack.peek());
        stack.push(11);
        stack.pushAtIndex(1,12);
        stack.pushAtBottom(13);
        stack.display();

        System.out.println(stack.peek());
        System.out.println(stack.pop());
        stack.display();

        stack.pushAtBottom(14);
        stack.push(15);
        stack.push(16);
        stack.pushAtIndex(1,17);
        stack.pushAtBottom(18);
        stack.display();

        System.out.println(stack.peek());
        System.out.println(stack.popFromBottom());
        System.out.println(stack.popFromIndex(3));
        System.out.println(stack.popFromIndex(stack.current_size-1));
        System.out.println(stack.popFromIndex(0));
        System.out.println(stack.peek());
        stack.display();
    }

}