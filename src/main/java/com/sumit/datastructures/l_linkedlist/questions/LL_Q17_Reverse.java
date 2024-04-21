package com.sumit.datastructures.l_linkedlist.questions;

public class LL_Q17_Reverse {

    //LeetCode-206 : https://leetcode.com/problems/reverse-linked-list/description/

    public static void main(String[] args) {
        LL_Q17_Reverse obj = new LL_Q17_Reverse();

        ListNode q1 = new ListNode(1,
                            new ListNode(2,
                                    new ListNode(3,
                                            new ListNode(4,
                                                    new ListNode(5, null)))));
        display(q1);
        display(obj.reverseList_iteration(q1));

        ListNode q2 = new ListNode(1, new ListNode(2, null));
        display(q2);
        display(obj.reverseList_iteration(q2));
    }


    // Better approach : because space complexity is O(1)
    public ListNode reverseList_iteration(ListNode head) {
        if(head == null || head.next == null)
            return head;

        ListNode previous = head;
        ListNode current = head.next;

        previous.next = null;
        while(current != null){
            ListNode next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;
    }


    // Not a good approach : because in recursion we maintain call stack, therefore space complexity is O(n)
    public ListNode reverseList_recursion(ListNode node) {
        // STEP-1 : base condition
        if(node.next == null) {
            return node;
        }

        // STEP-2 : call
        ListNode nextNode = reverseList_recursion(node.next);

        // STEP-3 : work
        node.next.next = node;
        node.next = null;
        return nextNode;
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