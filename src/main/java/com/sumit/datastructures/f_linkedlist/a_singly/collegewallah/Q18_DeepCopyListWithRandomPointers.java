package com.sumit.datastructures.f_linkedlist.a_singly.collegewallah;

import com.sumit.datastructures.f_linkedlist.a_singly.ListNodeRandom;
import com.sumit.utils.DSAUtils;

public class Q18_DeepCopyListWithRandomPointers {

    // LeetCode-138 : https://leetcode.com/problems/copy-list-with-random-pointer/description/
    // https://www.geeksforgeeks.org/a-linked-list-with-next-and-arbit-pointer/

    /**
     Given a linked list of size N where each node has two links:
        - one pointer points (next) to the next node
        - the second pointer points (random) to any node in the list.
     The task is to create a clone of this linked list in O(N) time.

     Note: The pointer pointing to the next node is ‘next‘ pointer and the one pointing to an arbitrary node
           is called ‘random’ pointer as it can point to any arbitrary node in the linked list.
    */


    public ListNodeRandom copyRandomList(ListNodeRandom head) {
        if(head == null)     return null;

        // Step-1 : create deep copy list with correct values
        ListNodeRandom temp = head;
        while(temp != null) {
            ListNodeRandom node = new ListNodeRandom(temp.val, temp.next);
            temp.next = node;
            temp = temp.next.next;
        }

        // Step-2 : assign random pointers
        ListNodeRandom tempp = head;
        while(tempp != null){
            if(tempp.random != null)    tempp.next.random = tempp.random.next;
            else                        tempp.next.random = null;

            tempp = tempp.next.next;
        }

        // Step-3 : Cleanup : detach the lists
        ListNodeRandom head2 = head.next;
        ListNodeRandom temp1 = head;
        ListNodeRandom temp2 = head2;
        while(temp1 != null){
            temp1.next = temp1.next.next;
            if(temp2.next != null)  temp2.next = temp2.next.next;
            //else                  temp2.next = null;
            temp1 = temp1.next;
            temp2 = temp2.next;
        }

        return head2;
    }


    public static void main(String[] args) {
        ListNodeRandom head = new ListNodeRandom(7);
        ListNodeRandom n2 = new ListNodeRandom(13);
        ListNodeRandom n3 = new ListNodeRandom(11);
        ListNodeRandom n4 = new ListNodeRandom(10);
        ListNodeRandom n5 = new ListNodeRandom(1);
        head.next = n2;     head.random = null;
        n2.next = n3;     n2.random = head;
        n3.next = n4;     n3.random = n5;
        n4.next = n5;     n4.random = n3;
        n5.next = null;   n5.random = head;

        Q18_DeepCopyListWithRandomPointers obj = new Q18_DeepCopyListWithRandomPointers();
        DSAUtils.displayRandomLinkedList(head);

        ListNodeRandom head2 = obj.copyRandomList(head);
        DSAUtils.displayRandomLinkedList(head2);
    }

}