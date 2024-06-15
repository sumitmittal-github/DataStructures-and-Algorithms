package com.sumit.utils;

import com.sumit.datastructures.l_linkedlist.a_singly.ListNode;
import com.sumit.datastructures.l_linkedlist.a_singly.ListNodeRandom;

import java.util.List;

public class DSAUtils {

    public static int[][] getSortedMatrix(int row, int column){
        int element = 1;

        int[][] matrix = new int[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                matrix[i][j] = element++;
            }
        }
        return matrix;
    }

    public static int[][] getRowColSortedMatrix(){
        int[][] matrix = {
                {10, 20, 30, 40},
                {15, 25, 35, 45},
                {28, 29, 37, 49},
                {33, 34, 55, 60}
        };
        return matrix;
    }

    public static void printInt2DArray(int[][] sum) {
        for(int i=0; i<sum.length; i++){
            for(int j=0; j<sum[i].length; j++) {
                System.out.print(sum[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void printIntList(List<Integer> row) {
        for(Integer element : row) {
            System.out.print(element + " ");
        }
        System.out.println();
    }


    public static void printIntListOfList(List<List<Integer>> triangle) {
        for(List<Integer> row : triangle){
            for(Integer element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }



    public static void displayLinkedList(ListNode head){
        ListNode temp = head;
        while(temp != null){
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void displayRandomLinkedList(ListNodeRandom head){
        ListNodeRandom temp = head;
        while(temp != null){
            if(temp.random != null)   System.out.print(temp.val + " -- " + temp.random.val + " -> ");
            else                      System.out.print(temp.val + " -- " + null            + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
}