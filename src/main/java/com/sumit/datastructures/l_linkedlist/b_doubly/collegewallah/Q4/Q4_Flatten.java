package com.sumit.datastructures.l_linkedlist.b_doubly.collegewallah.Q4;

public class Q4_Flatten {

    // Flatten a multi level doubly linked list
    // LeetCode-430 : https://leetcode.com/problems/flatten-a-multilevel-doubly-linked-list/
    // https://www.geeksforgeeks.org/flatten-a-linked-list-with-next-and-child-pointers/

    public Node flatten(Node head){

        Node temp = head;
        while(temp != null) {
            Node list1Tail = temp;
            Node list2Head = temp.next;

            // if the node has child node then append all its node in between
            if(temp.child != null){

                // we are assuming that recursion will give us flatten output, so we just need to adjust the pointers
                Node childListHead = flatten(temp.child);

                // 1. adjust the list1 and child list pointers
                list1Tail.next = childListHead;
                childListHead.previous = list1Tail;

                // 2. find the tail of child list and adjust the child list and list2 pointers
                Node childListTail = childListHead;
                while(childListTail.next != null){
                    childListTail = childListTail.next;
                }
                childListTail.next = list2Head;
                if(list2Head != null)
                    list2Head.previous = childListTail;
            }
            temp.child = null;   // we have processed the child, hence mark the child null now
            // temp = temp.next;   we can not do that because we have added the child list after temp, therefor use list2Head
            temp = list2Head;
        }
        return head;
    }

    public void display(Node head){
        while(head != null) {
            System.out.print(head.val + " <--> ");
            head = head.next;
        }
        System.out.println("null");
    }



    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        Node node8 = new Node(8);
        Node node9 = new Node(9);
        Node node10 = new Node(10);
        Node node11 = new Node(11);
        Node node12 = new Node(12);

        node1.next = node2;
        node2.previous=node1;       node2.next=node3;
        node3.previous=node2;       node3.next=node4;       node3.child=node7;
        node4.previous=node3;       node4.next=node5;
        node5.previous=node4;       node5.next=node6;
        node6.previous=node5;       node6.next=null;

        node7.previous=null;        node7.next=node8;
        node8.previous=node7;       node8.next=node9;       node8.child=node11;
        node9.previous=node8;       node9.next=node10;
        node10.previous=node9;      node10.next=null;

        node11.previous=null;       node11.next=node12;
        node12.previous=node11;     node12.next=null;


        Q4_Flatten obj = new Q4_Flatten();
        Node ansHead = obj.flatten(node1);
        obj.display(ansHead);

        // O/p :     1 <--> 2 <--> 3 <--> 7 <--> 8 <--> 11 <--> 12 <--> 9 <--> 10 <--> 4 <--> 5 <--> 6 <--> null
    }

}