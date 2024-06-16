package com.sumit.datastructures.f_linkedlist.a_singly.collegewallah;

import com.sumit.datastructures.f_linkedlist.a_singly.ListNode;

public class Q1_DeleteGivenNode {

    // LeetCode-237 : https://leetcode.com/problems/delete-node-in-a-linked-list/description/

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

}