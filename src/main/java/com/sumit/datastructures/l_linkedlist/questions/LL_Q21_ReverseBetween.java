package com.sumit.datastructures.l_linkedlist.questions;

public class LL_Q21_ReverseBetween {

    // LeetCode-92 : https://leetcode.com/problems/reverse-linked-list-ii/description/

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head == null || head.next == null)
            return head;

        // if left == right, then it means that only 1 need need to be reversed. It means no change in the list
        if(left == right)
            return head;



        //STEP-1: get the previous node of left node (from where we will start reversing the list)
        ListNode previousNodeOfLeft = null;
        ListNode nodeOfLeft = head;
        for(int i=1; i<left; i++) {
            if(previousNodeOfLeft == null) {
                previousNodeOfLeft = head;
            } else{
                previousNodeOfLeft = previousNodeOfLeft.next;
            }
            nodeOfLeft = nodeOfLeft.next;
        }



        // STEP-2 : iterate till right index of linked list and reverse it
        ListNode previous = previousNodeOfLeft;
        ListNode current = nodeOfLeft;
        while(left <= right){
            ListNode next = current.next;
            current.next = previous;
            previous = current;
            current = next;
            left++;
        }
        // At the end of the above while loop :
        // 1). previous is pointing to the node at index(right)
        // 2). current and next is pointing to the node at index(right+1)
        ListNode nodeOfRight = previous;
        ListNode nextNodeOfRight = current;



        // STEP-3 : attach node at index(left) to node(right+1)
        //        : attach node at index(left-1) to node(right)
        nodeOfLeft.next = nextNodeOfRight;
        if(previousNodeOfLeft != null)
            previousNodeOfLeft.next = nodeOfRight;
        else
            head = nodeOfRight;

        return head;
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
        ListNode head = new ListNode(1,
                new ListNode(2,
                        new ListNode(3,
                                new ListNode(4,
                                        new ListNode(5, null)))));

        LL_Q21_ReverseBetween obj = new LL_Q21_ReverseBetween();
        display(obj.reverseBetween(head, 2, 4));
    }
}