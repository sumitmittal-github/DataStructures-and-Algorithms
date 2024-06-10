package com.sumit.datastructures.l_linkedlist.a_singly.collegewallah;

import com.sumit.datastructures.l_linkedlist.a_singly.ListNode;

public class Q2_DeleteNodeFromLast {

    // LeetCode-19 : https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/


    // Approach-1 : Traversing Linked list more than once
    public ListNode removeNthFromEnd_1(ListNode head, int n) {
        if (head.next == null)
            return null;

        // Step-1 : get the size of the linked list
        int size = 0;
        ListNode temp = head;
        while (temp != null) {
            size++;
            temp = temp.next;
        }

        // if we need to delete the head node
        if (n == size) {
            head = head.next;
            return head;
        }

        // Step-2 : get previous node of the node we want to delete
        ListNode previousNode = head;
        for (int i = 1; i < size-n; i++) {
            previousNode = previousNode.next;
        }

        // Step-3 : delete the node (check if we are deleting the tail node)
        ListNode deleteNode = previousNode.next;
        if (deleteNode.next == null)    previousNode.next = null;
        else                            previousNode.next = deleteNode.next;
        return head;
    }


    // 2 Pointers Approach
    // Approach-2 : Best approach because Traversing Linked list only once
    public ListNode removeNthFromEnd_2(ListNode head, int n) {
        if (head.next == null)
            return null;

        // LOGIC : to get the previous node we need to take 2 pointers with difference of n+1 nodes

        // take pointer p1 and forward it n+1 times
        ListNode p1 = head;
        boolean isDeletingHead = false;
        for (int i = 1; i <= n+1; i++) {
            if(p1 == null) {
                isDeletingHead = true;
                break;
            }
            p1 = p1.next;
        }

        // if we are deleting the head node
        if(isDeletingHead){
            head = head.next;
        }
        else {
            // forward both pointers till p1 == null
            ListNode p2 = head;
            while (p1 != null) {
                p1 = p1.next;
                p2 = p2.next;
            }
            // now p2 is pointing to the previous node of the node we want to delete

            // delete the node (check if we are deleting the tail node)
            ListNode deleteNode = p2.next;
            if (deleteNode.next == null)    p2.next = null;
            else                            p2.next = deleteNode.next;
        }
        return head;
    }

}