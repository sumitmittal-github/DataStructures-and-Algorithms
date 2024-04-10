package com.sumit.datastructures.l_linkedlist;

public class LL1_SinglyMain {

    public static void main(String[] args) {

        LL1_Singly ll = new LL1_Singly();
        ll.insertFirst(1);
        ll.insertLast(2);
        ll.insertFirst(3);

        ll.display();
        ll.deleteFirst();
        ll.display();

        ll.insertFirst(4);
        ll.insertFirst(5);
        ll.display();

        ll.deleteFirst();
        ll.display();

        ll.insertLast(6);
        ll.insert(7,0);
        ll.display();

        ll.deleteFirst();
        ll.display();

        ll.deleteLast();
        ll.display();

        ll.delete(0);
        ll.display();

        System.out.println(ll.find(1));
        System.out.println(ll.find(2));
        System.out.println(ll.find(0));
        System.out.println(ll.find(-1));
    }

}