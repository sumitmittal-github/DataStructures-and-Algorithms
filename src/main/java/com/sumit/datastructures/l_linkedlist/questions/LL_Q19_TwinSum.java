package com.sumit.datastructures.l_linkedlist.questions;

public class LL_Q19_TwinSum {

    // LeetCode-2130 : https://leetcode.com/problems/maximum-twin-sum-of-a-linked-list/description/

    /** Program :
     find the maximum twin sum of a linked list of even length
     Twin numbers are :
            -number at 0th index and number and length-0 index
            -number at 1st index and number and length-1 index
            -number at 2nd index and number and length-2 index and so on

     Input: head = [1,5,3,2,13,9]
     Ans     = max(   10(1+9),    18(5+13),    5(3+2)   )
             = 18
    */


    public static void main(String[] args) {
        LL_Q19_TwinSum obj = new LL_Q19_TwinSum();
    
        ListNode q1 = null;
        display(q1);
        System.out.println(obj.maxTwinSum(q1));
        System.out.println("------");
    
    
        ListNode q2 = new ListNode(1, new ListNode(7,null));
        display(q2);
        System.out.println(obj.maxTwinSum(q2));
        System.out.println("------");
    
    
        ListNode q3 = new ListNode(1, new ListNode(9, new ListNode(9, new ListNode(25, null))));
        display(q3);
        System.out.println(obj.maxTwinSum(q3));
        System.out.println("------");
    
    
        ListNode q4 = new ListNode(1, new ListNode(9, new ListNode(9, new ListNode(11, null))));
        display(q4);
        System.out.println(obj.maxTwinSum(q4));
        System.out.println("------");
    }

    public int maxTwinSum(ListNode head) {
        if(head == null)
            return 0;
        if(head.next.next == null)
            return head.val + head.next.val;

        // STEP-1 : get the left middle element of the linked list
        ListNode fast = head;
        ListNode slow = head;
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode leftMid = slow;

        // STEP-2 : reverse the second half (nodes after the mid) Linked list
        ListNode reverseHead = reverse(leftMid.next);
        leftMid.next = reverseHead;

        // STEP-3 : keep checking head & leftMid.next nodes to get the maxium sum
        ListNode p1 = head;
        ListNode p2 = leftMid.next;
        int maxSum = Integer.MIN_VALUE;
        while(p2 != null){
            int sum = p1.val + p2.val;
            if(sum > maxSum)
                maxSum = sum;
            p1 = p1.next;
            p2 = p2.next;
        }
        return maxSum;
    }

    public ListNode reverse(ListNode head){
        if(head == null || head.next == null)
            return head;

        ListNode previous = head;
        ListNode current = head.next;

        previous.next = null;
        while(current != null){
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