package com.sumit.datastructures.l_linkedlist.a_singly.collegewallah;

import com.sumit.datastructures.l_linkedlist.a_singly.ListNode;
import com.sumit.utils.DSAUtils;

public class Q9_ArrangeOddEvenIndexes {

    // LeetCode-328 : https://leetcode.com/problems/odd-even-linked-list/description/


    // Approach-1 : Best and short approach
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


    // Approach-2 : slight bigger approach
    public ListNode oddEvenIndexesList2(ListNode head) {
        ListNode oddHead = new ListNode(-1);
        ListNode oddHead2 = oddHead;

        ListNode evenHead = new ListNode(-1);
        ListNode evenHead2 = evenHead;

        int index = 1;
        ListNode temp = head;
        while(temp != null) {
            if( (index & 1) == 1 ){
                oddHead.next = temp;
                oddHead = oddHead.next;
            } else {
                evenHead.next = temp;
                evenHead = evenHead.next;
            }
            index++;
            temp = temp.next;
        }
        evenHead.next = null;
        oddHead.next = evenHead2.next;
        return oddHead2.next;
    }


    public static void main(String[] args) {
        ListNode q1 = new ListNode(1,
                new ListNode(2,
                        new ListNode(3,
                                new ListNode(4,
                                        new ListNode(5, null)))));
        Q9_ArrangeOddEvenIndexes obj = new Q9_ArrangeOddEvenIndexes();
        DSAUtils.displayLinkedList(obj.oddEvenIndexesList(q1));

        ListNode q2 = new ListNode(2,
                new ListNode(1,
                        new ListNode(3,
                                new ListNode(5,
                                        new ListNode(6,
                                                new ListNode(4,
                                                        new ListNode(7, null)))))));
        DSAUtils.displayLinkedList((obj.oddEvenIndexesList2(q2)));
    }
}