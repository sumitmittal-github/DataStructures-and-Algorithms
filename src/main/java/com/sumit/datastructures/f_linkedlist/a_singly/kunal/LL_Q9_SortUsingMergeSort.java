package com.sumit.datastructures.f_linkedlist.a_singly.kunal;

import com.sumit.datastructures.f_linkedlist.a_singly.ListNode;

public class LL_Q9_SortUsingMergeSort {

    // LeetCode-148 : https://leetcode.com/problems/sort-list/description/


    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null)
            return head;

        // STEP-1 : Get the Middle node (left middle) and break this list in 2 parts
        ListNode leftMidNode = getLeftMidNode(head);
        ListNode list2 = leftMidNode.next;          // create list 2 node separately so that we can break the connection in list1 and list2
        leftMidNode.next = null;                    // break connection of list1 and list2

        // STEP-2 : Sort left and sort right
        ListNode left = sortList(head);
        ListNode right = sortList(list2);


        // STEP-3 : Merge both sorted lists
        return merge(left, right);
    }

    public ListNode getLeftMidNode(ListNode head) {
        if(head == null)
            return null;
        if(head.next == null)
            return head;

        ListNode fast = head;
        ListNode slow = head;
        while(fast.next != null && fast.next.next != null){
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


    public static void main(String[] args) {
        // Program-0 : linked list with length = 0
        ListNode q0_ll1 = null;
        display(new LL_Q9_SortUsingMergeSort().sortList(q0_ll1));

        // Program-1 : linked list with length = 1
        ListNode q1_ll1 = new ListNode(1, null);
        display(new LL_Q9_SortUsingMergeSort().sortList(q1_ll1));

        // Program-2 : linked list with length = 2
        ListNode q2_ll1 = new ListNode(2, null);
        ListNode q2_ll2 = new ListNode(1, null);
        q2_ll1.next = q2_ll2;
        display(new LL_Q9_SortUsingMergeSort().sortList(q2_ll1));

        // Program-3 : linked list with length = 3
        ListNode q3_ll1 = new ListNode(1, null);
        ListNode q3_ll2 = new ListNode(3, null);
        ListNode q3_ll3 = new ListNode(2, null);
        q3_ll1.next = q3_ll2;
        q3_ll2.next = q3_ll3;
        display(new LL_Q9_SortUsingMergeSort().sortList(q3_ll1));

        // Program-4 : linked list with length = 4
        ListNode q4_ll1 = new ListNode(3, null);
        ListNode q4_ll2 = new ListNode(4, null);
        ListNode q4_ll3 = new ListNode(2, null);
        ListNode q4_ll4 = new ListNode(1, null);
        q4_ll1.next = q4_ll2;
        q4_ll2.next = q4_ll3;
        q4_ll3.next = q4_ll4;
        display(new LL_Q9_SortUsingMergeSort().sortList(q4_ll1));

        // Program-5 : linked list with length = 5
        ListNode q5_ll1 = new ListNode(5, null);
        ListNode q5_ll2 = new ListNode(3, null);
        ListNode q5_ll3 = new ListNode(4, null);
        ListNode q5_ll4 = new ListNode(1, null);
        ListNode q5_ll5 = new ListNode(2, null);
        q5_ll1.next = q5_ll2;
        q5_ll2.next = q5_ll3;
        q5_ll3.next = q5_ll4;
        q5_ll4.next = q5_ll5;
        display(new LL_Q9_SortUsingMergeSort().sortList(q5_ll1));
    }

}