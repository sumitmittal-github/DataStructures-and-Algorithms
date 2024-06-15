package com.sumit.datastructures.l_linkedlist.a_singly.collegewallah;

import com.sumit.datastructures.l_linkedlist.a_singly.ListNode;
import com.sumit.utils.DSAUtils;

public class Q10_ArrangeOddEvenValues {

    /** Program :
        Given a linked list, arrange this ist such that odd values should come first and even values should come later.
        You must solve the program in O(1) extra space complexity and O(n) time complexity

        Input: head = [1,2,3,4,5]
        Output:       [1,3,5,2,4]

        Input:  head = [2,1,3,5,6,4,7]
        Output:        [1,3,5,7,2,6,4]
    */

    public ListNode oddEvenList(ListNode head) {
        if(head == null)            return null;
        if(head.next == null)       return head;

        // adding dummy head node
        ListNode tempOdd = new ListNode(0, null);
        ListNode tempOddHead = tempOdd;

        ListNode tempEven = new ListNode(0, null);
        ListNode tempEvenHead = tempEven;

        ListNode temp = head;
        while(temp != null) {
            if((temp.val & 1) == 1) {
                tempOdd.next = temp;
                tempOdd = tempOdd.next;
            } else {
                tempEven.next = temp;
                tempEven = tempEven.next;
            }
            temp = temp.next;
        }

        // check if first node was odd or even
        tempEven.next = null;                   // last node of even should point to null
        tempOdd.next = tempEvenHead.next;       // to skip the dummy node of even elements
        return tempOddHead.next;
    }



    public static void main(String[] args) {
        ListNode q1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, null)))));
        Q10_ArrangeOddEvenValues obj = new Q10_ArrangeOddEvenValues();
        DSAUtils.displayLinkedList(obj.oddEvenList(q1));

        ListNode q2 = new ListNode(2, new ListNode(1, new ListNode(3, new ListNode(5, new ListNode(6, new ListNode(4, new ListNode(7, null)))))));
        DSAUtils.displayLinkedList(obj.oddEvenList(q2));
    }

}