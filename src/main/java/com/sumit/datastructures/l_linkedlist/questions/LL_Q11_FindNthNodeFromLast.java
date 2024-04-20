package com.sumit.datastructures.l_linkedlist.questions;

public class LL_Q11_FindNthNodeFromLast {


    public static void main(String[] args) {
        ListNode q1_ll1 = new ListNode(13,
                                new ListNode(1,
                                    new ListNode(100,
                                            new ListNode(50,
                                                    new ListNode(20, null)))));
        LL_Q11_FindNthNodeFromLast obj = new LL_Q11_FindNthNodeFromLast();


        System.out.println(obj.findNthNodeFromLast_Approach1(q1_ll1, 1).val);
        System.out.println(obj.findNthNodeFromLast_Approach2(q1_ll1, 1).val);

        System.out.println(obj.findNthNodeFromLast_Approach1(q1_ll1, 2).val);
        System.out.println(obj.findNthNodeFromLast_Approach2(q1_ll1, 2).val);

        System.out.println(obj.findNthNodeFromLast_Approach1(q1_ll1, 3).val);
        System.out.println(obj.findNthNodeFromLast_Approach2(q1_ll1, 3).val);

        System.out.println(obj.findNthNodeFromLast_Approach1(q1_ll1, 4).val);
        System.out.println(obj.findNthNodeFromLast_Approach2(q1_ll1, 4).val);

        System.out.println(obj.findNthNodeFromLast_Approach1(q1_ll1, 5).val);
        System.out.println(obj.findNthNodeFromLast_Approach2(q1_ll1, 5).val);

        System.out.println(obj.findNthNodeFromLast_Approach1(q1_ll1, 6));
        System.out.println(obj.findNthNodeFromLast_Approach2(q1_ll1, 6));
    }


    // Approach-1 : has 2 iterations
    public ListNode findNthNodeFromLast_Approach1(ListNode head, int n){
        if(head == null || head.next == null)
            return head;

        // STEP-1 : find length of linkedList
        int length = 0;
        ListNode temp = head;
        while(temp != null){
            length++;
            temp = temp.next;
        }

        if(n > length)
            return  null;


        // STEP-2 : find length-n+1 node from starting
        temp = head;   // reset temp variable so that we can reuse it
        for(int i = 1; i < (length-n+1); i++) {
            temp = temp.next;
        }
        return temp;
    }



    // Approach-2 : Better approach because here we have only 1 iteration
    public ListNode findNthNodeFromLast_Approach2(ListNode head, int n){
        if(head == null || head.next == null)
            return head;

        // STEP-1 : forward fast n times
        ListNode fast = head;
        ListNode slow = head;
        while(n != 0 && fast != null){
            n--;
            fast = fast.next;
        }

        if(n != 0)
            return null;

        // STEP-2 : forward fast & slow pointers, until fast == null
        while(fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }



}