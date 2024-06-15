package com.sumit.datastructures.l_linkedlist.b_doubly;

public class ListNodeD {

    public int val;
    public ListNodeD next;
    public ListNodeD previous;

    public ListNodeD(int val) {
        this.val = val;
    }

    public ListNodeD(int val, ListNodeD next, ListNodeD previous) {
        this.val = val;
        this.next = next;
        this.previous = previous;
    }

}