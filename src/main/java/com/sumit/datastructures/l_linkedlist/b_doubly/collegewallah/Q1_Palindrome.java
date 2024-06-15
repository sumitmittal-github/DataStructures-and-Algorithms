package com.sumit.datastructures.l_linkedlist.b_doubly.collegewallah;

import com.sumit.datastructures.l_linkedlist.b_doubly.DoublyLinkedList;
import com.sumit.datastructures.l_linkedlist.b_doubly.ListNodeD;

public class Q1_Palindrome {

    // Question : check if a given doubly linked list is palindrome
    public boolean isPalindrome(ListNodeD head){
        if(head == null)            return false;
        if(head.next == null)       return true;

        // Step-1 : find the tail now
        ListNodeD tail = head;
        while(tail.next != null)
            tail = tail.next;

        // Step-2 : iterate till head and tail meets
        ListNodeD h = head;
        ListNodeD t = tail;
        while(h != t && t != h.previous){
            if(h.val != t.val)      return false;
            h = h.next;
            t = t.previous;
        }
        return true;
    }

    public static void main(String[] args) {
        Q1_Palindrome obj = new Q1_Palindrome();

        DoublyLinkedList list1 = new DoublyLinkedList();
        list1.insertAtTail(1);     list1.insertAtTail(2);     list1.insertAtTail(1);
        list1.display();
        System.out.println(obj.isPalindrome(list1.get(0)));
        System.out.println();
        
        DoublyLinkedList list2 = new DoublyLinkedList();
        list2.insertAtTail(1);     list2.insertAtTail(1);
        list2.display();
        System.out.println(obj.isPalindrome(list2.get(0)));
        System.out.println();
        
        DoublyLinkedList list3 = new DoublyLinkedList();
        list3.insertAtTail(1);     list3.insertAtTail(2);
        list3.display();
        System.out.println(obj.isPalindrome(list3.get(0)));
        System.out.println();
        
        DoublyLinkedList list4 = new DoublyLinkedList();
        list4.insertAtTail(1);     list4.insertAtTail(2);     list4.insertAtTail(3);
        list4.display();
        System.out.println(obj.isPalindrome(list4.get(0)));
    }

}