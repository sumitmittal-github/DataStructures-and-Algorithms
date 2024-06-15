package com.sumit.datastructures.l_linkedlist.b_doubly.collegewallah;

import com.sumit.datastructures.l_linkedlist.b_doubly.DoublyLinkedList;
import com.sumit.datastructures.l_linkedlist.b_doubly.ListNodeD;

public class Q3_CriticalPoints {

    /**
        Question : find the max distance and max distance between all the critical points.
                   Critical points are the points where slope changes.

     Ex - Doubly LL =  1 - 2 - 5 - 3 - 2 - 7 - 8 - 9 - 1 - 10

     Critical points will be
        - 5 (because 2 < 5 > 3 )
        - 2 (because 3 > 2 < 7 )
        - 9 (because 8 < 9 > 1 )
        - 1 (because 9 > 1 < 10)

        max distance = max number of elements between the farthest critical points
                     = 5 (total 5 elements in the farthest critical points : 5 and 1)

        min distance = min number of elements between the closest critical points
                     = 0 (total 0 elements in the closest critical points : 9 and 1)
    */

    public int criticalPointsMaxDistance(ListNodeD head) {
        if(head == null)    return -1;

        int maxDistance = Integer.MIN_VALUE;
        int tempDistance = -1;

        ListNodeD criticalPoint1 = null;
        ListNodeD criticalPoint2 = null;
        ListNodeD temp = head;
        while(temp != null){
            boolean isCriticalPoint = isCriticalPoint(temp);
            if(isCriticalPoint){
                tempDistance++;
                if(criticalPoint1 == null){
                    criticalPoint1 = temp;
                } else{
                    if(criticalPoint2 == null){
                        criticalPoint2 = temp;
                    } else{
                        criticalPoint1 = criticalPoint2;
                        criticalPoint2 = temp;
                        maxDistance = tempDistance;
                    }
                }
            } else{
                if(tempDistance != -1)
                    tempDistance++;
            }
            temp = temp.next;
        }
        return maxDistance-1;
    }

    public int criticalPointsMinDistance(ListNodeD head){
        if(head == null)    return -1;

        int minDistance = Integer.MAX_VALUE;
        int tempDistance = -1;

        ListNodeD criticalPoint1 = null;
        ListNodeD criticalPoint2 = null;
        ListNodeD temp = head;
        while(temp != null){
            boolean isCriticalPoint = isCriticalPoint(temp);
            if(isCriticalPoint){
                tempDistance++;
                if(criticalPoint1 == null) {
                    criticalPoint1 = temp;
                } else {
                    if(criticalPoint2 == null){
                        criticalPoint2 = temp;
                    } else{
                        criticalPoint1 = criticalPoint2;
                        criticalPoint2 = temp;
                    }
                    minDistance = Math.min(tempDistance, minDistance);
                    tempDistance=0;
                }
            } else {
                if(tempDistance != -1)
                    tempDistance++;
            }
            temp = temp.next;
        }
        return minDistance-1;
    }

    public int findDistance(ListNodeD p1, ListNodeD p2){
        int distance = -1;
        while(p1 != p2){
            distance++;
            p1 = p1.next;
        }
        return distance;
    }

    public boolean isCriticalPoint(ListNodeD node){
        if(node == null || node.next == null || node.previous == null)
            return false;

        if(node.previous.val < node.val && node.next.val < node.val)
            return true;
        else if(node.previous.val > node.val && node.next.val > node.val)
            return true;
        else
            return false;
    }



    public static void main(String[] args) {
        Q3_CriticalPoints obj = new Q3_CriticalPoints();

        DoublyLinkedList list1 = new DoublyLinkedList();
        list1.insertAtTail(1);     list1.insertAtTail(2);     list1.insertAtTail(5);     list1.insertAtTail(3);     list1.insertAtTail(2);
        list1.insertAtTail(7);     list1.insertAtTail(8);     list1.insertAtTail(9);     list1.insertAtTail(1);     list1.insertAtTail(10);
        list1.display();
        System.out.println("Max Distance = " + obj.criticalPointsMaxDistance(list1.get(0)));
        System.out.println("Min Distance = " + obj.criticalPointsMinDistance(list1.get(0)));
        System.out.println();

        DoublyLinkedList list2 = new DoublyLinkedList();
        list2.insertAtTail(1);     list2.insertAtTail(2);     list2.insertAtTail(5);     list2.insertAtTail(3);     list2.insertAtTail(2);
        list2.insertAtTail(7);     list2.insertAtTail(8);     list2.insertAtTail(9);     list2.insertAtTail(1);     list2.insertAtTail(0);
        list2.insertAtTail(-5);     list2.insertAtTail(10);
        list2.display();
        System.out.println("Max Distance = " + obj.criticalPointsMaxDistance(list2.get(0)));
        System.out.println("Min Distance = " + obj.criticalPointsMinDistance(list2.get(0)));
    }

}