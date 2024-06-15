package com.sumit.datastructures.l_linkedlist.a_singly.collegewallah;

import com.sumit.datastructures.l_linkedlist.a_singly.ListNode;

public class Q16_TwinSum {

    // LeetCode-2130 : https://leetcode.com/problems/maximum-twin-sum-of-a-linked-list/description/


    public int pairSum(ListNode head) {
        // Step-1 : find the leftMid
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode leftMid = slow;

        // Step-2 : Reverse the 2nd half linked list
        ListNode previous = null;
        ListNode current = leftMid.next;
        while(current != null){
            ListNode next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        leftMid.next = previous;

        // Step-3 : compare all twin sums
        int maxTwinSum = 0;
        ListNode first = head;
        ListNode second = leftMid.next;
        while(second != null) {
            maxTwinSum = Math.max(maxTwinSum, first.val+ second.val);
        }
        return maxTwinSum;
    }





}