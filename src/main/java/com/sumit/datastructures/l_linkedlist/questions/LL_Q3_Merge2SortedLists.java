package com.sumit.datastructures.l_linkedlist.questions;

public class LL_Q3_Merge2SortedLists {

    //LeetCode-21 : https://leetcode.com/problems/merge-two-sorted-lists/description/

    public static void main(String[] args) {
        ListNode ll1 = new ListNode(1, new ListNode(2, new ListNode(4, null)));
        ListNode ll2 = new ListNode(1, new ListNode(3, new ListNode(4, null)));

        ListNode ans = new LL_Q3_Merge2SortedLists().mergeTwoLists(ll1, ll2);
        new LL_Q3_Merge2SortedLists().display(ans);
    }


    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null && list2 == null)
            return null;
        if(list1 == null)
            return list2;
        if(list2 == null)
            return list1;

        // adding dummy head node
        ListNode output = new ListNode(0, null);
        ListNode head = output;
        while(list1 != null || list2 != null) {
            if (list1 != null && list2 != null) {
                if(list1.val < list2.val){
                    output.next = new ListNode(list1.val, null);
                    list1 = list1.next;
                }
                else {
                    output.next = new ListNode(list2.val, null);
                    list2 = list2.next;
                }
            }
            else if(list1 == null) {
                output.next = new ListNode(list2.val, null);
                list2 = list2.next;
            } else {
                output.next = new ListNode(list1.val, null);
                list1 = list1.next;
            }
            output = output.next;
        }

        // returning merged list where we removed the dummy head
        return head.next;
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