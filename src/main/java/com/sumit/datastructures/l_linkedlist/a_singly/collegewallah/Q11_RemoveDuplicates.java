package com.sumit.datastructures.l_linkedlist.a_singly.collegewallah;

import com.sumit.datastructures.l_linkedlist.a_singly.ListNode;
import com.sumit.utils.DSAUtils;

public class Q11_RemoveDuplicates {

    // LeetCode-83 : https://leetcode.com/problems/remove-duplicates-from-sorted-list/description/


    // Approach-1 : using iteration
    public ListNode deleteDuplicates(ListNode head) {
        ListNode temp = head;
        while (temp != null && temp.next != null) {
            if (temp.val == temp.next.val)  temp.next = temp.next.next;
            else                            temp = temp.next;
        }
        return head;
    }


    // Approach-2 : using recursion
    public ListNode deleteDuplicates_2(ListNode head) {
        helper(head);
        return head;
    }
    public void helper(ListNode node){
        if(node == null)
            return;

        if(node.next != null && node.val == node.next.val){
            node.next = node.next.next;
            helper(node);
        } else {
            helper(node.next);
        }
    }


    public static void main(String[] args) {
        Q11_RemoveDuplicates obj = new Q11_RemoveDuplicates();

        ListNode ll1_way1 = new ListNode(1, new ListNode(1, new ListNode(2, null)));
        DSAUtils.displayLinkedList(ll1_way1);
        DSAUtils.displayLinkedList(obj.deleteDuplicates(ll1_way1));
        System.out.println("--------------------");

        ListNode ll1_way2 = new ListNode(1, new ListNode(1, new ListNode(2, null)));
        DSAUtils.displayLinkedList(ll1_way2);
        DSAUtils.displayLinkedList(obj.deleteDuplicates_2(ll1_way2));
        System.out.println("--------------------");

        ListNode ll2_way1 = new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3, null)))));
        DSAUtils.displayLinkedList(ll2_way1);
        DSAUtils.displayLinkedList(obj.deleteDuplicates(ll2_way1));
        System.out.println("--------------------");

        ListNode ll2_way2 = new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3, null)))));
        DSAUtils.displayLinkedList(ll2_way2);
        DSAUtils.displayLinkedList(obj.deleteDuplicates_2(ll2_way2));
    }




}