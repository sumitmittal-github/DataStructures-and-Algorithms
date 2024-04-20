package com.sumit.datastructures.l_linkedlist.questions;

public class LL_Q9_SortUsingMergeSort_TODO {

    //LeetCode-148 : https://leetcode.com/problems/sort-list/description/

    public static void main(String[] args) {
        // Question-0 : linked list with length = 0
        ListNode q0_ll1 = null;
        display(new LL_Q9_SortUsingMergeSort_TODO().sortList(q0_ll1));

        // Question-1 : linked list with length = 1
        ListNode q1_ll1 = new ListNode(1, null);
        display(new LL_Q9_SortUsingMergeSort_TODO().sortList(q1_ll1));

        // Question-2 : linked list with length = 2
        ListNode q2_ll1 = new ListNode(1, null);
        ListNode q2_ll2 = new ListNode(2, null);
        q2_ll1.next = q2_ll2;
        display(new LL_Q9_SortUsingMergeSort_TODO().sortList(q2_ll1));

        // Question-3 : linked list with length = 3
        ListNode q3_ll1 = new ListNode(1, null);
        ListNode q3_ll2 = new ListNode(2, null);
        ListNode q3_ll3 = new ListNode(3, null);
        q3_ll1.next = q3_ll2;
        q3_ll2.next = q3_ll3;
        display(new LL_Q9_SortUsingMergeSort_TODO().sortList(q3_ll1));

        // Question-4 : linked list with length = 4
        ListNode q4_ll1 = new ListNode(1, null);
        ListNode q4_ll2 = new ListNode(2, null);
        ListNode q4_ll3 = new ListNode(3, null);
        ListNode q4_ll4 = new ListNode(4, null);
        q4_ll1.next = q4_ll2;
        q4_ll2.next = q4_ll3;
        q4_ll3.next = q4_ll4;
        display(new LL_Q9_SortUsingMergeSort_TODO().sortList(q4_ll1));

        // Question-5 : linked list with length = 5
        ListNode q5_ll1 = new ListNode(1, null);
        ListNode q5_ll2 = new ListNode(2, null);
        ListNode q5_ll3 = new ListNode(3, null);
        ListNode q5_ll4 = new ListNode(4, null);
        ListNode q5_ll5 = new ListNode(5, null);
        q5_ll1.next = q5_ll2;
        q5_ll2.next = q5_ll3;
        q5_ll3.next = q5_ll4;
        q5_ll4.next = q5_ll5;
        display(new LL_Q9_SortUsingMergeSort_TODO().sortList(q5_ll1));
    }

    public ListNode sortList(ListNode head) {
        if(head == null)
            return null;
        if(head.next == null)
            return head;

        ListNode mid = getMiddleNode(head);
        ListNode left = sortList(head);
        ListNode right = sortList(mid);

        return merge(left, right);
    }

    public ListNode getMiddleNode(ListNode head) {
        if(head == null)
            return null;
        if(head.next == null)
            return head;

        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public ListNode merge(ListNode firstList, ListNode secondList) {
        if(firstList == null && secondList == null)
            return null;
        if(firstList == null)
            return secondList;
        if(secondList == null)
            return firstList;

        // adding dummy head node
        ListNode outputList = new ListNode(0, null);
        ListNode outputListHead = outputList;
        while(firstList != null && secondList != null) {
            if(firstList.val < secondList.val) {
                outputList.next = new ListNode(firstList.val, null);
                outputList = outputList.next;
                firstList = firstList.next;
            } else {
                outputList.next = new ListNode(secondList.val, null);
                outputList = outputList.next;
                secondList = secondList.next;
            }
        }
        while(firstList != null) {
            outputList.next = new ListNode(firstList.val, null);
            outputList = outputList.next;
            firstList = firstList.next;
        }
        while(secondList != null) {
            outputList.next = new ListNode(secondList.val, null);
            outputList = outputList.next;
            secondList = secondList.next;
        }

        // returning merged list where we removed the dummy head
        return outputListHead.next;
    }

    public static void display(ListNode head){
        ListNode temp = head;
        while(temp != null){
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

}