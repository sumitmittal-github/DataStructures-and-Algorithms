package com.sumit.datastructures.l_linkedlist.c_circular;

public class LL3_CircularMain {

    public static void main(String[] args) {

        LL3_Circular ll = new LL3_Circular();
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