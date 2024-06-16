package com.sumit.datastructures.f_linkedlist.a_singly.collegewallah;

import com.sumit.datastructures.f_linkedlist.a_singly.ListNode;
import com.sumit.utils.DSAUtils;

public class Q12_RemoveDuplicates2 {

    // LeetCode-82 :  https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/description/

    public ListNode deleteDuplicates(ListNode head) {
        if(head == null)
            return head;

        ListNode nodeToDelete = null;
        ListNode nodeToDeletePrev = null;

        ListNode temp = head;
        while(temp != null && temp.next != null){
            if(temp.val == temp.next.val){
                nodeToDelete = temp;
                temp.next = temp.next.next;
            } else {
                if(nodeToDelete == temp){
                    if(temp == head){
                        head = head.next;
                        temp = head;
                        nodeToDelete = null;
                        nodeToDeletePrev = temp;
                    } else {
                        nodeToDeletePrev.next = nodeToDeletePrev.next.next;
                        temp = temp.next;
                        nodeToDelete = null;
                    }
                } else {
                    nodeToDeletePrev = temp;
                    temp = temp.next;
                }
            }
        }
        if(nodeToDelete == temp){
            if(temp == head)    head = head.next;
            else                nodeToDeletePrev.next = nodeToDeletePrev.next.next;
        }
        return head;
    }


    public static void main(String[] args) {
        Q12_RemoveDuplicates2 obj = new Q12_RemoveDuplicates2();

        ListNode ll1_way1 = new ListNode(1, new ListNode(1, new ListNode(2, null)));
        DSAUtils.displayLinkedList(ll1_way1);
        DSAUtils.displayLinkedList(obj.deleteDuplicates(ll1_way1));
        System.out.println("--------------------");

        ListNode ll2_way1 = new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3, null)))));
        DSAUtils.displayLinkedList(ll2_way1);
        DSAUtils.displayLinkedList(obj.deleteDuplicates(ll2_way1));
        System.out.println("--------------------");
    }

}