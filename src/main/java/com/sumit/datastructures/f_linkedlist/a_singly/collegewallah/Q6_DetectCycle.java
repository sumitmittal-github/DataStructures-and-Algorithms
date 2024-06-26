package com.sumit.datastructures.f_linkedlist.a_singly.collegewallah;

import com.sumit.datastructures.f_linkedlist.a_singly.ListNode;

public class Q6_DetectCycle {

    // LeetCode-141 : https://leetcode.com/problems/linked-list-cycle/description/

    public boolean hasCycle(ListNode head) {
        if(head == null)
            return false;

        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if(fast == slow)
                return true;
        }
        return false;
    }


    public static void main(String[] args) {

        // Program-1 : which has a cycle
        ListNode q1_ll1 = new ListNode(3, null);
        ListNode q1_ll2 = new ListNode(2, null);
        ListNode q1_ll3 = new ListNode(0, null);
        ListNode q1_ll4 = new ListNode(-4, q1_ll2);
        q1_ll1.next = q1_ll2;
        q1_ll2.next = q1_ll3;
        q1_ll3.next = q1_ll4;
        System.out.println(new Q6_DetectCycle().hasCycle(q1_ll1));

        // Program-2 : which has a cycle
        ListNode q2_ll1 = new ListNode(1, null);
        ListNode q2_ll2 = new ListNode(2, null);
        q2_ll1.next = q2_ll2;
        q2_ll2.next = q2_ll1;
        System.out.println(new Q6_DetectCycle().hasCycle(q2_ll1));

        // Program-3 : which do not have a cycle
        ListNode q3_ll1 = new ListNode(1, null);
        ListNode q3_ll2 = new ListNode(2, null);
        ListNode q3_ll3 = new ListNode(3, null);
        ListNode q3_ll4 = new ListNode(4, null);
        q3_ll1.next = q3_ll2;
        q3_ll2.next = q3_ll3;
        q3_ll3.next = q3_ll4;
        System.out.println(new Q6_DetectCycle().hasCycle(q3_ll1));

        // Program-4 : which do not have a cycle
        ListNode q4_ll1 = new ListNode(1, null);
        System.out.println(new Q6_DetectCycle().hasCycle(q4_ll1));
    }

}