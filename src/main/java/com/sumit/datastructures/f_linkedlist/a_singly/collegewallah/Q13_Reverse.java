package com.sumit.datastructures.f_linkedlist.a_singly.collegewallah;

import com.sumit.datastructures.f_linkedlist.a_singly.ListNode;
import com.sumit.utils.DSAUtils;

public class Q13_Reverse {

    // LeetCode-206 : https://leetcode.com/problems/reverse-linked-list/description/


    // Better approach : because space complexity is O(1)
    public ListNode reverseList_iteration(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode previous = null;
        ListNode current = head;

        while (current != null) {
            ListNode next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;
    }


    // Not a good approach : because in recursion we maintain call stack, therefore space complexity is O(n)
    public ListNode reverseList_recursion(ListNode node) {
        // STEP-1 : base condition
        if(node.next == null) {
            return node;
        }

        // STEP-2 : call
        ListNode nextNode = reverseList_recursion(node.next);

        // STEP-3 : work
        node.next.next = node;
        node.next = null;
        return nextNode;
    }


    public static void main(String[] args) {
        Q13_Reverse obj = new Q13_Reverse();

        ListNode q1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, null)))));
        DSAUtils.displayLinkedList(q1);
        DSAUtils.displayLinkedList(obj.reverseList_iteration(q1));

        ListNode q2 = new ListNode(1, new ListNode(2, null));
        DSAUtils.displayLinkedList(q2);
        DSAUtils.displayLinkedList(obj.reverseList_iteration(q2));
    }



}