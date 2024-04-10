package com.sumit.datastructures.l_linkedlist;

public class LL3_Circular {

    private Node head;
    private Node tail;


    public void insert(int value){
        Node node = new Node(value);

        if(head == null){
            node.next = node;
            head = node;
            tail = node;
        }
        else {
            tail.next = node;
            node.next = head;
            tail = node;
        }
    }

    public void delete(int value) {
        if(head == null)
            return;

        if(head.value == value){
            tail.next = head.next;
            head = head.next;
            return;
        }

        Node node = head;
        do{
            Node nextNode = node.next;
            if(nextNode.value == value){
                node.next = nextNode.next;
                if(nextNode == tail)
                    tail = node;
                break;
            }
            node = node.next;
        }
        while(node != head);
    }


    public void display(){
        Node node = head;
        if(head == null)
            return;

        do{
            System.out.print(node.value + " -> ");
            node = node.next;
        } while(node != head);
        System.out.println();
    }



    private class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

}