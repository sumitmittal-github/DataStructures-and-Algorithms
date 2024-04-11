package com.sumit.datastructures.l_linkedlist.questions;

public class Question5_CycleLength {

    public static void main(String[] args) {

        // Question-1 : which has a cycle of length : 3
        ListNode q1_ll1 = new ListNode(3, null);
        ListNode q1_ll2 = new ListNode(2, null);
        ListNode q1_ll3 = new ListNode(0, null);
        ListNode q1_ll4 = new ListNode(-4, q1_ll2);
        q1_ll1.next = q1_ll2;
        q1_ll2.next = q1_ll3;
        q1_ll3.next = q1_ll4;
        System.out.println(new Question5_CycleLength().cycleLength(q1_ll1));

        // Question-2 : which has a cycle of length : 2
        ListNode q2_ll1 = new ListNode(1, null);
        ListNode q2_ll2 = new ListNode(2, null);
        q2_ll1.next = q2_ll2;
        q2_ll2.next = q2_ll1;
        System.out.println(new Question5_CycleLength().cycleLength(q2_ll1));

        // Question-3 : which has a cycle of length : 1
        ListNode q3_ll1 = new ListNode(1, null);
        q3_ll1.next = q3_ll1;
        System.out.println(new Question5_CycleLength().cycleLength(q3_ll1));

        // Question-4 : which do not have a cycle
        ListNode q4_ll1 = new ListNode(1, null);
        ListNode q4_ll2 = new ListNode(2, null);
        ListNode q4_ll3 = new ListNode(3, null);
        ListNode q4_ll4 = new ListNode(4, null);
        q4_ll1.next = q4_ll2;
        q4_ll2.next = q4_ll3;
        q4_ll3.next = q4_ll4;
        System.out.println(new Question5_CycleLength().cycleLength(q4_ll1));

        // Question-5 : which do not have a cycle
        ListNode q5_ll1 = new ListNode(1, null);
        System.out.println(new Question5_CycleLength().cycleLength(q5_ll1));

    }

    public int cycleLength(ListNode head) {
        int length = 0;
        if(head == null)
            return 0;

        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            // we have in the cycle now
            if(fast == slow){

                // also we can use do-while because we wanted to move slow pointer at least 1 step
                slow = slow.next;
                length++;
                while(fast != slow){
                    slow = slow.next;
                    length++;
                }
                break;
            }
        }
        return length;
    }

}
