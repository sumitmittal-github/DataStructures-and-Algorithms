package com.sumit.datastructures.l_linkedlist.a_singly.collegewallah;

import com.sumit.datastructures.l_linkedlist.a_singly.ListNode;

public class Q3_FindIntersectionNode {

    // LeetCode-160 : https://leetcode.com/problems/intersection-of-two-linked-lists/description/

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

        Q3_FindIntersectionNode obj = new Q3_FindIntersectionNode();
        System.out.println(obj.findIntersectionNode(node11, node21).val);
    }


    public ListNode findIntersectionNode(ListNode head1, ListNode head2){
        if(head1 == null || head2 == null)
            return null;

        // means both heads are pointing to the same lists
        if(head1 == head2)
            return head1;

        ListNode temp1 = head1;
        ListNode temp2 = head2;

        // STEP-1 : get length of both the lists
        int length1 = length(temp1);
        int length2 = length(temp2);

        // STEP-2 : forward the bigger list head diff times
        if(length1 > length2) {
            int diff = length1 - length2;
            for (int i = 1; i <= diff; i++) {
                temp1 = temp1.next;
            }
        } else{
            int diff = length2 - length1;
            for (int i = 1; i <= diff; i++) {
                temp2 = temp2.next;
            }
        }

        // STEP-3 : forward both head till they meet
        while(temp1 != temp2) {
            temp1 = temp1.next;
            temp2 = temp2.next;
        }

        return temp1;
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