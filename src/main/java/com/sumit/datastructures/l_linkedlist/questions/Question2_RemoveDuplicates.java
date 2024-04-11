package com.sumit.datastructures.l_linkedlist.questions;

public class Question2_RemoveDuplicates {

    // Leet code : https://leetcode.com/problems/remove-duplicates-from-sorted-list/description/

    public static void main(String[] args) {
        ListNode ll1_way1 = new ListNode(1, new ListNode(1, new ListNode(2, null)));
        new Question2_RemoveDuplicates().display(ll1_way1);
        ListNode ll1_way1_ans = new Question2_RemoveDuplicates().deleteDuplicates_1(ll1_way1);
        new Question2_RemoveDuplicates().display(ll1_way1_ans);
        System.out.println("--------------------");

        ListNode ll1_way2 = new ListNode(1, new ListNode(1, new ListNode(2, null)));
        new Question2_RemoveDuplicates().display(ll1_way2);
        ListNode ll1_way2_ans = new Question2_RemoveDuplicates().deleteDuplicates_2(ll1_way2);
        new Question2_RemoveDuplicates().display(ll1_way2_ans);
        System.out.println("--------------------");



        ListNode ll2_way1 = new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3, null)))));
        new Question2_RemoveDuplicates().display(ll2_way1);
        ListNode ll2_way1_ans = new Question2_RemoveDuplicates().deleteDuplicates_1(ll2_way1);
        new Question2_RemoveDuplicates().display(ll2_way1_ans);
        System.out.println("--------------------");

        ListNode ll2_way2 = new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3, null)))));
        new Question2_RemoveDuplicates().display(ll2_way2);
        ListNode ll2_way2_ans = new Question2_RemoveDuplicates().deleteDuplicates_2(ll2_way2);
        new Question2_RemoveDuplicates().display(ll2_way2_ans);
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

    public void display(ListNode head){
        ListNode node = head;
        while(node != null){
            System.out.print(node.val + " -> ");
            node = node.next;
        }
        System.out.println("null");
    }


}