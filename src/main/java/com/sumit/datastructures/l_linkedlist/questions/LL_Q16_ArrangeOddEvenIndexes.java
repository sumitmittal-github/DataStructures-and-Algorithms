package com.sumit.datastructures.l_linkedlist.questions;

public class LL_Q16_ArrangeOddEvenIndexes {

    // LeetCode-328 : https://leetcode.com/problems/odd-even-linked-list/description/

    public static void main(String[] args) {
        ListNode q1 = new ListNode(1,
                            new ListNode(2,
                                new ListNode(3,
                                        new ListNode(4,
                                                new ListNode(5, null)))));
        LL_Q16_ArrangeOddEvenIndexes obj = new LL_Q16_ArrangeOddEvenIndexes();
        display(obj.oddEvenIndexesList(q1));

        ListNode q2 = new ListNode(2,
                            new ListNode(1,
                                new ListNode(3,
                                        new ListNode(5,
                                            new ListNode(6,
                                                    new ListNode(4,
                                                            new ListNode(7, null)))))));
        display(obj.oddEvenIndexesList(q2));
    }

    public ListNode oddEvenIndexesList(ListNode head) {
        if(head == null || head.next == null || head.next.next == null)
            return head;

        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;

        while(even != null && even.next != null) {
            odd.next = odd.next.next;
            even.next = even.next.next;

            odd = odd.next;
            even = even.next;
        }

        // attach even indexes nodes behind the odd Linked list
        odd.next = evenHead;
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
}