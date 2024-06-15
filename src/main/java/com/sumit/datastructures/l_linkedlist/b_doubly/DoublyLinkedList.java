package com.sumit.datastructures.l_linkedlist.b_doubly;

public class DoublyLinkedList {

    ListNodeD head;

    public ListNodeD insertAtHead(int val) {
        ListNodeD newNode = new ListNodeD(val);
        newNode.next = head;

        // if this was the first element in the doubly linked list
        if(head != null)
            head.previous = newNode;

        head = newNode;
        return head;
    }

    public void insertAtTail(int val) {
        if(head == null)
            return;

        // create new node
        ListNodeD newNode = new ListNodeD(val);

        // get last node and attach new node to it
        ListNodeD lastNode = getLastNode();
        lastNode.next = newNode;
        newNode.previous = lastNode;
    }

    public void insert(int val, int index){
        if(index == 0 || head == null)
            insertAtHead(val);

        // get previous and next nodes
        ListNodeD previousNode = get(index-1);
        ListNodeD nextNode = previousNode.next;

        // create new node and insert in between previous and next
        ListNodeD newNode = new ListNodeD(val);

        previousNode.next = newNode;
        newNode.previous = previousNode;
        newNode.next = nextNode;
        nextNode.previous = newNode;
    }

    public ListNodeD deleteHead(){
        head = head.next;
        head.previous = null;
        return head;
    }

    public void deleteTail() {
        ListNodeD temp = getLastNode();
        temp = temp.previous;
        temp.next = null;
    }

    public ListNodeD delete(int index) {
        if(index == 0)
            return deleteHead();

        ListNodeD deleteNode = get(index);
        deleteNode.previous.next = deleteNode.next;
        deleteNode.next.previous = deleteNode.previous;
        return deleteNode;
    }

    public ListNodeD get(int index){
        ListNodeD node = head;
        for(int i = 1; i <= index; i++){
            if(node == null)
                return null;
            node = node.next;
        }
        return node;
    }

    public ListNodeD getLastNode(){
        if(head == null)
            return null;

        ListNodeD node = head;
        while(node.next != null){
            node = node.next;
        }
        return node;
    }

    public ListNodeD find(int val){
        ListNodeD node = head;
        while(node != null){
            if(node.val == val)
                return node;
            node = node.next;
        }
        return null;
    }

    public void display(){
        ListNodeD node = head;
        while(node != null) {
            System.out.print(node.val + " -> ");
            node = node.next;
        }
        System.out.println("null");
    }

}