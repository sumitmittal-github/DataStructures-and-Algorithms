package com.sumit.datastructures.f_linkedlist.b_doubly;

public class DoublyLinkedListMain {

    public static void main(String[] args) {

        DoublyLinkedList ll = new DoublyLinkedList();
        ll.insertAtHead(1);
        ll.insertAtTail(2);
        ll.insertAtHead(3);

        ll.display();
        ll.deleteHead();
        ll.display();

        ll.insertAtHead(4);
        ll.insertAtHead(5);
        ll.display();

        ll.deleteHead();
        ll.display();

        ll.insertAtTail(6);
        ll.insert(7,0);
        ll.display();

        ll.deleteHead();
        ll.display();

        ll.deleteTail();
        ll.display();

        ll.delete(0);
        ll.display();

        System.out.println(ll.find(1));
        System.out.println(ll.find(2));
        System.out.println(ll.find(0));
        System.out.println(ll.find(-1));
    }

}