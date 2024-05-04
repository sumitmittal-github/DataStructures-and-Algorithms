package com.sumit.datastructures.l_linkedlist.questions;

public class LL_Q23_ReverseNodesInKGroup {

    // LeetCode-25 : https://leetcode.com/problems/reverse-nodes-in-k-group/description/
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null)
            return head;
        if(k <= 1)
            return head;


        // STEP-1 : check if we have k nodes available in the remaining linked list
        ListNode list1Tail = null;
        ListNode list2Head = null;
        if(isKNodesPresent(head, k)) {

            // STEP-2 : if yes, then reverse k nodes
            ListNode previous = null;
            ListNode current = head;
            for(int i=0; i<k; i++){
                ListNode next = current.next;
                current.next = previous;
                previous = current;
                current = next;
            }

            //after above code:-
            list1Tail = head;       // the old head is pointing to list1 tail
            head = previous;        // the previous is pointing to new Head of our output list
            list2Head = current;    // the current is pointing to list2 head
        }


        // STEP-3 : Repeat above steps for remaining linked list
        while(isKNodesPresent(list2Head, k)) {

            ListNode previous = null;
            ListNode current = list2Head;
            for(int i=0; i<k; i++){
                ListNode next = current.next;
                current.next = previous;
                previous = current;
                current = next;
            }

            //after above code:-
            list1Tail.next = previous;  // the old head is pointing to list1 tail
            list1Tail = list2Head;      // the old head is pointing to list1 tail
            list2Head = current;        // the current is pointing to list2 head
        }


        // STEP-4 : After finish attach the remaining list (if available)
        if(list2Head != null) {
            list1Tail.next = list2Head;
        }

        return head;
    }

    public boolean isKNodesPresent(ListNode head, int k){
        int count=0;
        ListNode tempNode = head;
        while(tempNode != null){
            count++;
            tempNode = tempNode.next;

            if(count == k)
                return true;
        }
        return false;
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
        LL_Q23_ReverseNodesInKGroup obj = new LL_Q23_ReverseNodesInKGroup();

        ListNode head1 = new ListNode(1,
                new ListNode(2,
                        new ListNode(3,
                                new ListNode(4,
                                        new ListNode(5, null)))));
        display(head1);
        head1 = obj.reverseKGroup(head1, 2);
        display(head1);

        System.out.println("----------------");

        ListNode head2 = new ListNode(1,
                new ListNode(2,
                        new ListNode(3,
                                new ListNode(4,
                                        new ListNode(5,
                                                new ListNode(6, null))))));
        display(head2);
        head2 = obj.reverseKGroup(head2, 2);
        display(head2);

    }


}