package com.sumit.datastructures.l_linkedlist.questions;

public class LL_Q24_Rotate {

    // LeetCode-61 : https://leetcode.com/problems/rotate-list/description/

    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null)
            return head;
        if(k <= 0)
            return head;

        // We need to identify below nodes and attach them at correct nodes -
        // oldHead         = head
        // newHeadPrevious = node at (listLength-rotationCount)
        // newHead         = node at (listLength-rotationCount+1)
        // tail            = node at (listLength)
        ListNode oldHead = head;



        // STEP-1 : iterate once to identify the listLength and tail node
        int listLength = 0;
        ListNode tail = null;

        ListNode temp = head;
        while(temp != null) {
            if(temp.next == null) tail = temp;
            listLength++;
            temp = temp.next;
        }


        // identify position of the node which will be Previous of new head node
        int actualRotationCount = k % listLength;
        if(actualRotationCount == 0)
            return head;
        int positionOfNewHeadPrevious = listLength - actualRotationCount;



        // STEP-2 : iterate again to identify - newHeadPrevious, newHead
        ListNode newHeadPrevious = null;
        ListNode newHead = null;

        int listIndex = 1;
        ListNode temp2 = head;
        while(temp2 != null){

            // identify the newHeadPrevious and newHead
            if(listIndex == positionOfNewHeadPrevious){
                newHeadPrevious = temp2;
                newHead = temp2.next;
                break;
            }

            listIndex++;
            temp2 = temp2.next;
        }

        // STEP-3 : attach head and tail to correct nodes
        newHeadPrevious.next = null;
        tail.next = oldHead;
        head = newHead;

        return head;
    }


}