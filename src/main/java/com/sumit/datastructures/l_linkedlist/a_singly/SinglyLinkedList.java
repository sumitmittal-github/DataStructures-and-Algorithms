package com.sumit.datastructures.l_linkedlist.a_singly;

public class SinglyLinkedList {

    private ListNode head;
    private ListNode tail;
    private int size;

    public SinglyLinkedList(){
        size=0;
    }

    public void insertFirst(int val){
        ListNode node = new ListNode(val);
        node.next = head;
        head = node;

        if(tail == null)
            tail = head;

        size++;
    }

    public void insertLast(int val){
        if(tail == null){
            insertFirst(val);
            return;
        }

        ListNode node = new ListNode(val);
        tail.next = node;
        tail = node;
        size++;
    }

    public void insert(int val, int index) throws RuntimeException {
        if(index == 0){
            insertFirst(val);
            return;
        }
        if(index == size){
            insertLast(val);
            return;
        }
        if(index > size){
            throw new RuntimeException("Not possible to add " + val + " at index :" + index);
        }

        ListNode previousNode = head;
        for(int i = 1; i < index; i++){
            previousNode = previousNode.next;
        }

        ListNode newNode = new ListNode(val);
        newNode.next = previousNode.next;
        previousNode.next = newNode;

        size++;
    }

    public int deleteFirst(){
        if(tail == null)        // means if(size == 0)
            throw new RuntimeException("Not possible to delete element from empty list");

        ListNode node = head;
        if(head == tail) {      // means if(size == 1)
            head = node.next;   // means head = null
            tail = node.next;   // means tail = null
        } else {
            head = node.next;
        }

        size--;
        return node.val;
    }

    public int deleteLast(){
        if(size <= 1)
            return deleteFirst();

        ListNode previousNode = get(size-2);
        int value = previousNode.next.val;
        tail = previousNode;
        previousNode.next = null;
        size--;
        return value;
    }

    public int delete(int index){
        if(index == 0)
            return deleteFirst();

        if(index == size-1)
            return deleteLast();

        ListNode previousNode = get(index-1);
        int value = previousNode.next.val;

        previousNode.next = previousNode.next.next;
        size--;

        return value;
    }

    public ListNode get(int index){
        ListNode node = head;
        for(int i=0; i < index; i++)
            node = node.next;
        return node;
    }


    public ListNode find(int value){
        ListNode node = head;
        while(node != null){
            if(node.val == value)
                return node;
            node = node.next;
        }
        return null;
    }


    public void display(){
        ListNode temp = head;
        while(temp != null){
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }


}