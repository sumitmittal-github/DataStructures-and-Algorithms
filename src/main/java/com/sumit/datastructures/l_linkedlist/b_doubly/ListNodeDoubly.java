package com.sumit.datastructures.l_linkedlist.b_doubly;

public class ListNodeDoubly {

    public int val;
    public ListNodeDoubly next;
    public ListNodeDoubly previous;

    public ListNodeDoubly(int val) {
        this.val = val;
    }

    public ListNodeDoubly(int val, ListNodeDoubly next, ListNodeDoubly previous) {
        this.val = val;
        this.next = next;
        this.previous = previous;
    }

}