package com.sumit.datastructures.l_linkedlist.questions;

public class LL_Q1_InsertUsingRecursion {

    public static void main(String[] args) {
        LL_Q1_InsertUsingRecursion ll = new LL_Q1_InsertUsingRecursion();
        ll.insertUsingRecursion(11, 0);
        ll.insertUsingRecursion(12, 1);
        ll.insertUsingRecursion(13, 2);
        ll.insertUsingRecursion(14, 1);
        ll.insertUsingRecursion(15, 4);
        ll.insertUsingRecursion(16, 0);
        ll.display();
    }



    private Node head;

    // insert in LL using recursion
    public void insertUsingRecursion(int inputValue, int inputIndex){
        // at last recursion call we will get node at 0th index so point it to the head
        head = helper(inputValue, inputIndex, head);
    }

    private Node helper(int inputValue, int inputIndex, Node node){
        if(inputIndex == 0) {
            Node newNode = new Node(inputValue);
            newNode.next = node;
            return newNode;
        }

        node.next = helper(inputValue, inputIndex-1, node.next);
        return node;
    }


    public void display(){
        Node node = head;
        while(node != null){
            System.out.print(node.value + " -> ");
            node = node.next;
        }
        System.out.println("null");
    }



    private class Node {

        private int value;
        private Node next = null;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

}