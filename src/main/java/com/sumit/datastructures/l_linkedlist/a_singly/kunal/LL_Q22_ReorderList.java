package com.sumit.datastructures.l_linkedlist.a_singly.kunal;

import com.sumit.datastructures.l_linkedlist.a_singly.ListNode;

public class LL_Q22_ReorderList {

    // LeetCode-143 : https://leetcode.com/problems/reorder-list/description/

    public void reorderList(ListNode head) {

        // if list size is up to 2 nodes, then there will be no change in the list
        if(head == null || head.next == null || head.next.next == null)
            return;


        // STEP-1 : get the left middle node of the linked list
        ListNode fast = head;
        ListNode slow = head;
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode midNode = slow;
        ListNode list2Head = midNode.next;

        // break the connection between both the lists
        midNode.next = null;



        // STEP-2 : reverse the 2nd half of the linked list
        ListNode previous = null;
        ListNode current = list2Head;
        while(current != null){
            ListNode next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        // at the end of the iteration, the previous node is pointing to last node of old list



        // STEP-3 : keep pointing head -> mid.next -> head.next -> mid.next.next -> .......
        ListNode p1 = head;
        ListNode p2 = previous;
        while(p1 != null & p2 != null){
            ListNode p1Next = p1.next;
            ListNode p2Next = p2.next;

            p1.next = p2;
            p2.next = p1Next;

            p1 = p1Next;
            p2 = p2Next;
        }
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
        LL_Q22_ReorderList obj = new LL_Q22_ReorderList();

        ListNode head1 = new ListNode(1,
                            new ListNode(2,
                                    new ListNode(3,
                                            new ListNode(4,
                                                        new ListNode(5, null)))));
        display(head1);
        obj.reorderList(head1);
        display(head1);

        System.out.println("----------------");

        ListNode head2 = new ListNode(1,
                            new ListNode(2,
                                    new ListNode(3,
                                            new ListNode(4,
                                                new ListNode(5,
                                                        new ListNode(6, null))))));
        display(head2);
        obj.reorderList(head2);
        display(head2);

    }

}