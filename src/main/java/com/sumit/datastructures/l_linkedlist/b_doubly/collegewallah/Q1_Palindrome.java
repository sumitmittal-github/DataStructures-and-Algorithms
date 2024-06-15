package com.sumit.datastructures.l_linkedlist.b_doubly.collegewallah;

import com.sumit.datastructures.l_linkedlist.b_doubly.DoublyLinkedList;
import com.sumit.datastructures.l_linkedlist.b_doubly.ListNodeD;

public class Q1_Palindrome {

    // Question : check if a given doubly linked list is palindrome
    public boolean isPalindrome(DoublyLinkedList list){
        if(list == null)            return false;

        ListNodeD head = list.get(0);
        if(head == null)            return false;
        if(head.next == null)       return true;

        // Step-1 : find the tail now
        ListNodeD tail = head;
        while(tail.next != null)
            tail = tail.next;

        // Step-2 : iterate till head and tail meets
        ListNodeD h = head;
        ListNodeD t = tail;
        while(h != t){
            if(t == h.previous)     break;

            if(h.val != t.val)      return false;
            h = h.next;
            t = t.previous;
        }
        return true;
    }

    public static void main(String[] args) {
        Q1_Palindrome obj = new Q1_Palindrome();

        DoublyLinkedList head1 = new DoublyLinkedList();
        head1.insertAtTail(1);     head1.insertAtTail(2);     head1.insertAtTail(1);
        head1.display();
        System.out.println(obj.isPalindrome(head1));
        System.out.println();
        
        DoublyLinkedList head2 = new DoublyLinkedList();
        head2.insertAtTail(1);     head2.insertAtTail(1);
        head2.display();
        System.out.println(obj.isPalindrome(head2));
        System.out.println();
        
        DoublyLinkedList head3 = new DoublyLinkedList();
        head3.insertAtTail(1);     head3.insertAtTail(2);
        head3.display();
        System.out.println(obj.isPalindrome(head3));
        System.out.println();
        
        DoublyLinkedList head4 = new DoublyLinkedList();
        head4.insertAtTail(1);     head4.insertAtTail(2);     head4.insertAtTail(3);
        head4.display();
        System.out.println(obj.isPalindrome(head4));
    }

}