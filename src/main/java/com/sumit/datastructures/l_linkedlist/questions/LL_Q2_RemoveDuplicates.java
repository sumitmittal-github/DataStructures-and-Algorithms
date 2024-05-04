package com.sumit.datastructures.l_linkedlist.questions;

public class LL_Q2_RemoveDuplicates {

    // LeetCode-83 : https://leetcode.com/problems/remove-duplicates-from-sorted-list/description/

    public static void main(String[] args) {
        LL_Q2_RemoveDuplicates obj = new LL_Q2_RemoveDuplicates();

        ListNode ll1_way1 = new ListNode(1, new ListNode(1, new ListNode(2, null)));
        display(ll1_way1);
        display(obj.deleteDuplicates_1(ll1_way1));
        System.out.println("--------------------");

        ListNode ll1_way2 = new ListNode(1, new ListNode(1, new ListNode(2, null)));
        display(ll1_way2);
        display(obj.deleteDuplicates_1(ll1_way2));
        System.out.println("--------------------");

        ListNode ll2_way1 = new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3, null)))));
        display(ll2_way1);
        display(obj.deleteDuplicates_1(ll2_way1));
        System.out.println("--------------------");

        ListNode ll2_way2 = new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3, null)))));
        display(ll2_way2);
        display(obj.deleteDuplicates_1(ll2_way2));
    }

    // Way-1 : using iteration
    public ListNode deleteDuplicates_1(ListNode head) {
        if(head == null)
            return null;

        ListNode node = head;
        while(node.next != null){
            if(node.val == node.next.val){
               node.next = node.next.next;
            } else{
                node = node.next;
            }
        }
        return head;
    }




    // Way-2 : using recursion
    public ListNode deleteDuplicates_2(ListNode head) {
        helper(head);
        return head;
    }

    public void helper(ListNode node){
        if(node == null){
            return;
        }

        if(node.next != null && node.val == node.next.val){
            node.next = node.next.next;
            helper(node);
        } else {
            helper(node.next);
        }
    }

    public static void display(ListNode head){
        ListNode node = head;
        while(node != null){
            System.out.print(node.val + " -> ");
            node = node.next;
        }
        System.out.println("null");
    }


}