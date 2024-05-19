package com.sumit.datastructures.h_search.c_2darray;

import com.sumit.utils.DSAUtils;

import java.util.Arrays;

public class SortedMatrix2_Search2 {

    // LeetCode-240 : https://leetcode.com/problems/search-a-2d-matrix-ii/

    public boolean searchMatrix(int[][] matrix, int target) {
        int row = 0, col = matrix[0].length - 1;
        while (row <= matrix.length-1 && col >= 0) {
            if (target == matrix[row][col])
                return true;

            if (target > matrix[row][col])   row++;
            else                             col--;
        }
        return false;
    }

    public int[] searchMatrix_index(int[][] matrix, int target) {
        int row = 0, col = matrix[0].length - 1;
        while (row <= matrix.length-1 && col >= 0) {
            if (target == matrix[row][col])
                return new int[]{row, col};

            if (target > matrix[row][col])   row++;
            else                             col--;
        }
        return new int[]{-1, -1};
    }


    public static void main(String[] args) {
        SortedMatrix2_Search2 obj = new SortedMatrix2_Search2();
        int[][] matrix = DSAUtils.getRowColSortedMatrix();

        int target1 = 37;
        System.out.println("target : "+ target1 +" => indexes : " + obj.searchMatrix(matrix, target1));
        System.out.println("target : "+ target1 +" => indexes : " + Arrays.toString(obj.searchMatrix_index(matrix, target1)));
        System.out.println();

        int target2 = 10;
        System.out.println("target : "+ target2 +" => indexes : " + obj.searchMatrix(matrix, target2));
        System.out.println("target : "+ target2 +" => indexes : " + Arrays.toString(obj.searchMatrix_index(matrix, target2)));
        System.out.println();

        int target3 = 100;
        System.out.println("target : "+ target3 +" => indexes : " + obj.searchMatrix(matrix, target3));
        System.out.println("target : "+ target3 +" => indexes : " + Arrays.toString(obj.searchMatrix_index(matrix, target3)));
        System.out.println();

        int target4 = -100;
        System.out.println("target : "+ target4 +" => indexes : " + obj.searchMatrix(matrix, target4));
        System.out.println("target : "+ target4 +" => indexes : " + Arrays.toString(obj.searchMatrix_index(matrix, target4)));
    }


}