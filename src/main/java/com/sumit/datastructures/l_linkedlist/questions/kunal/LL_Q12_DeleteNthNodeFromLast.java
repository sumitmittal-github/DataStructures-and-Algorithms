package com.sumit.datastructures.l_linkedlist.questions.kunal;

public class LL_Q12_DeleteNthNodeFromLast {


    public static void main(String[] args) {
        ListNode q1_ll1 = new ListNode(13,
                                new ListNode(1,
                                    new ListNode(100,
                                            new ListNode(50,
                                                    new ListNode(20, null)))));
        LL_Q12_DeleteNthNodeFromLast obj = new LL_Q12_DeleteNthNodeFromLast();
        display(q1_ll1);

        /*ListNode q1 = obj.deleteNthNodeFromLast_Approach2(q1_ll1, 1);
        display(q1);

        ListNode q2 = obj.deleteNthNodeFromLast_Approach2(q1_ll1, 2);
        display(q2);

        ListNode q3 = obj.deleteNthNodeFromLast_Approach2(q1_ll1, 3);
        display(q3);

        ListNode q4 = obj.deleteNthNodeFromLast_Approach2(q1_ll1, 4);
        display(q4);*/

        ListNode q5 = obj.deleteNthNodeFromLast_Approach2(q1_ll1, 5);
        display(q5);
    }


    public ListNode deleteNthNodeFromLast_Approach2(ListNode head, int n){
        if(head == null || head.next == null)
            return null;

        // STEP-1 : forward fast n times
        ListNode fast = head;
        ListNode slow = head;
        for(int i=1; i<= n; i++){
            fast = fast.next;
        }

        // corner case where we want to delete the head node ( n = #nodes in the LL)
        if(fast == null) {
            head = head.next;
            return head;
        }

        // STEP-2 : forward fast & slow pointers, until fast.next == null
        while(fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // now slow is pointing to the previous node of the node which we want to delete
        slow.next = slow.next.next;
        return head;
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