package com.sumit.datastructures.l_linkedlist.a_singly.kunal;

import com.sumit.datastructures.l_linkedlist.a_singly.ListNodeRandom;

public class LL_Q20_CopyListWithRandomPointers {

    // LeetCode-138 : https://leetcode.com/problems/copy-list-with-random-pointer/description/

    public static void main(String[] args) {
        ListNodeRandom n1 = new ListNodeRandom(7);
        ListNodeRandom n2 = new ListNodeRandom(13);
        ListNodeRandom n3 = new ListNodeRandom(11);
        ListNodeRandom n4 = new ListNodeRandom(10);
        ListNodeRandom n5 = new ListNodeRandom(1);
        n1.next = n2;     n1.random = null;
        n2.next = n3;     n2.random = n1;
        n3.next = n4;     n3.random = n5;
        n4.next = n5;     n4.random = n3;
        n5.next = null;   n5.random = n1;

        LL_Q20_CopyListWithRandomPointers obj = new LL_Q20_CopyListWithRandomPointers();
        display(n1);
        System.out.println("---");
        display(n1);
        display(obj.copyRandomList(n1));
    }

    public ListNodeRandom copyRandomList(ListNodeRandom head) {
        if(head == null)
            return null;
        if(head.next == null){
            ListNodeRandom temp = new ListNodeRandom(head.val);
            if(head.random != null)
                temp.random = temp;
            return temp;
        }

        // STEP-1 : Create deep copy with just val and next pointers
        ListNodeRandom list1 = head;
        ListNodeRandom list2 = new ListNodeRandom(-1);
        ListNodeRandom list2Head = list2;

        while(list1 != null){
            list2.next = new ListNodeRandom(list1.val);

            list1 = list1.next;
            list2 = list2.next;
        }
        // skip the dummy node
        list2Head = list2Head.next;


        // STEP-2 : create alternate connections in both the lists
        list1 = head;               // reset pointers so that we can reuse them
        list2 = list2Head;          // reset pointers so that we can reuse them
        while(list1 != null && list2 != null){
            ListNodeRandom list1Next = list1.next;
            ListNodeRandom list2Next = list2.next;

            list1.next = list2;
            list2.next = list1Next;

            list1 = list1Next;
            list2 = list2Next;
        }


        // STEP-3 : Assigning random pointers
        list1 = head;               // reset pointers so that we can reuse them
        list2 = list1.next;         // reset pointers so that we can reuse them
        while(list2 != null){

            if(list1.random != null)    list2.random = list1.random.next;
            else                        list2.random = null;

            // whe we will be at the last nodes of both linked lists
            if(list1.next != null && list2.next != null){
                list1 = list1.next.next;
                list2 = list2.next.next;
            } else
                break;
        }


        // STEP-4 : separate both lists nodes from our joint list
        list1 = head;               // reset pointers so that we can reuse them
        list2 = head.next;          // reset pointers so that we can reuse them
        ListNodeRandom l1Head = list1;
        ListNodeRandom l2Head = list2;
        while(list2 != null && list2.next != null) {
            list1.next = list1.next.next;
            list1 = list1.next;

            list2.next = list2.next.next;
            list2 = list2.next;
        }
        list1.next = null;
        list2.next = null;

        // head = l1Head;    not required because we never changed head node
        return l2Head;
    }



    public static void display(ListNodeRandom head){
        ListNodeRandom temp = head;
        while(temp != null){
            //if(temp.random == null)
                System.out.print(temp + " - " + temp.random + " -> ");
            //else
            //    System.out.print(temp.val + " - " + temp.random.val + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
}