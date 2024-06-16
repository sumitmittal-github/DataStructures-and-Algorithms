package com.sumit.datastructures.f_linkedlist.a_singly.kunal;

import com.sumit.datastructures.f_linkedlist.a_singly.ListNodeRandom;

public class LL_Q1_InsertUsingRecursion {

    private ListNodeRandom head;

    // insert in LL using recursion
    public void insertUsingRecursion(int inputValue, int inputIndex){
        // at last recursion call we will get node at 0th index so point it to the head
        head = helper(inputValue, inputIndex, head);
    }
    private ListNodeRandom helper(int inputValue, int inputIndex, ListNodeRandom node){
        if(inputIndex == 0) {
            ListNodeRandom newNode = new ListNodeRandom(inputValue);
            newNode.next = node;
            return newNode;
        }

        node.next = helper(inputValue, inputIndex-1, node.next);
        return node;
    }


    public void display(){
        ListNodeRandom node = head;
        while(node != null){
            System.out.print(node.val + " -> ");
            node = node.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        LL_Q1_InsertUsingRecursion ll = new LL_Q1_InsertUsingRecursion();
        ll.insertUsingRecursion(11, 0);
        ll.insertUsingRecursion(12, 1);
        ll.insertUsingRecursion(13, 2);
        ll.insertUsingRecursion(14, 1);
        ll.insertUsingRecursion(15, 4);
        ll.insertUsingRecursion(16, 0);
        ll.display();
    }

}