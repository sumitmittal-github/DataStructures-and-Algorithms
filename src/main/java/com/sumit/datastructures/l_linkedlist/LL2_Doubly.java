package com.sumit.datastructures.l_linkedlist;

public class LL2_Doubly {

    private NodeDoubly head;


    public NodeDoubly insertFirst(int value) {
        NodeDoubly node = new NodeDoubly(value);
        node.next = head;
        node.previous = null;

        // if this was the first element in the doubly linked list
        if(head != null)
            head.previous = node;

        head = node;
        return node;
    }

    public NodeDoubly insertLast(int value) {
        if(head == null){
            return insertFirst(value);
        }

        NodeDoubly node = new NodeDoubly(value);

        NodeDoubly lastNode = getLastNode();
        lastNode.next = node;

        node.previous = lastNode;
        node.next = null;

        return node;
    }

    public NodeDoubly insert(int value, int index){
        if(index == 0 || head == null){
            return insertFirst(value);
        }

        NodeDoubly node = new NodeDoubly(value);
        NodeDoubly previousNode = get(index-1);
        NodeDoubly nextNode = get(index);

        previousNode.next = node;
        nextNode.previous = node;
        node.next = nextNode;
        node.previous = previousNode;

        return node;
    }


    public NodeDoubly deleteFirst(){
        NodeDoubly deleteNode = head;
        NodeDoubly nextNode = head.next;

        deleteNode.next = null;
        nextNode.previous = null;

        head = nextNode;
        return deleteNode;
    }

    public NodeDoubly deleteLast() {
        NodeDoubly deleteNode = getLastNode();
        NodeDoubly previousNode = deleteNode.previous;

        previousNode.next=null;
        deleteNode.previous=null;
        return deleteNode;
    }

    public NodeDoubly delete(int index) {
        if(index == 0)
            return deleteFirst();

        NodeDoubly deleteNode = get(index);
        NodeDoubly previousNode = deleteNode.previous;
        NodeDoubly nextNode = deleteNode.next;

        deleteNode.next=nextNode;
        nextNode.previous=previousNode;
        return deleteNode;
    }

        public NodeDoubly getLastNode(){
        if(head == null)
            return null;

            NodeDoubly node = head;
        while(node.next != null){
            node = node.next;
        }
        return node;
    }

    public NodeDoubly get(int index){
        NodeDoubly node = head;
        for(int i = 0; i < index; i++){
            if(node == null)
                return null;
            node = node.next;
        }
        return node;
    }


    public NodeDoubly find(int value){
        NodeDoubly node = head;
        while(node != null){
            if(node.val == value)
                return node;
            node = node.next;
        }
        return null;
    }

    public void display(){
        NodeDoubly node = head;
        while(node != null) {
            System.out.print(node.val + " -> ");
            node = node.next;
        }
        System.out.println("null");
    }

}