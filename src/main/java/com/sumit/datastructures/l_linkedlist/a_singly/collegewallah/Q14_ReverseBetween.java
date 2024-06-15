package com.sumit.datastructures.l_linkedlist.a_singly.collegewallah;

import com.sumit.datastructures.l_linkedlist.a_singly.ListNode;
import com.sumit.utils.DSAUtils;

public class Q14_ReverseBetween {

    // LeetCode-92 : https://leetcode.com/problems/reverse-linked-list-ii/description/

    public ListNode reverseBetween(ListNode head, int left, int right) {
        // if left == right, then it means no change in the list
        if(head == null || head.next == null || left == right)
            return head;


        //STEP-1: get the previous node of left node (from where we will start reversing the list)
        ListNode previousNodeOfLeft = null;
        ListNode nodeOfLeft = head;
        for(int i=1; i<left; i++) {
            nodeOfLeft = nodeOfLeft.next;
            if(previousNodeOfLeft == null)    previousNodeOfLeft = head;
            else                              previousNodeOfLeft = previousNodeOfLeft.next;
        }


        // STEP-2 : iterate till right index of linked list and reverse it
        ListNode current = nodeOfLeft;
        ListNode previous = previousNodeOfLeft;
        while(left <= right){
            ListNode next = current.next;
            current.next = previous;
            previous = current;
            current = next;
            left++;
        }
        // At the end of the above while loop :
        // 1). previous is pointing to the node at index(right)
        // 2). current and next is pointing to the node at index(right+1)
        ListNode nodeOfRight = previous;
        ListNode nextNodeOfRight = current;


        // STEP-3 : attach node at index(left) to node(right+1)
        //        : attach node at index(left-1) to node(right)
        nodeOfLeft.next = nextNodeOfRight;
        if(previousNodeOfLeft != null)
            previousNodeOfLeft.next = nodeOfRight;
        else
            head = nodeOfRight;

        return head;
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(1,
                new ListNode(2,
                        new ListNode(3,
                                new ListNode(4,
                                        new ListNode(5, null)))));

        Q14_ReverseBetween obj = new Q14_ReverseBetween();
        DSAUtils.displayLinkedList(obj.reverseBetween(head, 2, 4));
    }
}