package com.sumit.datastructures.l_linkedlist;

public class LL1_Singly {

    private Node head;
    private Node tail;
    private int size;

    public LL1_Singly(){
        size=0;
    }

    public void insertFirst(int val){
        Node node = new Node(val);
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

        Node node = new Node(val);
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

        Node previousNode = head;
        for(int i = 1; i < index; i++){
            previousNode = previousNode.next;
        }

        Node newNode = new Node(val);
        newNode.next = previousNode.next;
        previousNode.next = newNode;

        size++;
    }

    public int deleteFirst(){
        if(tail == null)        // means if(size == 0)
            throw new RuntimeException("Not possible to delete element from empty list");

        Node node = head;
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

        Node previousNode = get(size-2);
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

        Node previousNode = get(index-1);
        int value = previousNode.next.val;

        previousNode.next = previousNode.next.next;
        size--;

        return value;
    }

    public Node get(int index){
        Node node = head;
        for(int i=0; i < index; i++)
            node = node.next;
        return node;
    }


    public Node find(int value){
        Node node = head;
        while(node != null){
            if(node.val == value)
                return node;
            node = node.next;
        }
        return null;
    }


    public void display(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }


}