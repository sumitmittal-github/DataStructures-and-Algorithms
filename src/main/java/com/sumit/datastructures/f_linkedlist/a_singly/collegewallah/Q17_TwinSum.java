package com.sumit.datastructures.f_linkedlist.a_singly.collegewallah;

import com.sumit.datastructures.f_linkedlist.a_singly.ListNode;

public class Q17_TwinSum {

    // LeetCode-2130 : https://leetcode.com/problems/maximum-twin-sum-of-a-linked-list/description/

    /** Program :
     find the maximum twin sum of a linked list of even length
     Twin numbers are :
     -number at 0th index and number and length-0 index
     -number at 1st index and number and length-1 index
     -number at 2nd index and number and length-2 index and so on

     Input: head = [1,5,3,2,13,9]
     Ans     = max(   10(1+9),    18(5+13),    5(3+2)   )
     = 18
     */


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