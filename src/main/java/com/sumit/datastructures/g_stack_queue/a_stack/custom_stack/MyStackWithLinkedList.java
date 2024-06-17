package com.sumit.datastructures.g_stack_queue.a_stack.custom_stack;

class Node {
    int val;
    Node next;

    public Node(int val) {
        this.val = val;
    }
}

public class MyStackWithLinkedList {

    Node head;
    int size;


    // means adding node at head and shift the head 1 position upside
    public void push(int element) {
        if(size == 0)
            head = new Node(element);
        else {
            Node newNode = new Node(element);
            newNode.next = head;
            head = newNode;
        }
        size++;
    }

    // means adding node at tail
    public void pushAtBottom(int element){
        if(size == 0)
            push(element);
        else {
            Node tail = head;
            while(tail.next != null)
                tail = tail.next;
            tail.next = new Node(element);
            size++;
        }
    }

    // means adding in between
    public void pushAtIndex(int index, int element){
        if(index < 0 || index > size)
            throw new CustomException("Not a valid index");

        if(index == size)                   push(element);              // push at head
        if(index == 0 || size == 0)         pushAtBottom(element);      // push at tail

        Node previousNode = head;
        for(int i=size; i>index+1; i--){
            previousNode = previousNode.next;
        }

        Node newNode = new Node(element);
        newNode.next = previousNode.next;
        previousNode.next = newNode;
        size++;
    }

    // return the element of head
    public int peek(){
        if(size == 0)
            throw new CustomException("Stack is empty. Peek is not possible");
        return head.val;
    }

    // return + remove the element of head
    public int pop(){
        if(size == 0)
            throw new CustomException("Stack is empty. Pop is not possible");

        int ans = head.val;
        head = head.next;
        size--;
        return ans;
    }

    // return + remove the element of tail
    public int popFromBottom(){
        if(size == 0)
            throw new CustomException("Stack is empty. Pop is not possible");
        else if(size == 1) {
            int ans = head.val;
            head = null;
            size--;
            return ans;
        } else {
            Node previousNode = head;
            for(int i=1; i<size-1; i++){
                previousNode = previousNode.next;
            }

            int ans = previousNode.next.val;
            previousNode.next = null;
            size--;
            return ans;
        }
    }

    public int popFromIndex(int index){
        if(size == 0)
            throw new CustomException("Stack is empty. Pop is not possible");
        if(index >= size)
            throw new CustomException("Pop is not possible, as no element at index "+index);
        if(index == 0)
            return popFromBottom();         // pop from tail
        if(index == size-1)
            return pop();                   // pop from head

        // find the previous node
        Node previousNode = head;
        for(int i=size-2; i>index; i--){
            previousNode = previousNode.next;
        }

        // adjust the pointers
        Node ans = previousNode.next;
        previousNode.next = previousNode.next.next;
        size--;
        return ans.val;
    }

    public int size(){
        return size;
    }

    // display elements from tail to head
    public void display(){
        Node temp = head;
        int[] tempArr = new int[size];
        for(int i=size-1; i>=0; i--){
            tempArr[i] = temp.val;
            temp = temp.next;
        }
        for(int i : tempArr){
            System.out.print(i + " ");
        }
        System.out.println();
    }





    public static void main(String[] args) {
        MyStackWithLinkedList stack = new MyStackWithLinkedList();
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
        System.out.println(stack.popFromIndex(stack.size-1));
        System.out.println(stack.popFromIndex(0));
        System.out.println(stack.peek());
        stack.display();
    }

}