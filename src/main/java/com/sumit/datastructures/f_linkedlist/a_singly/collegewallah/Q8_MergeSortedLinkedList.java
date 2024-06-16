package com.sumit.datastructures.f_linkedlist.a_singly.collegewallah;

import com.sumit.datastructures.f_linkedlist.a_singly.ListNode;

public class Q8_MergeSortedLinkedList {

    // LeetCode-21 : https://leetcode.com/problems/merge-two-sorted-lists/description/

    public ListNode mergeTwoLists(ListNode head1, ListNode head2) {
        ListNode tempHead = new ListNode(-1);
        ListNode newHead = tempHead;

        while(head1 != null && head2 != null) {
            if(head1.val < head2.val){
                tempHead.next = head1;
                head1 = head1.next;
            } else {
                tempHead.next = head2;
                head2 = head2.next;
            }
            tempHead = tempHead.next;
        }
        if(head1 != null) tempHead.next = head1;
        if(head2 != null) tempHead.next = head2;
        return newHead.next;
    }

}