package com.sumit.datastructures.f_linkedlist.c_circular;

public class CircularLinkedListMain {

    public static void main(String[] args) {

        CircularLinkedList ll = new CircularLinkedList();
        ll.insert(23);
        ll.insert(3);
        ll.insert(19);
        ll.insert(55);
        ll.insert(75);
        ll.display();

        ll.delete(19);
        ll.display();

        ll.delete(75);
        ll.display();

        ll.delete(23);
        ll.display();
    }

}