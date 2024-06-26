package com.sumit.datastructures.f_linkedlist.a_singly.collegewallah;

import com.sumit.datastructures.f_linkedlist.a_singly.ListNode;
import com.sumit.utils.DSAUtils;

public class Q5_DeleteMiddleNode {

    // LeetCode-2095 : https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/description/

    public ListNode deleteMiddle(ListNode head) {
        if(head == null || head.next == null)
            return null;

        ListNode previousNode = getPreviousNodeOfMidNode(head);
        previousNode.next = previousNode.next.next;
        return head;
    }

    public ListNode getPreviousNodeOfMidNode(ListNode head){
        ListNode fast = head;
        ListNode slow = head;

        ListNode previousNode = null;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            previousNode = slow;   // get previous node of the slow node
            slow = slow.next;
        }
        return previousNode;
    }




    public static void main(String[] args) {

        Q5_DeleteMiddleNode obj = new Q5_DeleteMiddleNode();

        // Program-1 : linked list with length = 1
        ListNode q1_ll1 = new ListNode(1, null);
        DSAUtils.displayLinkedList(obj.deleteMiddle(q1_ll1));

        // Program-2 : linked list with length : 2
        ListNode q2_ll1 = new ListNode(1, null);
        ListNode q2_ll2 = new ListNode(2, null);
        q2_ll1.next = q2_ll2;
        DSAUtils.displayLinkedList(obj.deleteMiddle(q2_ll1));

        // Program-3 : linked list with length : 3
        ListNode q3_ll1 = new ListNode(1, null);
        ListNode q3_ll2 = new ListNode(2, null);
        ListNode q3_ll3 = new ListNode(3, null);
        q3_ll1.next = q3_ll2;
        q3_ll2.next = q3_ll3;
        DSAUtils.displayLinkedList(obj.deleteMiddle(q3_ll1));

        // Program-4 : linked list with length : 4
        ListNode q4_ll1 = new ListNode(1, null);
        ListNode q4_ll2 = new ListNode(2, null);
        ListNode q4_ll3 = new ListNode(3, null);
        ListNode q4_ll4 = new ListNode(4, null);
        q4_ll1.next = q4_ll2;
        q4_ll2.next = q4_ll3;
        q4_ll3.next = q4_ll4;
        DSAUtils.displayLinkedList(obj.deleteMiddle(q4_ll1));

        // Program-5 : linked list with length : 5
        ListNode q5_ll1 = new ListNode(1, null);
        ListNode q5_ll2 = new ListNode(2, null);
        ListNode q5_ll3 = new ListNode(3, null);
        ListNode q5_ll4 = new ListNode(4, null);
        ListNode q5_ll5 = new ListNode(5, null);
        q5_ll1.next = q5_ll2;
        q5_ll2.next = q5_ll3;
        q5_ll3.next = q5_ll4;
        q5_ll4.next = q5_ll5;
        DSAUtils.displayLinkedList(obj.deleteMiddle(q5_ll1));
    }

}