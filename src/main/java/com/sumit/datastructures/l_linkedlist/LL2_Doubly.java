package com.sumit.datastructures.l_linkedlist;

public class LL2_Doubly {

    private ListNodeDoubly head;


    public ListNodeDoubly insertFirst(int value) {
        ListNodeDoubly node = new ListNodeDoubly(value);
        node.next = head;
        node.previous = null;

        // if this was the first element in the doubly linked list
        if(head != null)
            head.previous = node;

        head = node;
        return node;
    }

    public ListNodeDoubly insertLast(int value) {
        if(head == null){
            return insertFirst(value);
        }

        ListNodeDoubly node = new ListNodeDoubly(value);

        ListNodeDoubly lastNode = getLastNode();
        lastNode.next = node;

        node.previous = lastNode;
        node.next = null;

        return node;
    }

    public ListNodeDoubly insert(int value, int index){
        if(index == 0 || head == null){
            return insertFirst(value);
        }

        ListNodeDoubly node = new ListNodeDoubly(value);
        ListNodeDoubly previousNode = get(index-1);
        ListNodeDoubly nextNode = get(index);

        previousNode.next = node;
        nextNode.previous = node;
        node.next = nextNode;
        node.previous = previousNode;

        return node;
    }


    public ListNodeDoubly deleteFirst(){
        ListNodeDoubly deleteNode = head;
        ListNodeDoubly nextNode = head.next;

        deleteNode.next = null;
        nextNode.previous = null;

        head = nextNode;
        return deleteNode;
    }

    public ListNodeDoubly deleteLast() {
        ListNodeDoubly deleteNode = getLastNode();
        ListNodeDoubly previousNode = deleteNode.previous;

        previousNode.next=null;
        deleteNode.previous=null;
        return deleteNode;
    }

    public ListNodeDoubly delete(int index) {
        if(index == 0)
            return deleteFirst();

        ListNodeDoubly deleteNode = get(index);
        ListNodeDoubly previousNode = deleteNode.previous;
        ListNodeDoubly nextNode = deleteNode.next;

        deleteNode.next=nextNode;
        nextNode.previous=previousNode;
        return deleteNode;
    }

        public ListNodeDoubly getLastNode(){
        if(head == null)
            return null;

            ListNodeDoubly node = head;
        while(node.next != null){
            node = node.next;
        }
        return node;
    }

    public ListNodeDoubly get(int index){
        ListNodeDoubly node = head;
        for(int i = 0; i < index; i++){
            if(node == null)
                return null;
            node = node.next;
        }
        return node;
    }


    public ListNodeDoubly find(int value){
        ListNodeDoubly node = head;
        while(node != null){
            if(node.val == value)
                return node;
            node = node.next;
        }
        return null;
    }

    public void display(){
        ListNodeDoubly node = head;
        while(node != null) {
            System.out.print(node.val + " -> ");
            node = node.next;
        }
        System.out.println("null");
    }

}