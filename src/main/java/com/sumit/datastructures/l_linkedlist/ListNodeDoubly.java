package com.sumit.datastructures.l_linkedlist;

public class ListNodeDoubly {

    int val;
    ListNodeDoubly next;
    ListNodeDoubly previous;

    public ListNodeDoubly(int val) {
        this.val = val;
    }

    public ListNodeDoubly(int val, ListNodeDoubly next, ListNodeDoubly previous) {
        this.val = val;
        this.next = next;
        this.previous = previous;
    }

}