package com.sumit.datastructures.l_linkedlist;

public class NodeDoubly {

    int val;
    NodeDoubly next;
    NodeDoubly previous;

    public NodeDoubly(int val) {
        this.val = val;
    }

    public NodeDoubly(int val, NodeDoubly next, NodeDoubly previous) {
        this.val = val;
        this.next = next;
        this.previous = previous;
    }

}