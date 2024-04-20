package com.sumit.datastructures.l_linkedlist.questions;

public class LL_Q13_FindIntersectionNode {

    //LeetCode-160 : https://leetcode.com/problems/intersection-of-two-linked-lists/description/

    public static void main(String[] args) {
        ListNode node11 = new ListNode(87, null);
        ListNode node12 = new ListNode(100, null);
        ListNode node13 = new ListNode(13, null);
        ListNode node14 = new ListNode(4, null);
        ListNode node15 = new ListNode(5, null);
        ListNode node16 = new ListNode(12, null);
        ListNode node17 = new ListNode(10, null);
        node11.next = node12;
        node12.next = node13;
        node13.next = node14;
        node14.next = node15;
        node15.next = node16;
        node16.next = node17;

        ListNode node21 = new ListNode(90, new ListNode(9, node15));

        LL_Q13_FindIntersectionNode obj = new LL_Q13_FindIntersectionNode();
        System.out.println(obj.findIntersectionNode(node11, node21).val);
    }


    public ListNode findIntersectionNode(ListNode head1, ListNode head2){
        if(head1 == null || head2 == null)
            return null;

        // means both heads are pointing to the same lists
        if(head1 == head2)
            return head1;

        ListNode tempHead1 = head1;
        ListNode tempHead2 = head2;


        // STEP-1 : get length of both the lists
        int length1 = length(tempHead1);
        int length2 = length(tempHead2);


        // STEP-2 : forward the bigger list head diff times
        if(length1 > length2) {
            int diff = length1 - length2;
            while(diff != 0){
                tempHead1 = tempHead1.next;
                diff--;
            }
        } else{
            int diff = length2 - length1;
            while(diff != 0){
                tempHead2 = tempHead2.next;
                diff--;
            }
        }


        // STEP-3 : forward both head till they meet
        while(tempHead1 != tempHead2) {
            tempHead1 = tempHead1.next;
            tempHead2 = tempHead2.next;
        }

        return tempHead1;
    }


    public int length(ListNode head){
        int length = 0;

        ListNode temp = head;
        while(temp != null){
            ++length;
            temp = temp.next;
        }
        return length;
    }

}