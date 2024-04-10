package com.sumit.datastructures.l_linkedlist;

public class LL2_DoublyLinkedList {

    private Node head;


    public Node insertFirst(int value) {
        Node node = new Node(value);
        node.next = head;
        node.previous = null;

        // if this was the first element in the doubly linked list
        if(head != null)
            head.previous = node;

        head = node;
        return node;
    }

    public Node insertLast(int value) {
        Node node = new Node(value);

        Node lastNode = getLastNode();
        lastNode.next = node;

        node.previous = lastNode;
        node.next = null;

        return node;
    }

    public Node insert(int value, int index){
        if(index == 0){
            return insertFirst(value);
        }

        Node node = new Node(value);
        Node previousNode = get(index-1);
        Node nextNode = get(index);

        previousNode.next = node;
        nextNode.previous = node;
        node.next = nextNode;
        node.previous = previousNode;

        return node;
    }


    public Node deleteFirst(){
        Node deleteNode = head;
        Node nextNode = head.next;

        deleteNode.next = null;
        nextNode.previous = null;

        head = nextNode;
        return deleteNode;
    }

    public Node deleteLast() {
        Node deleteNode = getLastNode();
        Node previousNode = deleteNode.previous;

        previousNode.next=null;
        deleteNode.previous=null;
        return deleteNode;
    }

    public Node delete(int index) {
        if(index == 0)
            return deleteFirst();

        Node deleteNode = get(index);
        Node previousNode = deleteNode.previous;
        Node nextNode = deleteNode.next;

        deleteNode.next=nextNode;
        nextNode.previous=previousNode;
        return deleteNode;
    }

        public Node getLastNode(){
        if(head == null)
            return null;

        Node node = head;
        while(node.next != null){
            node = node.next;
        }
        return node;
    }

    public Node get(int index){
        Node node = head;
        for(int i = 0; i < index; i++){
            if(node == null)
                return null;
            node = node.next;
        }
        return node;
    }


    public Node find(int value){
        Node node = head;
        while(node != null){
            if(node.value == value)
                return node;
            node = node.next;
        }
        return null;
    }

    public void display(){
        Node node = head;
        while(node != null) {
            System.out.print(node.value + " -> ");
            node = node.next;
        }
        System.out.println("null");
    }


    private class Node {
        int value;
        Node next;
        Node previous;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next, Node previous) {
            this.value = value;
            this.next = next;
            this.previous = previous;
        }
    }

}