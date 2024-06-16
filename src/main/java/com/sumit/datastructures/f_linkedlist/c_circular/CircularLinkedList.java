package com.sumit.datastructures.f_linkedlist.c_circular;

import com.sumit.datastructures.f_linkedlist.a_singly.ListNode;

public class CircularLinkedList {

    private ListNode head;
    private ListNode tail;


    public void display(){
        if(head == null)
            return;

        ListNode temp = head;
        do{
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        } while(temp != head);
        System.out.println();
    }

    public void insert(int value){
        ListNode node = new ListNode(value);

        if(head == null){
            node.next = node;
            head = node;
            tail = node;
        }
        else {
            tail.next = node;
            node.next = head;
            tail = node;
        }
    }

    public void delete(int value) {
        if(head == null)
            return;

        if(head.val == value){
            tail.next = head.next;
            head = head.next;
            return;
        }

        ListNode node = head;
        do{
            ListNode nextNode = node.next;
            if(nextNode.val == value){
                node.next = nextNode.next;
                if(nextNode == tail)
                    tail = node;
                break;
            }
            node = node.next;
        }
        while(node != head);
    }





}