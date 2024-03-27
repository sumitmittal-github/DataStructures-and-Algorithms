package com.sumit.datastructures.h_search.c_2darray;

import java.util.Arrays;

public class SortedMatrix1_RowAndCol {

    public static void main(String[] args) {
        int[][] matrix = {
                {10, 20, 30, 40},
                {15, 25, 35, 45},
                {28, 29, 37, 49},
                {33, 34, 55, 60}
        };

        int target1 = 37;
        System.out.println("target : "+ target1 +" => indexes : " + Arrays.toString(search(matrix, target1)));

        int target2 = 10;
        System.out.println("target : "+ target2 +" => indexes : " + Arrays.toString(search(matrix, target2)));

        int target3 = 100;
        System.out.println("target : "+ target3 +" => indexes : " + Arrays.toString(search(matrix, target3)));

        int target4 = -100;
        System.out.println("target : "+ target4 +" => indexes : " + Arrays.toString(search(matrix, target4)));
    }

    private static int[] search(int[][] matrix, int target) {
        int row=0;
        int col = matrix.length-1;

        while(row <= matrix.length-1 && col >= 0){
            int element = matrix[row][col];
            if(target == element)
                return new int[]{row, col};
            else if(target > element)
                row++;
            else
                col--;
        }
        return new int[]{-1, -1};
    }

}