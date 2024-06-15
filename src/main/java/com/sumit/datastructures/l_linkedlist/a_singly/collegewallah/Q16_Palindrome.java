package com.sumit.datastructures.l_linkedlist.a_singly.collegewallah;

import com.sumit.datastructures.l_linkedlist.a_singly.ListNode;

public class Q16_Palindrome {

    // LeetCode-234 : https://leetcode.com/problems/palindrome-linked-list/description/


    // Approach-1 : finding the left mid node in .5 iteration, using fast and slow pointer
    public boolean isPalindrome_1(ListNode head) {

        // Step-1 : find the leftMid
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode leftMid = slow;

        // Step-2 : Reverse the 2nd half linkedlist
        ListNode previous = null;
        ListNode current = leftMid.next;
        while(current != null){
            ListNode next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        leftMid.next = previous;

        // Step-3 : compare values of both halfs
        ListNode first = head;
        ListNode second = leftMid.next;
        while(second != null) {
            if(first.val != second.val)
                return false;
            first = first.next;
            second = second.next;
        }
        return true;
    }



    // Approach-2 : finding the left mid node in 1.5 iteration
    public boolean isPalindrome_2(ListNode head) {

        // Step-1 : find the size of linked list
        int size = 0;
        ListNode temp = head;
        while(temp != null){
            temp = temp.next;
            size++;
        }

        // Step-2 : find the previous node of middle node of linked list
        int count = (size%2 == 0) ? (size/2) : (size/2)+1;
        ListNode previousMid = null;
        for(int i=1; i<=count; i++){
            if(previousMid == null) previousMid = head;
            else                    previousMid = previousMid.next;
        }

        // Step-3 : Reverse the 2nd half linkedlist
        ListNode previous = null;
        ListNode current = previousMid.next;
        while(current != null){
            ListNode next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        previousMid.next = previous;

        // Step-4 : compare values of both halfs
        ListNode first = head;
        ListNode second = previousMid.next;
        for(int i=1; i<=size/2; i++ ){
            if(first.val != second.val)
                return false;
            first = first.next;
            second = second.next;
        }
        return true;
    }

}