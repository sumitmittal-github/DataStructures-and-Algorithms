package com.sumit.datastructures.l_linkedlist.questions;

public class LL_Q18_Palindrome {

    //LeetCode-234 : https://leetcode.com/problems/palindrome-linked-list/description/

    public static void main(String[] args) {
        LL_Q18_Palindrome obj = new LL_Q18_Palindrome();

        ListNode q1 = new ListNode(1, null);
        display(q1);
        System.out.println(obj.isPalindrome_withoutExtraSpace(q1));
        System.out.println("------");


        ListNode q2 = new ListNode(1, new ListNode(1,null));
        display(q2);
        System.out.println(obj.isPalindrome_withoutExtraSpace(q2));
        System.out.println("------");


        ListNode q3 = new ListNode(1, new ListNode(2,null));
        display(q3);
        System.out.println(obj.isPalindrome_withoutExtraSpace(q3));
        System.out.println("------");


        ListNode q4 = new ListNode(1, new ListNode(2, new ListNode(3,null)));
        display(q4);
        System.out.println(obj.isPalindrome_withoutExtraSpace(q4));
        System.out.println("------");


        ListNode q5 = new ListNode(1, new ListNode(2, new ListNode(1,null)));
        display(q5);
        System.out.println(obj.isPalindrome_withoutExtraSpace(q5));
        System.out.println("------");


        ListNode q6 = new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(3, null))));
        display(q6);
        System.out.println(obj.isPalindrome_withoutExtraSpace(q6));
        System.out.println("------");


        ListNode q7 = new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(1, null))));
        display(q7);
        System.out.println(obj.isPalindrome_withoutExtraSpace(q7));
        System.out.println("------");


        ListNode q8 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(2, new ListNode(1, null)))));
        display(q8);
        System.out.println(obj.isPalindrome_withoutExtraSpace(q8));
        System.out.println("------");
    }

    // Approach-1 : Not a good approach, because here we are taking extra space
    public boolean isPalindrome_withExtraSpace(ListNode head){
        if(head == null)
            return false;
        if(head.next == null)
            return true;

        ListNode list1 = head;
        ListNode list2 = createReverseLinkedList(list1);

        while(list1 != null && list2 != null){

            if(list1.val != list2.val)
                return false;

            list1 = list1.next;
            list2 = list2.next;
        }
        return true;
    }

    public ListNode createReverseLinkedList(ListNode head){
        if(head == null || head.next == null)
            return head;

        ListNode outputHead = new ListNode(head.val, null);

        ListNode current = head.next;
        while(current != null){
            ListNode newNode = new ListNode(current.val, outputHead);
            outputHead = newNode;
            current = current.next;
        }
        return outputHead;
    }





    // Approach-2 : better approach, because here we are not taking any extra space
    public boolean isPalindrome_withoutExtraSpace(ListNode head){
        if(head == null)
            return false;
        if(head.next == null)
            return true;

        // STEP-1 : get middle node of the linked list
        ListNode leftMid = null;
        ListNode fast = head;
        ListNode slow = head;
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        leftMid = slow;
        //System.out.println("MID : "+leftMid.val);


        // STEP-2 : reverse the second half (nodes after the mid) Linked list
        ListNode reverseHead = reverse(leftMid.next);
        //System.out.println("REVERSE HEAD : "+reverseHead.val);


        // STEP-3 : attach the reverse head to the first half of the list
        slow.next = reverseHead;

        // STEP-4 : keep matching head and slow.next to check if palindrome
        ListNode p1 = head;
        ListNode p2 = slow.next;
        while(p2 != null){
            if(p1.val != p2.val)
                return false;
            p1 = p1.next;
            p2 = p2.next;
        }
        return true;
    }

    public ListNode reverse(ListNode head){
        ListNode previous = head;
        ListNode current = head.next;

        previous.next = null;
        while(current != null) {
            ListNode next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;
    }


    public static void display(ListNode head){
        ListNode temp = head;
        while(temp != null){
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

}