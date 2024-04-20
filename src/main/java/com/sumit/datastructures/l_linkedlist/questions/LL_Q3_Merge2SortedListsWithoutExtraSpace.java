package com.sumit.datastructures.l_linkedlist.questions;

public class LL_Q3_Merge2SortedListsWithoutExtraSpace {

    //LeetCode-21 : https://leetcode.com/problems/merge-two-sorted-lists/description/

    public static void main(String[] args) {
        ListNode ll1 = new ListNode(1, new ListNode(2, new ListNode(5, null)));
        ListNode ll2 = new ListNode(1, new ListNode(3, new ListNode(4, null)));

        LL_Q3_Merge2SortedListsWithoutExtraSpace obj = new LL_Q3_Merge2SortedListsWithoutExtraSpace();

        display(obj.mergeTwoLists(ll1, ll2));
    }


    public ListNode mergeTwoLists(ListNode head1, ListNode head2) {
        ListNode list1 = head1;
        ListNode list2 = head2;

        if(list1 == null && list2 == null)
            return null;
        if(list1 == null)
            return list2;
        if(list2 == null)
            return list1;


        // adding dummy head node
        ListNode output = new ListNode(0, null);
        ListNode head = output;

        while(list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                output.next = list1;
                output = output.next;
                list1 = list1.next;
            } else {
                output.next = list2;
                output = output.next;
                list2 = list2.next;
            }
        }

        if (list1 != null) {
            output.next = list1;
        }
        if (list2 != null) {
            output.next = list2;
        }

        return head.next;
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