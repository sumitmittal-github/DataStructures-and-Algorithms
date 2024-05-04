package com.sumit.datastructures.l_linkedlist.questions;

public class LL_Q10_DeleteGivenNode {

    // LeetCode-237 : https://leetcode.com/problems/delete-node-in-a-linked-list/description/

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

}