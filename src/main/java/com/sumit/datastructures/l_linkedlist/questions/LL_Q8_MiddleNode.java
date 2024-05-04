package com.sumit.datastructures.l_linkedlist.questions;

public class LL_Q8_MiddleNode {

    // LeetCode-876 : https://leetcode.com/problems/middle-of-the-linked-list/description/

    public static void main(String[] args) {

        // Program-1 : linked list with length = 1
        ListNode q1_ll1 = new ListNode(1, null);
        System.out.println(new LL_Q8_MiddleNode().middleNode(q1_ll1).val);

        // Program-2 : linked list with length : 2
        ListNode q2_ll1 = new ListNode(1, null);
        ListNode q2_ll2 = new ListNode(2, null);
        q2_ll1.next = q2_ll2;
        System.out.println(new LL_Q8_MiddleNode().middleNode(q2_ll1).val);

        // Program-3 : linked list with length : 3
        ListNode q3_ll1 = new ListNode(1, null);
        ListNode q3_ll2 = new ListNode(2, null);
        ListNode q3_ll3 = new ListNode(3, null);
        q3_ll1.next = q3_ll2;
        q3_ll2.next = q3_ll3;
        System.out.println(new LL_Q8_MiddleNode().middleNode(q3_ll1).val);

        // Program-4 : linked list with length : 4
        ListNode q4_ll1 = new ListNode(1, null);
        ListNode q4_ll2 = new ListNode(2, null);
        ListNode q4_ll3 = new ListNode(3, null);
        ListNode q4_ll4 = new ListNode(4, null);
        q4_ll1.next = q4_ll2;
        q4_ll2.next = q4_ll3;
        q4_ll3.next = q4_ll4;
        System.out.println(new LL_Q8_MiddleNode().middleNode(q4_ll1).val);

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
        System.out.println(new LL_Q8_MiddleNode().middleNode(q5_ll1).val);
    }

    public ListNode middleNode(ListNode head) {
        if(head == null)
            return null;
        if(head.next == null)
            return head;

        ListNode fast = head;
        ListNode slow = head;

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

}