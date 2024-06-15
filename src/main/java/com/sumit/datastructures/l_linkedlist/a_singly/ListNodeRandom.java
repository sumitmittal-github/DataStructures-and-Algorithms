package com.sumit.datastructures.l_linkedlist.a_singly;

public class ListNodeRandom {
    public int val;
    public ListNodeRandom next;
    public ListNodeRandom random;

    public ListNodeRandom(int val) {
        this.val = val;
    }

    public ListNodeRandom(int val, ListNodeRandom next) {
        this.val = val;
        this.next = next;
    }

}