package com.sumit.datastructures.l_linkedlist.questions.kunal;

public class LL_Q6_CycleNode {

    // LeetCode-142 : https://leetcode.com/problems/linked-list-cycle-ii/description/

    public static void main(String[] args) {

        // Program-1 : which has a cycle of length : 3
        ListNode q1_ll1 = new ListNode(3, null);
        ListNode q1_ll2 = new ListNode(2, null);
        ListNode q1_ll3 = new ListNode(0, null);
        ListNode q1_ll4 = new ListNode(-4, q1_ll2);
        q1_ll1.next = q1_ll2;
        q1_ll2.next = q1_ll3;
        q1_ll3.next = q1_ll4;
        System.out.println(new LL_Q6_CycleNode().cycleNode(q1_ll1).val);

        // Program-2 : which has a cycle of length : 2
        ListNode q2_ll1 = new ListNode(1, null);
        ListNode q2_ll2 = new ListNode(2, null);
        q2_ll1.next = q2_ll2;
        q2_ll2.next = q2_ll1;
        System.out.println(new LL_Q6_CycleNode().cycleNode(q2_ll1).val);

        // Program-3 : which has a cycle of length : 1
        ListNode q3_ll1 = new ListNode(1, null);
        q3_ll1.next = q3_ll1;
        System.out.println(new LL_Q6_CycleNode().cycleNode(q3_ll1).val);

        // Program-4 : which do not have a cycle
        ListNode q4_ll1 = new ListNode(1, null);
        ListNode q4_ll2 = new ListNode(2, null);
        ListNode q4_ll3 = new ListNode(3, null);
        ListNode q4_ll4 = new ListNode(4, null);
        q4_ll1.next = q4_ll2;
        q4_ll2.next = q4_ll3;
        q4_ll3.next = q4_ll4;
        System.out.println(new LL_Q6_CycleNode().cycleNode(q4_ll1));

        // Program-5 : which do not have a cycle
        ListNode q5_ll1 = new ListNode(1, null);
        System.out.println(new LL_Q6_CycleNode().cycleNode(q5_ll1));
    }

    public ListNode cycleNode(ListNode head) {
        if(head == null || head.next == null)
            return null;

        // STEP-1 : reach inside the cycle
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            // we are in the cycle now
            if(fast == slow)
                break;
        }

        // if(fast != slow), it means cycle was detected, then it means we do not have the cycle node
        if(fast != slow)
            return null;

        // STEP-2 : move the head node and slow until the meet
        ListNode firstPointer = head;
        ListNode secondPointer = slow;
        while(firstPointer != secondPointer){
            firstPointer = firstPointer.next;
            secondPointer = secondPointer.next;
        }

        return firstPointer;
    }

}
