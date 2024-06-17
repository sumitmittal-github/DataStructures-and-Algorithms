package com.sumit.datastructures.f_linkedlist.b_doubly.collegewallah.Q4_Flatten;

public class Q4_Flatten {

    // Flatten a multi level doubly linked list
    // LeetCode-430 : https://leetcode.com/problems/flatten-a-multilevel-doubly-linked-list/
    // https://www.geeksforgeeks.org/flatten-a-linked-list-with-next-and-child-pointers/


    // Approach-1 : Best way (no recursion)
    public Node flatten_1(Node head) {
        Node curr=head;
        while(curr!=null){
            if(curr.child != null){
                Node tail = findTail(curr.child);
                if(curr.next != null){
                    curr.next.prev=tail;
                }

                tail.next = curr.next;
                curr.next =curr.child;
                curr.child.prev = curr;
                curr.child =null;
            }
            curr = curr.next;
        }
        return head;
    }

    public Node findTail(Node child){
        while(child.next != null){
            child=child.next;
        }
        return child;
    }


    // Approach-2 : with recursion
    public Node flatten_2(Node head){

        Node temp = head;
        while(temp != null){

            Node list1Tail = temp;
            Node list3Head = temp.next;

            // if the node has child node then append all its node in between
            if(temp.child != null){

                // we are assuming that recursion will give us flatten output, so we just need to adjust the pointers
                Node list2Head = flatten_2(temp.child);

                // find list2 tail
                Node list2Tail = list2Head;
                while(list2Tail.next != null){
                    list2Tail = list2Tail.next;
                }

                // attach the lists
                list1Tail.next = list2Head;
                list2Head.prev = list1Tail;

                list2Tail.next = list3Head;
                if(list3Head != null)
                    list3Head.prev = list2Tail;
                temp.child = null;
            }
            temp = temp.next;
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
        node2.prev=node1;       node2.next=node3;
        node3.prev=node2;       node3.next=node4;       node3.child=node7;
        node4.prev=node3;       node4.next=node5;
        node5.prev=node4;       node5.next=node6;
        node6.prev=node5;       node6.next=null;

        node7.prev=null;        node7.next=node8;
        node8.prev=node7;       node8.next=node9;       node8.child=node11;
        node9.prev=node8;       node9.next=node10;
        node10.prev=node9;      node10.next=null;

        node11.prev=null;       node11.next=node12;
        node12.prev=node11;     node12.next=null;


        Q4_Flatten obj = new Q4_Flatten();
        Node ansHead = obj.flatten_1(node1);
        obj.display(ansHead);

        // O/p :     1 <--> 2 <--> 3 <--> 7 <--> 8 <--> 11 <--> 12 <--> 9 <--> 10 <--> 4 <--> 5 <--> 6 <--> null
    }

}