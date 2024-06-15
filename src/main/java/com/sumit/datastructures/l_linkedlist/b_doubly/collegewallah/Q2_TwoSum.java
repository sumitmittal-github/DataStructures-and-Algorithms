package com.sumit.datastructures.l_linkedlist.b_doubly.collegewallah;

import com.sumit.datastructures.l_linkedlist.b_doubly.DoublyLinkedList;
import com.sumit.datastructures.l_linkedlist.b_doubly.ListNodeD;

public class Q2_TwoSum {

    /**
        Question : From a non-decreasing doubly linked list, print the nodes whose sum is equal to given integer
            Ex -    Doubly LL =  3  <->  5  <->  8  <->  13  <->  100,    sum = 16
            O/p -   3 & 13
    */

    public void twoSum(ListNodeD head, int sum){
        if(head == null)    return;

        // Step-1 : find tail
        ListNodeD tail = head;
        while(tail.next != null){
            tail = tail.next;
        }

        ListNodeD h = head;
        ListNodeD t = tail;
        while(h.val < t.val){
            if(h.val + t.val == sum){
                System.out.println(h.val + " & " + t.val);
                return;
            }
            if(h.val + t.val > sum)     t = t.previous;
            if(h.val + t.val < sum)     h = h.next;
        }
        System.out.println("No combinations exists !!");
    }

    public static void main(String[] args) {
        Q2_TwoSum obj = new Q2_TwoSum();

        DoublyLinkedList list = new DoublyLinkedList();
        list.insertAtTail(3);     list.insertAtTail(5);     list.insertAtTail(8);     list.insertAtTail(13);     list.insertAtTail(100);
        list.display();
        obj.twoSum(list.get(0), 113);
        obj.twoSum(list.get(0), 114);
    }

}